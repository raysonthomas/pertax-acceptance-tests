package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._
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
      webDriver.findElement(By.cssSelector(id)).click()
    }
  }

  Then( """^user is on the page with title '(.*)'$""") {
    (expectedPageTitle: String) => withCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      assert(webDriver.getCurrentUrl.endsWith(pathFor(expectedPageTitle)), s"URL path did not end with '${pathFor(expectedPageTitle)}'")
      assert(actualPageTitle == expectedPageTitle, s"Page title '$actualPageTitle' is not equal to '$expectedPageTitle'")
    }
  }

}
