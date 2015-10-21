package uk.gov.hmrc.integration.stepdefs.external

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class MarriageAllowance extends ScalaDsl with EN {


  And( """^user sees the MA Link '(.*)' with correct redirection URL '(.*)'$""") {
    (linkName: String, redirectUrl:String) => withCurrentDriver { implicit webDriver =>
      val linkObject = webDriver.findElement(By.linkText(linkName))
      val linkPath = linkObject.getAttribute("href")
      assert(linkPath.equals(redirectUrl), s"$linkPath is not the expected redirection path")
    }
  }

  And( """^user does not see the MA Link '(.*)'$""") {
    (linkName: String) => withCurrentDriver { implicit webDriver =>
      assert(!webDriver.getPageSource.contains(linkName),s"$linkName is present on the page")
    }
  }

}
