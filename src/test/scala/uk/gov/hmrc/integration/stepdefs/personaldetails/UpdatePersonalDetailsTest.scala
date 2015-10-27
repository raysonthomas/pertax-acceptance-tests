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
    (fieldNumber: String, expectedError: String) =>
      withCurrentDriver { implicit webDriver =>
        val pageSource = webDriver.getPageSource
        def searchableString: String = fieldNumber match {
          case "1" => "search-page:error:line1"
          case "2" => "search-page:error:line2"
          case "3" => "search-page:error:line3"
          case "4" => "search-page:error:line4"
          case "5" => "search-page:error:postcode"
          case _ => throw new Exception("The test did not expect such a fieldNumber, check UpdatePersonalDetails.feature")
        }

        val fieldHasError: Boolean = pageSource.contains(searchableString)

        if (expectedError == "None") {
          assert(!fieldHasError, s"\nTest expected .form-field--error:nth-of-type($fieldNumber) to be empty:\nbut it contained an error message (check if test input is correct)")
        }
        if (expectedError != "None") {
          val actualError = webDriver.findElement(By.cssSelector(s".form-field--error:nth-of-type($fieldNumber) .error-notification")).getText
          assert(actualError == expectedError, s"\nerror on the screen is:\n $actualError \nbut it was expected to see:\n $expectedError")
        }
      }
  }

}