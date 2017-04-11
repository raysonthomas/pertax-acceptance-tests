package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.apache.commons.lang3.StringEscapeUtils
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.support.ui.WebDriverWait
import play.api.libs.json.{JsValue, Json}
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils.{Configuration, GoogleAnalytics}
import uk.gov.hmrc.integration.utils.TestDataSource._

import scala.collection.JavaConversions._

class NavigationTest extends ScalaDsl with EN {



  When( """^user clicks on '(.*)'.* link$""") {
    (linkName: String) => provisioningCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      GlobalActions.clickLinkThenExplicitWaitForPath(By.linkText(linkName))
    }
  }

  When( """^user clicks on visible '(.*)'.* link$""") {
    (linkName: String) => provisioningCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      GlobalActions.clickLinkThenExplicitWaitForPath(By.xpath("(//*[text()='" + linkName + "'])[2]"))
    }
  }

  When( """^user clicks on '(.*)' button$""") {
    (id: String) => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.id(id)).click()
//      Thread.sleep(2000)
     }
  }

  When( """^user waits for select address page$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("/select-address?postcode=FX97+4TU")))
    }
  }

  Then( """^user is on the page with title '(.*)' and URL is as expected$""") {
//        Thread.sleep(2000)
    (expectedPageTitle: String) => provisioningCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      val currentUrl = webDriver.getCurrentUrl
      assert(currentUrl.endsWith(pathForTitle(expectedPageTitle)), s"\n current page URL was:\n $currentUrl \nit did not end with:\n ${pathForTitle(expectedPageTitle)}")
      assert(actualPageTitle == expectedPageTitle, s"Page title '$actualPageTitle' is not equal to '$expectedPageTitle'")
    }
  }

  Then( """^user is on the page with title '(.*)' and URL is correct$""") {
    (expectedPageTitle: String) => provisioningCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      val currentUrl = webDriver.getCurrentUrl
      assert(currentUrl.endsWith("/your-address/sole/thank-you"), "current URL does not end with /your-address/sole/thank-you")
      assert(actualPageTitle == expectedPageTitle, s"Page title '$actualPageTitle' is not equal to '$expectedPageTitle'")
    }
  }

  Then( """^user is not on the page with title '(.*)' and URL is as expected$""") {
    (notExpectedPageTitle: String) => provisioningCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      assert(!(actualPageTitle == notExpectedPageTitle), "Page title not as expected")
    }
  }

  Then( """^user navigates to personal tax account home page$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
//      webDriver.get(Configuration("url"))
      webDriver.get("http://localhost:9232/personal-account")

    }
  }

  When( """^user sees '(.*)' link on the page and its href is as expected$""") {
    (linkName: String) => provisioningCurrentDriver { implicit webDriver =>
      val href = webDriver.findElement(By.partialLinkText(linkName)).getAttribute("href")
      assert(href.endsWith(pathForLink(linkName)), s"\n# '$linkName' link href was '$href'\n# it did not match expected: '${pathForLink(linkName)}'\n")
    }
  }

  Then( """^user does not see '(.*)' link on the page$""") {
    (linkName: String) => provisioningCurrentDriver { implicit webDriver =>
      assert(!webDriver.getPageSource.contains(linkName), s"'$linkName' was found when it should not be present")
    }
  }


  And( """^user is able to see Recommendation section '(.*)'$""") {
    (expectedText: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        assert(webDriver.getPageSource.contains("Popular forms on GOV.UK"), s"\n$expectedText text was not found on the page")
      }
   }
  Then( """^user clicks back button$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      webDriver.navigate().back()

    }
  }

  When( """^user clicks on language '(.*)' link$""") {
    (linkName: String) => provisioningCurrentDriver { implicit webDriver =>
       webDriver.findElement(By.partialLinkText(linkName)).click()
    }
  }

  When( """^user clicks on Help us with our research opens in new window link for user  research$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.partialLinkText("Help us with our research")).click()
    }
  }
}
