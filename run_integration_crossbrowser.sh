#!/bin/sh
sbt -Dbrowser=Iphone5S-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=MacOS-remotef -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=MacOS-remotec -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=winxp-ie7-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=win7-ie8-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
