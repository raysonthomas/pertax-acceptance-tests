package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.jsoup.Jsoup
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._

import scala.collection.JavaConversions._

class UpdatePersonalDetailsTest extends ScalaDsl with EN {

  Then( """^user updates .*'(.*)' with '(.*)'$""") {
    (objID: String, value: String) => withCurrentDriver { implicit webDriver =>
      val field = webDriver.findElement(By.id(objID))
      field.clear()
      field.sendKeys(value)
    }
  }

  // this step definition does nothing if it is not qa environment (because we cant modify address in stubs)
  Then( """^Updated Address '(.*)', '(.*)', '(.*)', '(.*)', '(.*)' should be visible$""") {
    (addressLine1: String, addressLine2: String, addressLine3: String, addressLine4: String, postCode: String) =>
      withCurrentDriver { implicit webDriver =>
        if (System.getProperty("environment", "local").toLowerCase == "qa") {
          val addressElements = Array(addressLine1, addressLine2, addressLine3, addressLine4, postCode).filter(_ != "")
          val expectedAddress = addressElements.mkString("\n")
          val actualAddress = webDriver.findElement(By.cssSelector("address")).getText
          assert(expectedAddress == actualAddress, s"\nexpected address:\n $expectedAddress \ndid not match actual address:\n $actualAddress")
        }
      }
  }

  Then( """^error message for .*'(.*)' is '(.*)'$""") {
    (field: String, expectedError: String) =>
      withCurrentDriver { implicit webDriver =>
        val selectedSource = Jsoup.parse(webDriver.getPageSource).select( s"""input[name="$field"]""").head.parent()

        if (expectedError == "None") {
          assert(!selectedSource.html().contains("error-notification"),
            s"\nTest expected no error for '$field'\nbut it contained an error message (check if test input is correct)")
        }

        if (expectedError != "None") {
          assert(selectedSource.text().contains(expectedError),
            expectedError + " was not in "  + selectedSource.text())
        }

      }
  }

}