package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
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

  When( """^user sees '(.*)' link on the page$""") {
    (linkName: String) => withCurrentDriver { implicit webDriver =>
      val linkObject = webDriver.findElement(By.partialLinkText(linkName))
      val linkPath = linkObject.getAttribute("href")
      assert(linkPath.endsWith(pathFor(linkName)), s"\n# '$linkName' link path was '$linkPath'\n# it did not match expected: '${pathFor(linkName)}'\n")

    }
  }

  Then( """^user is on the page with title '(.*)'$""") {
    (expectedPageTitle: String) => withCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      val currentUrl = webDriver.getCurrentUrl
      assert(currentUrl.endsWith(pathFor(expectedPageTitle)), s"\n current page URL was:\n $currentUrl \nit did not end with:\n ${pathFor(expectedPageTitle)}")
      assert(actualPageTitle == expectedPageTitle, s"Page title '$actualPageTitle' is not equal to '$expectedPageTitle'")
    }
  }

}
