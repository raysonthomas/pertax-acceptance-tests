package uk.gov.hmrc.integration.stepdefs.service

import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.selenium.CurrentDriver._


class InsufficientEvidence extends ScalaDsl with EN {


  Then( """^user is on the page with title '(.*)' with correct URL$""") {
    (expectedPageTitle: String) => provisioningCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      val currentUrl = webDriver.getCurrentUrl
      assert(actualPageTitle == expectedPageTitle, s"Page title '$actualPageTitle' is not equal to '$expectedPageTitle'")
      assert(currentUrl == "http://localhost:9232/personal-account/sa-continue?continueUrl=%2Fpersonal-account", "URL not right")
    }
  }

  Then( """^user is on the SA portal page$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      val currentUrl = webDriver.getCurrentUrl
      println(currentUrl)
      assert(currentUrl.equals("http://localhost:9025/ssoout/non-digital?continue=http:%2F%2Flocalhost:8080%2Fself-assessment%2Find%2F111112222%2Ftaxreturn%2F1516%2Foptions")
        || currentUrl.equals("http://localhost:9025/ssoout/non-digital?continue=http:%2F%2Flocalhost:8080%2Fself-assessment%2Find%2F123459876%2Ftaxreturn%2F1516%2Foptions"),
        "URL not as expected")

    }
  }
}