package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
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
    (objID: String, expectedError: String) =>
      withCurrentDriver { implicit webDriver =>

        if (expectedError != "") {
          val actualError = webDriver.findElement(By.id(objID + "-error a")).getText
          assert(actualError == expectedError, s"error on the screen is: '$actualError', but it was expected to see: '$expectedError'")
        }

        if (expectedError == "") {
          assert(webDriver.findElements(By.cssSelector(objID + "-error a")).isEmpty, s"it was not expected to have error message in field '${objID}-error a'")
        }

      }
  }

}