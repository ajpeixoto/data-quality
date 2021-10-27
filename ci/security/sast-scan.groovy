#!/usr/bin/groovy
def AWS_POD_LABEL = "TDQ-SE-${UUID.randomUUID().toString()}"

def veracodeCredentials = usernamePassword(
        credentialsId: 'veracode-api-credentials',
        passwordVariable: 'VERACODE_KEY',
        usernameVariable: 'VERACODE_ID')

pipeline {
    agent {
        kubernetes {
            label AWS_POD_LABEL
            yamlFile 'ci/podTemplate.yml'
        }
    }
    
    triggers {
         cron(BRANCH_NAME == 'master' ? '0 13 * * 0' : '')
    }

    options {
        // Only keep the 10 most recent builds for master branch, 2 for the other branches
        buildDiscarder(logRotator(artifactNumToKeepStr: '5', numToKeepStr: env.BRANCH_NAME == 'master' ? '10' : '2'))
        disableConcurrentBuilds()
        ansiColor('xterm')
        timeout(time: 1, unit: 'HOURS')
    }

    environment {
        SLACK_CHANNEL = 'tdq_ci'
        VERACODE_APP_NAME = 'data-quality'
        TIMESTAMP = sh(returnStdout: true, script: "date +%Y%m%d_%H%M%S").trim()
    }

    stages {

        stage('Prepare artifacts') {
            steps {
                container('talend-jdk8-builder-base') {
                    configFileProvider([configFile(fileId: 'maven-settings-nexus-zl', variable: 'MAVEN_SETTINGS')]) {
                        sh 'java -version'
                        sh 'mvn --version'
                        sh 'mvn -U clean package -DskipTests -B --fail-at-end -s $MAVEN_SETTINGS'
                    }
                }
            }
        }

        stage('Veracode-Upload-and-Scan') {
            steps {
                container('talend-jdk8-builder-base') {
                    withCredentials([veracodeCredentials]) {
                        veracode applicationName: "$VERACODE_APP_NAME",
                            canFailJob: true,
                            createProfile: false,
                            debug: true,
                            copyRemoteFiles: true,
                            fileNamePattern: '',
                            useProxy: false,
                            replacementPattern: '',
                            scanExcludesPattern: '',
                            scanIncludesPattern: '',
                            scanName: "DQ-${env.BUILD_NUMBER}-${TIMESTAMP}",
                            uploadExcludesPattern: '',
                            uploadIncludesPattern: '**/**.jar',
                            vid: "$VERACODE_ID",
                            vkey: "$VERACODE_KEY"
                    }
                }
            }
        }

    }

    post {
        success {
            script {
                if (env.BRANCH_NAME == 'master' || env.BRANCH_NAME =~ 'maintenance.*') {
                    slackSend(color: '#82bd41', channel: "${SLACK_CHANNEL}", message: "SUCCESS: `${env.JOB_NAME.replaceAll('%2F', '/')}` #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)")
                }
            }
        }
        failure {
            script {
                if (env.BRANCH_NAME == 'master' || env.BRANCH_NAME =~ 'maintenance.*') {
                    slackSend(color: '#e96065', channel: "${SLACK_CHANNEL}", message: "FAILED: `${env.JOB_NAME.replaceAll('%2F', '/')}` #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)")
                }
            }
        }

        unstable {
            script {
                if (env.BRANCH_NAME == 'master' || env.BRANCH_NAME =~ 'maintenance.*') {
                    slackSend(color: '#ea8330', channel: "${SLACK_CHANNEL}", message: "UNSTABLE: `${env.JOB_NAME.replaceAll('%2F', '/')}` #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)")
                }
            }
        }

        aborted {
            script {
                if (env.BRANCH_NAME == 'master' || env.BRANCH_NAME =~ 'maintenance.*') {
                    slackSend(color: '#c6c6c6', channel: "${SLACK_CHANNEL}", message: "ABORTED: `${env.JOB_NAME.replaceAll('%2F', '/')}` #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)")
                }
            }
        }
    }
}
