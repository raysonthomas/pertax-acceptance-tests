#!/bin/bash
sm --stop PAY_AS_YOU_EARN_STUB
sm --start PAY_AS_YOU_EARN_STUB -f
sbt -Dbrowser=firefox-local -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'

