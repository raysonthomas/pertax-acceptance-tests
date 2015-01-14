#!/bin/bash
sbt -Dbrowser=firefox-local -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'