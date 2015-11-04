package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class Recommendations extends ScalaDsl with EN {

  And( """^user is able to see a recommendation section '(.*)'$""") {
    (expectedText: String) => withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedText), s"\n'$expectedText' text was not found on the page")
    }
  }

  And( """^user is not able to see a recommendation section '(.*)'$""") {
    (expectedText: String) => withCurrentDriver { implicit webDriver =>
      assert(!webDriver.getPageSource.contains(expectedText), s"\n'$expectedText' text was found on the page (but it should not be found)")
    }
  }

  And( """^user does not see a recommendation link matching: '(.*)'$""") {
    (linkName: String) => withCurrentDriver { implicit webDriver =>
      assert(!webDriver.getPageSource.contains(linkName), s"$linkName is present on the page")
    }
  }

}
