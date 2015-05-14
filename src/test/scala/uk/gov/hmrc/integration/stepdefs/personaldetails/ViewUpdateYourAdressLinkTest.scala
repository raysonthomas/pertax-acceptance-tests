package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class ViewUpdateYourAdressLinkTest extends ScalaDsl with EN {
  Then( """^'(.*)' link should be visible$""") {
    (linkName: String) =>
      withCurrentDriver { implicit webDriver =>
        assert(
          webDriver.findElements(By.cssSelector(".column-half.update-address-link")).filter(_.getText == linkName).isEmpty == false,
          s"link: '$linkName' was not found in '.column-half.update-address-link' field"
        )
      }
  }

}
