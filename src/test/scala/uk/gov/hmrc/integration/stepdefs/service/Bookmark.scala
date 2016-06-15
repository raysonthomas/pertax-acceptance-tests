package uk.gov.hmrc.integration.stepdefs.service

import com.sun.jna.platform.win32.Netapi32Util.User
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.support.ui.{WebDriverWait, Select}
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.page.AuthActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils.{Configuration, GGUserProperties}

class Bookmark extends ScalaDsl with EN {


  Then( """^user is redirected to Sign In page and url ends with (.*)$""") {
    (urlEnd: String) => withCurrentDriver { implicit webDriver =>
      val currentUrl = webDriver.getCurrentUrl
      assert(currentUrl.endsWith(urlEnd), "\n Not the expected end of url")
      //          assert(currentUrl.endsWith(pathForTitle(expectedPageTitle)), s"\n current page URL was:\n $currentUrl \nit did not end with:\n ${pathForTitle(expectedPageTitle)}")

    }
  }

  Given( """^(.*) logs into the service using (.*)$""") { (user: String, authProvider: String) =>
    withCurrentDriver { implicit webDriver =>
      AuthActions.logInforBookmark(user, authProvider)
    }
  }
}