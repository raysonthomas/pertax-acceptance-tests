package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class TaxCreditsPagewithoutNPS extends ScalaDsl with EN {

  And( """^user navigates to Tax Credits page$""") {
    () => withCurrentDriver { implicit webDriver =>
        webDriver.get("http://localhost:9232/personal-account/tax-credits-summary")
//      assert(webDriver.getPageSource.contains(expectedText), s"\n'$expectedText' text was not found on the page")
    }
  }


}
