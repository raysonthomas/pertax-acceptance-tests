package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._
import uk.gov.hmrc.integration.utils.TestDataSource._

class NavigationTest extends ScalaDsl with EN {

  When( """^'(.*)' clicks on '(.*)' .*$""") {
    (user: String, linkName: String) => withCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      GlobalActions.clickLinkThenExplicitWaitForPath(By.linkText(linkName))
    }
  }

  Then( """^user is on the (.*) page$""") {
    (p: String) => withCurrentDriver { implicit webDriver =>
      assert(webDriver.getCurrentUrl.endsWith(pathFor(p)), s"URL path did not end with '${pathFor(p)}'")
    }
  }

  Then( """^Content visible: '(.*)'$""") {
    (expectedContent: String) => withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".heading-medium")).filter(_.getText == expectedContent).nonEmpty,
        s"this content was not found: '$expectedContent' in '.heading-medium'"
      )
    }
  }

  Then( """^Link to PAYE service is displayed as '(.*)'$""") {
    (linkName: String) => withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".column-two-thirds>a")).filter(_.getText == linkName).nonEmpty,
        s"$linkName was not found"
      )
    }
  }

}
