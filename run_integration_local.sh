#!/bin/bash

{
sleep 1
echo "use attorney"
echo "db.attorney.drop()"
} | mongo

sbt -Dbrowser=firefox-local -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'