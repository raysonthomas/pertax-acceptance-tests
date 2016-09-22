package uk.gov.hmrc.integration.stepdefs.service

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._

class DeepLink extends ScalaDsl with EN {

  Then( """^user navigates to (.*) page with (.*) url$""") {
    (page:String, url:String) =>
      provisioningCurrentDriver { implicit webDriver =>
        webDriver.get(url)
      }
  }

  Then( """^url ends with (.*)$""") {
        (urlEnd:String) => provisioningCurrentDriver { implicit webDriver =>
          val currentUrl = webDriver.getCurrentUrl
          assert(currentUrl.endsWith(urlEnd), "\n Not the expected end of url")
//          assert(currentUrl.endsWith(pathForTitle(expectedPageTitle)), s"\n current page URL was:\n $currentUrl \nit did not end with:\n ${pathForTitle(expectedPageTitle)}")

        }
      }

  }