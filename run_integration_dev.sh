#!/bin/bash
sbt -Dbrowser=chrome -Denvironment=dev 'test-only uk.gov.hmrc.integration.cucumber.RunDevTestSuite'