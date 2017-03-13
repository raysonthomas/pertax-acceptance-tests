#!/bin/bash
#sm --stop PAY_AS_YOU_EARN_STUB
sm --restart PAY_AS_YOU_EARN_STUB -f
sbt -Dbrowser=chrome-local -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'

