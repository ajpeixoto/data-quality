# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [9.1.10] - 2022-11-10
### Security
- fix([TDQ-20772](https://jira.talendforge.org/browse/TDQ-20772)): Fix jackson-databind issues (to 2.14.0-rc2)
- fix([TDQ-20792](https://jira.talendforge.org/browse/TDQ-20792)): Fix all jackson jar(to 2.13.4)
- fix([TDQ-20798](https://jira.talendforge.org/browse/TDQ-20798)): Fix com.google.protobuf:protobuf-java:3.19.2(to 3.19.6)

## [9.1.9] - 2022-10-13
### Removed
- fix([TDQ-20754](https://jira.talendforge.org/browse/TDQ-20754)): remove XStream Core dependency

## [9.1.8] - 2022-09-15

## [9.1.7] - 2022-08-11
### Changed
- fix([TDQ-20485](https://jira.talendforge.org/browse/TDQ-20485)): Upgrade drools to 7.73.0

## [9.1.6] - 2022-07-14

## [9.1.5] - 2022-05-12

## [9.1.4] - 2022-04-14
### Security
- fix([TDQ-20188](https://jira.talendforge.org/browse/TDQ-20188)): Fix Protocol Buffers [Core] issues (to 3.19.2)

## [9.1.3] - 2022-03-03
### Security
- fix([TDQ-20134](https://jira.talendforge.org/browse/TDQ-20134)): Fix XStream Core issues (to 1.4.19)

## [9.1.2] - 2022-02-04

## [9.1.1] - 2022-01-07
### Security
- fix([TDQ-20024](https://jira.talendforge.org/browse/TDQ-20024)): upgrade 'log4j-core' to 2.17.1

## [9.1.0] - 2021-12-15
### Security
- fix([TDQ-19973](https://jira.talendforge.org/browse/TDQ-19973)): upgrade 'log4j-core' to 2.16.0

## [9.0.2] - 2021-10-14

## [9.0.1] - 2021-10-07
### Security
- fix([TDQ-19718](https://jira.talendforge.org/browse/TDQ-19718)): Fix Protocol Buffers [Core] issues (to 3.4.0)
- fix([TDQ-19719](https://jira.talendforge.org/browse/TDQ-19719)): Fix XStream Core issues (to 1.4.18)

## [9.0.0] - 2021-06-02
### Security
- fix([TDQ-18962](https://jira.talendforge.org/browse/TDQ-18962)): XStream Core high severity issue
- fix([TDQ-19065](https://jira.talendforge.org/browse/TDQ-19065)): XStream Core issue
- fix([TDQ-19261](https://jira.talendforge.org/browse/TDQ-19261)): XStream Core issues (1.4.16)
- fix([TDQ-19243](https://jira.talendforge.org/browse/TDQ-19243)): Fix CWE-95 in ExpressionAction
- fix([TDQ-19472](https://jira.talendforge.org/browse/TDQ-19472)): Fix XStream Core issues (to 1.4.17)

## [8.3.1] - 2020-11-18
### Security
- fix([TDQ-18385](https://jira.talendforge.org/browse/TDQ-18385)): Fix Apache Common Codec issues

## [8.3.0] - 2020-07-16
### Fixed
- fix([TDQ-18567](https://jira.talendforge.org/browse/TDQ-18567)): Clean 'orderMap' in ChainNodeMap for a new dataset

## [8.2.0] - 2020-06-18

## [8.1.0] - 2020-03-13

## [8.0.0] - 2020-02-03
### Added
- chore([TDQ-17710](https://jira.talendforge.org/browse/TDQ-17710)): Adopt the "Keep a Changelog" format for changelogs
### Removed
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): remove deprecated class MatchDictionaryService

## [6.2.0] - 2019-01-02
- [TDQ-16242](https://jira.talendforge.org/browse/TDQ-16242) All the rules of Confilt Resolution can not be executed if disable first one rule
    
## [6.0.0] - 2018-07-03
## [5.0.2] - 2018-04-04
- [TDQ-14225](https://jira.talendforge.org/browse/TDQ-14225) output correct conflicting column
  
## [5.0.1] - 2018-03-28
- [TDQ-14176](https://jira.talendforge.org/browse/TDQ-14176) execute rules by the order defined in the UI for tRuleSurvivorship  
    
## [5.0.0] - 2018-02-12
## [4.0.1] - 2017-12-08
- [TDQ-14481](https://jira.talendforge.org/browse/TDQ-14481) multi tenant index
- [TDQ-14308](https://jira.talendforge.org/browse/TDQ-14308) tRuleSurvivorship fails on DataProc (REST APIs) cluster

## [2.1.1] - 2017-09-11
## [2.1.0] - 2017-08-24
- [TDQ-13981](https://jira.talendforge.org/browse/TDQ-13981) when tRuleSurvivorship input data has two groups can not use "fill empty by" function
- [TDQ-13983](https://jira.talendforge.org/browse/TDQ-13983) "Conflict" column doesn't show conflict columnName when rules doesn't resolve the conflict
- [TDQ-13994](https://jira.talendforge.org/browse/TDQ-13994) fix NPE with "Survivor As" function
- [TDQ-13984](https://jira.talendforge.org/browse/TDQ-13984) "Remove Duplicate" can not run with combination of certain rules, the Conflict value show on a wrong row

## [2.0.3] - 2017-06-09
- [TDQ-13798](https://jira.talendforge.org/browse/TDQ-13798) tRuleSurvivorship improvements

## [2.0.2] - 2017-05-09
- [TDQ-13653](https://jira.talendforge.org/browse/TDQ-13653) fixed the issue which result in wrong default survived value

## [2.0.1] - 2017-05-02
## [2.0.0] - 2017-04-07
- [TDQ-12855](https://jira.talendforge.org/browse/TDQ-12855) move to data-quality repo

## [0.9.9] - 2011-12-2
- [TDQ-4092](https://jira.talendforge.org/browse/TDQ-4092) job export issue fixed
- path auto-correction for case-sensitive operation systems.

## [0.9.8] - 2011-11-21
- [TDQ-3986](https://jira.talendforge.org/browse/TDQ-3986) fixed by setting "mvel2.disable.jit" argument
- removed sysout in studio console

## [0.9.7] - 2011-11-17
- Checked "Ignore blanks" option
- Changed "Operation" label to "Value"

## [0.9.6] - 2011-11-15
- [TDQ-3972](https://jira.talendforge.org/browse/TDQ-3972) fixed
- [TDQ-3973](https://jira.talendforge.org/browse/TDQ-3973) rename recNum to TALEND_INTERNAL_ID
- code cleansing

## [0.9.5] - 2011-11-08
- Added Most Complete rule

## [0.9.4] - 2011-10-18
- Reordered rule table column
- Added disativations of parameters in rule table

## [0.9.3] - 2011-10-14
- resolved repository node duplication
- added org.drools.eclipse in survivorship-feature to let tdqte contain it (the plugin is contained in tispe before)
- complete rule code generation (MC, MT)
- equal results are not considered as conflict now
- corrected initialization of rule count expectation

## [0.9.2] - 2011-10-07
- added generation button to tRuleSurvivorship component
- minor modifications in library to adapt rule generation action

## [0.9.1] - 2011-09-26
- resolved a knowledge base initialization problem 
- updated sample rules

## [0.9.0] - 2011-09-20
- first release of survivorship library, this commit contains 4 projects.
