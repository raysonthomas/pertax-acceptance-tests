package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.Configuration
import uk.gov.hmrc.integration.utils.TestDataSource._

class NavigationTest extends ScalaDsl with EN {

  When( """^user clicks on '(.*)'.* link$""") {
    (linkName: String) => withCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      GlobalActions.clickLinkThenExplicitWaitForPath(By.linkText(linkName))
    }
  }

  When( """^user clicks on '(.*)' button$""") {
    (id: String) => withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.id(id)).click()
    }
  }

  Then( """^user is on the page with title '(.*)' and URL is as expected$""") {
    (expectedPageTitle: String) => withCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      val currentUrl = webDriver.getCurrentUrl
      assert(currentUrl.endsWith(pathForTitle(expectedPageTitle)), s"\n current page URL was:\n $currentUrl \nit did not end with:\n ${pathForTitle(expectedPageTitle)}")
      assert(actualPageTitle == expectedPageTitle, s"Page title '$actualPageTitle' is not equal to '$expectedPageTitle'")
    }
  }

  Then( """^user navigates to personal tax account$""") {
    () => withCurrentDriver { implicit webDriver =>
      webDriver.get(Configuration("url"))
    }
  }

  When( """^user sees '(.*)' link on the page and its href is as expected$""") {
    (linkName: String) => withCurrentDriver { implicit webDriver =>
      val href = webDriver.findElement(By.partialLinkText(linkName)).getAttribute("href")
      assert(href.endsWith(pathForLink(linkName)), s"\n# '$linkName' link href was '$href'\n# it did not match expected: '${pathForLink(linkName)}'\n")
    }
  }

  Then( """^user does not see '(.*)' link on the page$""") {
    (linkName: String) => withCurrentDriver { implicit webDriver =>
      assert(!webDriver.getPageSource.contains(linkName), s"'$linkName' was found when it should not be present")
    }
  }

}
