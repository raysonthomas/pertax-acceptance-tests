#!/bin/sh
#sbt -Dbrowser=winxp-ie6-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=winxp-ie7-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=win7-ie8-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=win7-ie9-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=win7-ie10-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=win7-ie11-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=win8.1-ie11-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=win8-ie10-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=win7-firefox-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=win7-chrome-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=macos-safari7-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=macos-safari8-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=macos-chrome-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=macos-firefox-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=iphone5s-emu-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
#sbt -Dbrowser=galaxys5-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
