Acceptance tests for Personal Tax Account
=========================================


How to use this ??
--------

1. Clone the project to a directory of your choice
2. On a terminal instance run: "sm --start PERTAX_ALL -f"
(you need service manager installed and configured, check confluence on configuring your laptop https://confluence.tools.tax.service.gov.uk/display/DTRG/02+Laptop+Configuration+%3A+Ubuntu)
3. Navigate to the directory where you have the cloned project
4. Run: "sbt test" (it might say that no tests were executed, but that is a warning about unit tests which are executed (tried) after acceptance tests)

For more details check the RunLocalTestSuite class, thats where the Cucumber Options are (that is where the tests start from)

Crossbrowser Tests
------------------

1. https://www.browserstack.com/local-testing#command-line
2. Download the appropriate binary from the above link
3. Run the Downloaded binary: './BrowserStackLocal *access-key*'
4. You can look up your *access-key* when you log in to BrowserStack with your account.
5. Connection must be established with the same key that is used in the test project:
https://github.tools.tax.service.gov.uk/DDCN/pertax-qa-tests/blob/master/src/test/scala/uk/gov/hmrc/integration/selenium/RemoteWebDriverFactory.scala
5. Once the connection is established, run commands from 'run_integration_crossbrowser.sh' file from project root.
