package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class VisibilityTest extends ScalaDsl with EN {

  Then( """^(.*) label is not displayed$""") { (label: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(!webDriver.findElement(By.cssSelector("#content")).getText.contains(s"$label"), s"'$label' was found (it should be missing)")
    }
  }

}
