# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [9.1.14] - 2023-07-12
### Fixed
- fix([TDQ-21269](https://jira.talendforge.org/browse/TDQ-21269)): Remove dependency 'm2e' [dataquality-record-linkage]
- fix([TDQ-21269](https://jira.talendforge.org/browse/TDQ-21269)): Remove dependency 'm2e' [dataquality-phone]
- fix([TDQ-21269](https://jira.talendforge.org/browse/TDQ-21269)): Remove dependency 'm2e' [dataquality-standardization]
- fix([TDQ-21269](https://jira.talendforge.org/browse/TDQ-21269)): Remove dependency 'm2e' [dataquality-statistics]
- fix([TDQ-21269](https://jira.talendforge.org/browse/TDQ-21269)): Remove dependency 'm2e' [dataquality-wordnet]
- fix([TDQ-21269](https://jira.talendforge.org/browse/TDQ-21269)): Remove dependency 'm2e' [dataquality-email]
- fix([TDQ-21269](https://jira.talendforge.org/browse/TDQ-21269)): Remove dependency 'm2e' [dataquality-survivorship]
- fix([TDQ-21269](https://jira.talendforge.org/browse/TDQ-21269)): Remove dependency 'm2e' [dataquality-converters]
- fix([TDQ-21269](https://jira.talendforge.org/browse/TDQ-21269)): Remove dependency 'm2e' [dataquality-text-japanese]

## [9.1.13] - 2023-05-11
### Security
- fix([TDQ-21093](https://jira.talendforge.org/browse/TDQ-21093)): Unify jackson-databind version 2.13.4.2 [dataquality-common]
- fix([TDQ-21093](https://jira.talendforge.org/browse/TDQ-21093)): Unify jackson-databind version 2.13.4.2 [dataquality-statistics]
- fix([TDQ-21093](https://jira.talendforge.org/browse/TDQ-21093)): Unify jackson-databind version 2.13.4.2 [dataquality-survivorship]

## [9.1.12] - 2023-01-03
### Security
- fix([TDQ-20585](https://jira.talendforge.org/browse/TDQ-20585)): upgrade daikon to 7.0.5 [dataquality-common]
- fix([TDQ-20585](https://jira.talendforge.org/browse/TDQ-20585)): upgrade daikon to 7.0.5 [dataquality-statistics]

## [9.1.11] - 2022-12-14
### Changed
chore([TDQ-20862](https://jira.talendforge.org/browse/TDQ-20862)): Remove jars from git and download it when build [dataquality-wordnet]
chore([TDQ-20862](https://jira.talendforge.org/browse/TDQ-20862)): Remove jars from git and download it when build [dataquality-survivorship]
chore([TDQ-20862](https://jira.talendforge.org/browse/TDQ-20862)): Remove jars from git and download it when build [dataquality-text-japanese]
### Fixed
- fix([TDQ-20834](https://jira.talendforge.org/browse/TDQ-20834)): Fix SmallestAction not work issue [dataquality-survivorship]
### Security
- fix([TDQ-20851](https://jira.talendforge.org/browse/TDQ-20851)): Upgrade slf4j to 1.7.34 [dataquality-common]
- fix([TDQ-20851](https://jira.talendforge.org/browse/TDQ-20851)): Upgrade slf4j to 1.7.34 [dataquality-record-linkage]
- fix([TDQ-20851](https://jira.talendforge.org/browse/TDQ-20851)): Upgrade slf4j to 1.7.34 [dataquality-phone]
- fix([TDQ-20851](https://jira.talendforge.org/browse/TDQ-20851)): Upgrade slf4j to 1.7.34 [dataquality-sampling]
- fix([TDQ-20851](https://jira.talendforge.org/browse/TDQ-20851)): Upgrade slf4j to 1.7.34 [dataquality-standardization]
- fix([TDQ-20851](https://jira.talendforge.org/browse/TDQ-20851)): Upgrade slf4j to 1.7.34 [dataquality-statistics]
- fix([TDQ-20851](https://jira.talendforge.org/browse/TDQ-20851)): Upgrade slf4j to 1.7.34 [dataquality-wordnet]
- fix([TDQ-20851](https://jira.talendforge.org/browse/TDQ-20851)): Upgrade slf4j to 1.7.34 [dataquality-email]
- fix([TDQ-20851](https://jira.talendforge.org/browse/TDQ-20851)): Upgrade slf4j to 1.7.34 [dataquality-survivorship]
- fix([TDQ-20851](https://jira.talendforge.org/browse/TDQ-20851)): Upgrade slf4j to 1.7.34 [dataquality-converters]
- fix([TDQ-20851](https://jira.talendforge.org/browse/TDQ-20851)): Upgrade slf4j to 1.7.34 [dataquality-text-japanese]

## [9.1.10] - 2022-11-10
### Security
- fix([TDQ-20772](https://jira.talendforge.org/browse/TDQ-20772)): Fix jackson-databind issues (to 2.14.0-rc2) [dataquality-common]
- fix([TDQ-20792](https://jira.talendforge.org/browse/TDQ-20792)): Fix all jackson jar(to 2.13.4) [dataquality-common]
- fix([TDQ-20799](https://jira.talendforge.org/browse/TDQ-20799)): Fix org.apache.commons:commons-text:1.8,1.9(to 1.10.0) [dataquality-common]
- fix([TDQ-20772](https://jira.talendforge.org/browse/TDQ-20772)): Fix jackson-databind issues (to 2.14.0-rc2) [dataquality-statistics]
- fix([TDQ-20792](https://jira.talendforge.org/browse/TDQ-20792)): Fix all jackson jar(to 2.13.4) [dataquality-statistics]
- fix([TDQ-20799](https://jira.talendforge.org/browse/TDQ-20799)): Fix org.apache.commons:commons-text:1.8,1.9(to 1.10.0) [dataquality-statistics]
- fix([TDQ-20772](https://jira.talendforge.org/browse/TDQ-20772)): Fix jackson-databind issues (to 2.14.0-rc2) [dataquality-survivorship]
- fix([TDQ-20792](https://jira.talendforge.org/browse/TDQ-20792)): Fix all jackson jar(to 2.13.4) [dataquality-survivorship]
- fix([TDQ-20798](https://jira.talendforge.org/browse/TDQ-20798)): Fix com.google.protobuf:protobuf-java:3.19.2(to 3.19.6) [dataquality-survivorship]

## [9.1.9] - 2022-10-13
### Removed
- fix([TDQ-20754](https://jira.talendforge.org/browse/TDQ-20754)): remove XStream Core dependency [dataquality-survivorship]

## [9.1.8] - 2022-09-15
### Security
- fix([TDQ-20633](https://jira.talendforge.org/browse/TDQ-20633)): upgrade 'lucene-core' to 8.11.2 [dataquality-standardization]

## [9.1.7] - 2022-08-11
### Changed
- chore([TDQ-20569](https://jira.talendforge.org/browse/TDQ-20569)): upgrade daikon to 6.8.7 [dataquality-common]
- chore([TDQ-20569](https://jira.talendforge.org/browse/TDQ-20569)): upgrade daikon to 6.8.7 [dataquality-statistics]
- fix([TDQ-20485](https://jira.talendforge.org/browse/TDQ-20485)): Upgrade drools to 7.73.0 [dataquality-survivorship]
### Security
- fix([TDQ-20580](https://jira.talendforge.org/browse/TDQ-20580)): Fix Apache Commons Configuration (to 2.8.0) [dataquality-common]
- fix([TDQ-20580](https://jira.talendforge.org/browse/TDQ-20580)): Fix Apache Commons Configuration (to 2.8.0) [dataquality-statistics]

## [9.1.6] - 2022-07-14
### Security
- fix([TDQ-20481](https://jira.talendforge.org/browse/TDQ-20481)): upgrade daikon to 6.8.2 [dataquality-common]
- fix([TDQ-20481](https://jira.talendforge.org/browse/TDQ-20481)): upgrade daikon to 6.8.2 [dataquality-statistics]

## [9.1.5] - 2022-05-12
### Security
- fix([TDQ-20210](https://jira.talendforge.org/browse/TDQ-20210)): Fix jackson-databind issues (to 2.13.2.2) [dataquality-common]
- fix([TDQ-20210](https://jira.talendforge.org/browse/TDQ-20210)): Fix jackson-databind issues (to 2.13.2.2) [dataquality-statistics]

## [9.1.4] - 2022-04-14
### Security
- fix([TDQ-20188](https://jira.talendforge.org/browse/TDQ-20188)): Fix Protocol Buffers [Core] issues (to 3.19.2) [dataquality-survivorship]

## [9.1.3] - 2022-03-03
### Added
- wi([TDQ-20156](https://jira.talendforge.org/browse/TDQ-20156)): Provide a date/time/datetime pattern checker [dataquality-statistics]
### Security
- fix([TDQ-20134](https://jira.talendforge.org/browse/TDQ-20134)): Fix XStream Core issues (to 1.4.19) [dataquality-survivorship]

## [9.1.2] - 2022-02-04
### Changed
- fix([TDQ-20090](https://jira.talendforge.org/browse/TDQ-20090)): export org.talend.dataquality.sampling.collectors package [dataquality-sampling]
### Fixed
- Chore: remove useless avro dependency that pulls too much crap [dataquality-statistics]

## [9.1.1] - 2022-01-07
### Security
- fix([TDQ-20024](https://jira.talendforge.org/browse/TDQ-20024)): upgrade 'log4j-core' to 2.17.1 [dataquality-common]
- fix([TDQ-20024](https://jira.talendforge.org/browse/TDQ-20024)): upgrade 'log4j-core' to 2.17.1 [dataquality-record-linkage]
- fix([TDQ-20024](https://jira.talendforge.org/browse/TDQ-20024)): upgrade 'log4j-core' to 2.17.1 [dataquality-phone]
- fix([TDQ-20024](https://jira.talendforge.org/browse/TDQ-20024)): upgrade 'log4j-core' to 2.17.1 [dataquality-sampling]
- fix([TDQ-20024](https://jira.talendforge.org/browse/TDQ-20024)): upgrade 'log4j-core' to 2.17.1 [dataquality-standardization]
- fix([TDQ-20024](https://jira.talendforge.org/browse/TDQ-20024)): upgrade 'log4j-core' to 2.17.1 [dataquality-statistics]
- fix([TDQ-20024](https://jira.talendforge.org/browse/TDQ-20024)): upgrade 'log4j-core' to 2.17.1 [dataquality-wordnet]
- fix([TDQ-20024](https://jira.talendforge.org/browse/TDQ-20024)): upgrade 'log4j-core' to 2.17.1 [dataquality-email]
- fix([TDQ-20024](https://jira.talendforge.org/browse/TDQ-20024)): upgrade 'log4j-core' to 2.17.1 [dataquality-survivorship]
- fix([TDQ-20024](https://jira.talendforge.org/browse/TDQ-20024)): upgrade 'log4j-core' to 2.17.1 [dataquality-converters]
- fix([TDQ-20024](https://jira.talendforge.org/browse/TDQ-20024)): upgrade 'log4j-core' to 2.17.1 [dataquality-text-japanese]

## [9.1.0] - 2021-12-15
### Changed
- fix([TDQ-19203](https://jira.talendforge.org/browse/TDQ-19203)): Load data in background when opening an analysis [dataquality-record-linkage]
chore([TPRUN-2572](https://jira.talendforge.org/browse/TPRUN-2572)): Bump and homogenize libphonenumber dependencies [dataquality-phone]
chore([TPRUN-2572](https://jira.talendforge.org/browse/TPRUN-2572)): Refactor code and fix javadoc [dataquality-phone]
### Fixed
- fix([TDQ-19849](https://jira.talendforge.org/browse/TDQ-19849)): Add a timeout for 'callback'  [dataquality-email]
### Security
- fix([TDQ-19973](https://jira.talendforge.org/browse/TDQ-19973)): upgrade 'log4j-core' to 2.16.0 [dataquality-common]
- fix([TDQ-19973](https://jira.talendforge.org/browse/TDQ-19973)): upgrade 'log4j-core' to 2.16.0 [dataquality-record-linkage]
- fix([TDQ-19973](https://jira.talendforge.org/browse/TDQ-19973)): upgrade 'log4j-core' to 2.16.0 [dataquality-phone]
- fix([TDQ-19973](https://jira.talendforge.org/browse/TDQ-19973)): upgrade 'log4j-core' to 2.16.0 [dataquality-sampling]
- fix([TDQ-19973](https://jira.talendforge.org/browse/TDQ-19973)): upgrade 'log4j-core' to 2.16.0 [dataquality-standardization]
- fix([TDQ-19973](https://jira.talendforge.org/browse/TDQ-19973)): upgrade 'log4j-core' to 2.16.0 [dataquality-statistics]
- fix([TDQ-19973](https://jira.talendforge.org/browse/TDQ-19973)): upgrade 'log4j-core' to 2.16.0 [dataquality-wordnet]
- fix([TDQ-19973](https://jira.talendforge.org/browse/TDQ-19973)): upgrade 'log4j-core' to 2.16.0 [dataquality-email]
- fix([TDQ-19973](https://jira.talendforge.org/browse/TDQ-19973)): upgrade 'log4j-core' to 2.16.0 [dataquality-survivorship]
- fix([TDQ-19973](https://jira.talendforge.org/browse/TDQ-19973)): upgrade 'log4j-core' to 2.16.0 [dataquality-converters]
- fix([TDQ-19973](https://jira.talendforge.org/browse/TDQ-19973)): upgrade 'log4j-core' to 2.16.0 [dataquality-text-japanese]

## [9.0.2] - 2021-10-14
### Fixed
fix([TPRUN-2248](https://jira.talendforge.org/browse/TPRUN-2248)): Keep field-level properties when cleaning an Avro schema [dataquality-common]
fix([TPRUN-2195](https://jira.talendforge.org/browse/TPRUN-2195)): Update get TimeZone Display Name [dataquality-statistics]

## [9.0.1] - 2021-10-07
### Changed
- fix([TUP-32162](https://jira.talendforge.org/browse/TUP-32162)): Remove all the nl plugins for Talend translations [dataquality-record-linkage]
- fix([TDQ-19770](https://jira.talendforge.org/browse/TDQ-19770)): Unify algorithm name in Match analysis [dataquality-record-linkage]
- fix([TUP-32162](https://jira.talendforge.org/browse/TUP-32162)): Remove all the nl plugins for Talend translations [dataquality-standardization]
### Fixed
- fix([TDQ-19484](https://jira.talendforge.org/browse/TDQ-19484)): tMatchGroup Multi Pass matching inconsistencies [dataquality-record-linkage]
- bug(TPRUN-2142): Discard Time related logical types [dataquality-statistics]
- bug(TPRUN-2200): Avoid crashing when a Locale is not supported in discovery [dataquality-statistics]
### Security
- fix([TDQ-19311](https://jira.talendforge.org/browse/TDQ-19311)): Fix Apache Commons IO issues (to 2.8.0) [dataquality-common]
- fix([TDQ-19616](https://jira.talendforge.org/browse/TDQ-19616)): Fix Apache Commons Compress issue (to 1.21) [dataquality-common]
- fix([TDQ-19311](https://jira.talendforge.org/browse/TDQ-19311)): Fix Apache Commons IO issues (to 2.8.0) [dataquality-record-linkage]
- fix([TDQ-19311](https://jira.talendforge.org/browse/TDQ-19311)): Fix Apache Commons IO issues (to 2.8.0) [dataquality-standardization]
- fix([TDQ-19311](https://jira.talendforge.org/browse/TDQ-19311)): Fix Apache Commons IO issues (to 2.8.0) [dataquality-statistics]
- fix([TDQ-19616](https://jira.talendforge.org/browse/TDQ-19616)): Fix Apache Commons Compress issue (to 1.21) [dataquality-statistics]
- fix([TDQ-19718](https://jira.talendforge.org/browse/TDQ-19718)): Fix Protocol Buffers [Core] issues (to 3.4.0) [dataquality-survivorship]
- fix([TDQ-19719](https://jira.talendforge.org/browse/TDQ-19719)): Fix XStream Core issues (to 1.4.18) [dataquality-survivorship]

## [Unreleased]
### Added
N/A
### Changed
- fix(TUP-32162): Remove all the nl plugins for Talend translations
### Removed
N/A
### Deprecated
N/A
### Fixed
- fix(TDQ-19484): tMatchGroup Multi Pass matching inconsistencies
### Security
- fix(TDQ-19311): Fix Apache Commons IO issues (to 2.8.0)

## [9.0.0] - 2021-06-02
### Added
- feat([TDQ-17919](https://jira.talendforge.org/browse/TDQ-17919)) Golden records will match if new sources added
### Security
- fix([TDQ-19073](https://jira.talendforge.org/browse/TDQ-19073)): Fix JUnit issue

## [9.0.0] - 2021-06-02
### Added
- feat([TDQ-17919](https://jira.talendforge.org/browse/TDQ-17919)) Golden records will match if new sources added [dataquality-record-linkage]
### Changed
- chore(TPRUN-514): Refactor AvroUtils for Discovery processor [dataquality-common]
- chore(TPRUN-979): Refactor AvroUtils for Validation processor [dataquality-common]
- chore(TPRUN-952): Refactor ResizableList [dataquality-common]
- workitem([TPRUN-354](https://jira.talendforge.org/browse/TPRUN-354)): Improve "native" discovery for typed data [dataquality-statistics]
- chore([TPRUN-953](https://jira.talendforge.org/browse/TPRUN-953)): Refactor SortedList [dataquality-statistics]
### Security
- fix([TDQ-19066](https://jira.talendforge.org/browse/TDQ-19066)): Fix jackson-databind issues [dataquality-common]
- fix([TDQ-19073](https://jira.talendforge.org/browse/TDQ-19073)): Fix JUnit issue [dataquality-common]
- fix([TDQ-19045](https://jira.talendforge.org/browse/TDQ-19045)): Update Jackson Databind to 2.11.4 [dataquality-common]
- fix([TDQ-19124](https://jira.talendforge.org/browse/TDQ-19124)): Upgrade Daikon to 5.3.0 [dataquality-common]
- fix([TDQ-19073](https://jira.talendforge.org/browse/TDQ-19073)): Fix JUnit issue [dataquality-record-linkage]
- fix([TDQ-19073](https://jira.talendforge.org/browse/TDQ-19073)): Fix JUnit issue [dataquality-phone]
- fix([TDQ-19073](https://jira.talendforge.org/browse/TDQ-19073)): Fix JUnit issue [dataquality-sampling]
- fix([TDQ-19073](https://jira.talendforge.org/browse/TDQ-19073)): Fix JUnit issue [dataquality-standardization]
- fix([TDQ-18897](https://jira.talendforge.org/browse/TDQ-18897)): Fix org.apache.httpcomponents:httpclient issue [dataquality-statistics]
- fix([TDQ-19066](https://jira.talendforge.org/browse/TDQ-19066)): Fix jackson-databind issues [dataquality-statistics]
- fix([TDQ-19073](https://jira.talendforge.org/browse/TDQ-19073)): Fix JUnit issue [dataquality-statistics]
- fix([TDQ-19045](https://jira.talendforge.org/browse/TDQ-19045)): Update Jackson Databind to 2.11.4 [dataquality-statistics]
- fix([TDQ-19124](https://jira.talendforge.org/browse/TDQ-19124)): Upgrade Daikon to 5.3.0 [dataquality-statistics]
- fix([TDQ-19292](https://jira.talendforge.org/browse/TDQ-19292)): Fix Data Mapper for Jackson issues [dataquality-statistics]
- fix([TDQ-18962](https://jira.talendforge.org/browse/TDQ-18962)): XStream Core high severity issue [dataquality-survivorship]
- fix([TDQ-19065](https://jira.talendforge.org/browse/TDQ-19065)): XStream Core issue [dataquality-survivorship]
- fix([TDQ-19261](https://jira.talendforge.org/browse/TDQ-19261)): XStream Core issues (1.4.16) [dataquality-survivorship]
- fix([TDQ-19243](https://jira.talendforge.org/browse/TDQ-19243)): Fix CWE-95 in ExpressionAction [dataquality-survivorship]
- fix([TDQ-19472](https://jira.talendforge.org/browse/TDQ-19472)): Fix XStream Core issues (to 1.4.17) [dataquality-survivorship]

## [8.3.1] - 2020-11-18
### Fixed
- fix([TDQ-18542](https://jira.talendforge.org/browse/TDQ-18542)) tMatchGroup(t-swoosh):master records should not do the computation when two rule tabs existing [dataquality-record-linkage]
### Security
- fix([TDQ-17694](https://jira.talendforge.org/browse/TDQ-17694)): Fix Jackson Data Mapper Issues [dataquality-common]
- fix([TDQ-18385](https://jira.talendforge.org/browse/TDQ-18385)): Fix Apache Common Codec issues [dataquality-common]
- fix([TDQ-18385](https://jira.talendforge.org/browse/TDQ-18385)): Fix Apache Common Codec issues [dataquality-record-linkage]
- fix([TDQ-18385](https://jira.talendforge.org/browse/TDQ-18385)): Fix Apache Common Codec issues [dataquality-sampling]
- fix([TDQ-17694](https://jira.talendforge.org/browse/TDQ-17694)): Fix Jackson Data Mapper Issues [dataquality-statistics]
- fix([TDQ-18385](https://jira.talendforge.org/browse/TDQ-18385)): Fix Apache Common Codec issues [dataquality-statistics]
- fix([TDQ-18385](https://jira.talendforge.org/browse/TDQ-18385)): Fix Apache Common Codec issues [dataquality-survivorship]

## [8.3.0] - 2020-07-16
### Changed
-[TDQ-18429](https://jira.talendforge.org/browse/TDQ-18429) Upgrade versions of google phone library from 8.10.5 to 8.12.3 [dataquality-phone]
### Fixed
- fix([TDQ-18567](https://jira.talendforge.org/browse/TDQ-18567)): Clean 'orderMap' in ChainNodeMap for a new dataset [dataquality-survivorship]

## [8.2.0] - 2020-06-18
### Added
- feat([TDQ-18441](https://jira.talendforge.org/browse/TDQ-18441)): support 8 additional ISO-8601 datetime patterns and 24 additional time patterns [dataquality-statistics]
### Fixed
- fix([TDQ-18347](https://jira.talendforge.org/browse/TDQ-18347)) Modify the concatenate function when matching: only use the original values to match, but not the concatenated value.  [dataquality-record-linkage]
- chore([TDQ-18091](https://jira.talendforge.org/browse/TDQ-18091)) more clear error message. [dataquality-standardization]

## [8.1.0] - 2020-03-13
### Added
- feat([TDQ-18062](https://jira.talendforge.org/browse/TDQ-18062)): Add StringChecker, StringHandler, TokenizedString and Acronym utility classes in new "character" package [dataquality-common]
### Changed
chore([TDQ-18056](https://jira.talendforge.org/browse/TDQ-18056)): change stack trace to DEBUG level in PhoneHandlerBase for invalid phones [dataquality-phone]
### Fixed
- chore([TDQ-18085](https://jira.talendforge.org/browse/TDQ-18085)): Fix unstable date test using today's date [dataquality-sampling]

## [8.0.0] - 2020-02-03
### Added
- chore([TDQ-17710](https://jira.talendforge.org/browse/TDQ-17710)): Adopt the "Keep a Changelog" format for changelogs [all modules]
- chore([TDQ-17993](https://jira.talendforge.org/browse/TDQ-17993)): Support German timezone strings for any default JVM locale [dataquality-statistics]
### Changed
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): cancel the deprecation of setStoreInvalidValues in Quality Analyzers [dataquality-common]
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): change RandomWrapper class to package protected [dataquality-sampling]
- feat([TDQ-17504](https://jira.talendforge.org/browse/TDQ-17504)): upgrade to lucene 8 in standardization library for studio [dataquality-standardization]
- chore([TDS-764](https://jira.talendforge.org/browse/TDS-764)): adding getter to retrieve statistics map [dataquality-statistics]
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): cancel the deprecation of setStoreInvalidValues in QualityAnalyzer implementations [dataquality-statistics]
### Removed
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): remove deprecated class HiraganaSmall [dataquality-common]
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): remove unused Tests class [dataquality-common]
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): remove unused AllRecordLinkageTests [dataquality-record-linkage]
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): remove unused AllDataqualitySamplingTests class [dataquality-sampling]
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): remove unused AllDQStandardizationTests class [dataquality-standardization]
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): remove deprecated classes EastAsianCharPatternRecognizer, DateTimePatternManager, and CustomDateTimePatternPatternManager [dataquality-statistics]
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): remove a deprecated constructor of ValueQualityAnalyzer [dataquality-statistics]
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): remove deprecated methods in class SystemDateTimePatternManager and TypeInferenceUtils [dataquality-statistics]
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): remove unused AllEmailTests class [dataquality-email]
- chore([TDQ-17788](https://jira.talendforge.org/browse/TDQ-17788)): remove deprecated class MatchDictionaryService [dataquality-survivorship]
### Fixed
- fix([TDQ-17709](https://jira.talendforge.org/browse/TDQ-17709)): fix precision issues to ensure that two records match if the score is greater than or equal to the threshold [dataquality-record-linkage]
- fix([TDQ-17851](https://jira.talendforge.org/browse/TDQ-17851)): improve the performance and support surrogate pair [dataquality-record-linkage]
### Security
- chore([TDQ-17923](https://jira.talendforge.org/browse/TDQ-17923)): Rely on daikon's jackson version (currently 2.10.1) [dataquality-common]

