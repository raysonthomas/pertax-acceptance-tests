#!/bin/sh
sbt -Dbrowser=safari-remotec -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=safari-remotef -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=winxp-ie7-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=win7-ie8-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
