package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.Configuration
import uk.gov.hmrc.integration.utils.TestDataSource._

class NavigationTest extends ScalaDsl with EN {

  When( """^user clicks on '(.*)'.* link$""") {
    (linkName: String) => provisioningCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      GlobalActions.clickLinkThenExplicitWaitForPath(By.linkText(linkName))
    }
  }

  When( """^user clicks on '(.*)' button$""") {
    (id: String) => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.id(id)).click()
    }
  }

  Then( """^user is on the page with title '(.*)' and URL is as expected$""") {
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
      webDriver.get(Configuration("url"))
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


}
