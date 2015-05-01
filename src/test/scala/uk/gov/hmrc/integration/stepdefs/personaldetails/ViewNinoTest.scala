package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class ViewNinoTest extends ScalaDsl with EN {

  Then( """^NINO '(.*)' is visible$""") { (nino: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".no-margin-top")).filter(_.getText == nino).isEmpty == false,
        s"$nino was not found in '.no-margin-top' field"
      )
    }
  }
}
