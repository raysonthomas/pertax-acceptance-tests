package uk.gov.hmrc.integration.suites

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features"),
  glue = Array("uk.gov.hmrc.integration.stepdefs"),
  format = Array("pretty",
    "html:target/suite/cucumber-html-report",
    "json:target/suite/cucumber.json"),
  tags = Array("@smoke")
)
class RunSmokeTestSuite {

}
