package uk.gov.hmrc.integration.stepdefs.service

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import uk.gov.hmrc.integration.page.GoogleAnalyticsAssertions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils.Configuration



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
      assert(currentUrl.equals("http://localhost:9025/ssoout/non-digital?continue=http:%2F%2Flocalhost:9242%2Fself-assessment%2Find%2F111112222%2Ftaxreturn%2F1617%2Foptions")
        || currentUrl.equals("http://localhost:9025/ssoout/non-digital?continue=http:%2F%2Flocalhost:9242%2Fself-assessment%2Find%2F123459876%2Ftaxreturn%2F1617%2Foptions"),
        "URL not as expected")

    }
  }

  When( """^user sees '(.*)' link on the sa continue page$""") {
    (linkName: String) => provisioningCurrentDriver { implicit webDriver =>
      val href = webDriver.findElement(By.partialLinkText(linkName)).getAttribute("href")
      assert(href.contains("/personal-account/sa-continue?continueUrl") && href.contains("personal-account#"), "href not as expected http://localhost:9232/personal-account/sa-continue?continueUrl=http%3A%2F%2Flocalhost%3A9232%2Fpersonal-account#")
    }
  }

  Then( """user waits for SA Portal page$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("taxreturn%2F1516%2Foptions")))

    }
  }

  And("""^a self-assessment click event is sent with the label '(.*)' to google analytics$""") {
    (eventLabel: String) => provisioningCurrentDriver { implicit webDriver =>
      GoogleAnalyticsAssertions.assertGoogleAnalyticsEventSent("self-assessment", "click", eventLabel)
    }
  }

  And("""^a self-assessment user type event is sent with the label '(.*)' to google analytics$""") {
    (eventLabel: String) => provisioningCurrentDriver { implicit webDriver =>
      GoogleAnalyticsAssertions.assertGoogleAnalyticsEventSent("self-assessment", "pageLoad", eventLabel)
    }
  }

  And("""^a SA-IV-bypass click event is sent with the label '(.*)' to google analytics$""") {
    (eventLabel: String) => provisioningCurrentDriver { implicit webDriver =>
      GoogleAnalyticsAssertions.assertGoogleAnalyticsEventSent("sa-iv-bypass", "click", eventLabel)
    }
  }
}