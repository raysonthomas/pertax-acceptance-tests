package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa._
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.GoogleAnalyticsAssertions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource.pathForLink



class MCIUser extends ScalaDsl with EN {

  And( """^MCI user sees text '(.*)' on the page$""") {
    (expectedText: String) => provisioningCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedText), s"\n'$expectedText' text was not found on the page")
    }
  }


  And("""^an MCI link-click language select event to '(.*)' is sent to google analytics$""") {
    (expectedLang: String) => provisioningCurrentDriver { implicit webDriver =>
      GoogleAnalyticsAssertions.assertGoogleAnalyticsEventSent("link - click", "lang-select", expectedLang)
    }
  }



}
