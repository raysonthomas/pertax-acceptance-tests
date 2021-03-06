package uk.gov.hmrc.integration.cucumber

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features"),
  glue = Array("uk.gov.hmrc.integration.stepdefs"),
//  format = Array("pretty",
//    "html:target/suite/cucumber-html-report",
//    "json:target/suite/cucumber.json"),
  format = Array("pretty", "html:target/cucumber", "json:target/cucumber.json"),
  tags = Array("@suite")
)
class RunTestSuiteAgent {

}
  
