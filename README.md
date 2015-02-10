pertax-qa-test
=========================

Acceptance tests for the Pertax services

If you would like to run tests on all browsers in browserstack, run all the commands at a time, but actually it will run th tests one by one only.

sbt -Dbrowser=winxp-ie6-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=winxp-ie7-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=win7-ie8-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=win7-ie9-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=win7-ie10-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=win7-ie11-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=win8.1-ie11-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=win8-ie10-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=win7-firefox-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=win7-chrome-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=macos-safari7-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=macos-safari8-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=macos-chrome-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=macos-firefox-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=iphone5s-emu-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'
sbt -Dbrowser=samsungGalaxyS5-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'

The above commands, all are working except Safari8, which is the following command, because Browserstack accepts only 80 and 8080 ports for Safari8.
sbt -Dbrowser=macos-safari8-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'

If you would like to test just one browser, then use only one command
sbt -Dbrowser=win7-ie8-remote -Denvironment=local 'test-only uk.gov.hmrc.integration.suites.RunLocalTestSuite'


        
    
    
    
    
 

