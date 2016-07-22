package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class SAActivation extends ScalaDsl with EN {

  And( """^user sees the text '(.*)' on SA page$""") {
    (expectedText: String) => withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedText), s"\n'$expectedText' text was not found on the page")
    }
  }

}
