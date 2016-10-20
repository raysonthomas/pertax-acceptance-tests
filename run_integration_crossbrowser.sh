#!/bin/sh
sm --stop PAY_AS_YOU_EARN_STUB
sm --start PAY_AS_YOU_EARN_STUB -f
#sbt -Dbrowser=winxp-ie6-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent' //out of GDS scope as of 2015
#sbt -Dbrowser=winxp-ie7-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
#sbt -Dbrowser=win7-ie8-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
#sbt -Dbrowser=win7-ie9-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
sbt -Dbrowser=win7-ie10-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
#sbt -Dbrowser=win7-ie11-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
#sbt -Dbrowser=win8.1-ie11-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
#sbt -Dbrowser=win8-ie10-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
#sbt -Dbrowser=win7-firefox-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
#sbt -Dbrowser=win7-chrome-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
#sbt -Dbrowser=macos-safari7-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
#sbt -Dbrowser=macos-safari8-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
#sbt -Dbrowser=macos-chrome-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
#sbt -Dbrowser=macos-firefox-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
#sbt -Dbrowser=iphone5s-emu-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
#sbt -Dbrowser=galaxys5-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'
