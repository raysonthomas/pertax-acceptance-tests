package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class ViewPersonalDetailsTest extends ScalaDsl with EN {

  Then( """^Name '(.*)' is visible$""") { (name: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".no-margin-top")).filter(_.getText == name).isEmpty == false,
        s"$name was not found in '.no-margin-top' field"
      )
    }
  }

  Then( """^NINO '(.*)' is visible$""") { (nino: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".no-margin-top")).filter(_.getText == nino).isEmpty == false,
        s"$nino was not found in '.no-margin-top' field"
      )
    }
  }

  Then( """^Home address '(.*)', '(.*)', '(.*)', '(.*)', '(.*)' should be visible$""") {
    (addressLine1: String, addressLine2: String, addressLine3: String, addressLine4: String, postCode: String) =>
      withCurrentDriver { implicit webDriver =>
        val addressElements = Array(addressLine1, addressLine2, addressLine3, addressLine4, postCode).filter(_ != "")
        val expectedAddress = addressElements.mkString("\n")
        val actualAddress = webDriver.findElement(By.cssSelector("address")).getText
        assert(expectedAddress == actualAddress, s"$expectedAddress did not match $actualAddress")
      }
  }

}