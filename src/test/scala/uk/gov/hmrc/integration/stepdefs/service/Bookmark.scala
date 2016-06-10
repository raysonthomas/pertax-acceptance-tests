package uk.gov.hmrc.integration.stepdefs.service

import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class Bookmark extends ScalaDsl with EN {


  Then( """^user is redirected to Sign In page and url ends with (.*)$""") {
    (urlEnd:String) => withCurrentDriver { implicit webDriver =>
          val currentUrl = webDriver.getCurrentUrl
          assert(currentUrl.endsWith(urlEnd), "\n Not the expected end of url")
//          assert(currentUrl.endsWith(pathForTitle(expectedPageTitle)), s"\n current page URL was:\n $currentUrl \nit did not end with:\n ${pathForTitle(expectedPageTitle)}")

        }
      }

  }