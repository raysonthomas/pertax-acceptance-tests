package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class ViewAddressTest extends ScalaDsl with EN {

  Then( """^Current Address '(.*)', '(.*)', '(.*)', '(.*)', '(.*)' should be visible$""") {
    (addressLine1: String, addressLine2: String, addressLine3: String, addressLine4: String, postCode: String) =>
      withCurrentDriver { implicit webDriver =>
        val fullAddress = s"$addressLine1\n$addressLine2\n$addressLine3\n$addressLine4\n$postCode"
        assert(webDriver.findElement(By.cssSelector("address")).getText == fullAddress, s"$fullAddress was not found")
      }
  }

}