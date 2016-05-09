package uk.gov.hmrc.integration.stepdefs.GA

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class GA extends ScalaDsl with EN {

  And( """^'(.*)' link has Google Analytics tracking enabled$""") { (link: String) =>
  withCurrentDriver { implicit webDriver =>
    val nameOfClass:String = webDriver.findElement(By.linkText(link)).getAttribute("class")
    assert((nameOfClass == "trackLink"), "Expected classname not found for GA")
  }
 }
}