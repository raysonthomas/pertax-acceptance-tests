package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class Recommendations extends ScalaDsl with EN {

  And( """^user is able to see a recommendation section '(.*)'$""") {
    (expectedText: String) => withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains("Popular forms on GOV.UK"), s"\n$expectedText text was not found on the page")
    }
  }

  And( """^user sees a recommendation link: '(.*)' that would redirect him to: '(.*)'$""") {
    (linkName: String, redirectUrl: String) => withCurrentDriver { implicit webDriver =>
      val linkObject = webDriver.findElement(By.linkText(linkName))
      val linkPath = linkObject.getAttribute("href")
      assert(linkPath.equals(redirectUrl), s"$linkPath is not the expected redirection path")
    }
  }

  And( """^user does not see a recommendation link matching: '(.*)'$""") {
    (linkName: String) => withCurrentDriver { implicit webDriver =>
      assert(!webDriver.getPageSource.contains(linkName), s"$linkName is present on the page")
    }
  }

}
