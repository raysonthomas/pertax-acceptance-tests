#!/bin/bash
sbt -Dbrowser=win-firefox-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=win-chrome-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=safari-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
