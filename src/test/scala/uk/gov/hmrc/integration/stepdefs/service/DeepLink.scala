package uk.gov.hmrc.integration.stepdefs.service

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.Configuration
import uk.gov.hmrc.integration.utils.TestDataSource._

class DeepLink extends ScalaDsl with EN {

  Then( """^user navigates to (.*) page with (.*) url$""") {
    (page:String, URL:String) =>
      provisioningCurrentDriver { implicit webDriver =>
        webDriver.get(Configuration("url") + "/gg-sign-in?continue=" + URL)
      }
  }

  Then( """^user tries navigating to (.*) page with (.*) url$""") {
    (page:String, URL:String) =>
      provisioningCurrentDriver { implicit webDriver =>
        webDriver.get(URL)
      }
  }

  Then( """^url ends with (.*)$""") {
        (urlEnd:String) => provisioningCurrentDriver { implicit webDriver =>
          val currentUrl = webDriver.getCurrentUrl
          assert(currentUrl.endsWith(urlEnd), "\n Not the expected end of url")

        }
      }

  }