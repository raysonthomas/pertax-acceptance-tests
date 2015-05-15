package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._
import java.lang.String

class NavigationTest extends ScalaDsl with EN {

  When( """^URL '(.*)' is opened in browser$""") {
    (url: String) => withCurrentDriver { implicit webDriver =>
      GlobalActions.openURL(url)
    }
  }

  When( """^'(.*)' clicks on '(.*)' .*$""") {
    (user: String, linkName: String) => withCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      GlobalActions.clickLinkThenExplicitWaitForPath(By.linkText(linkName))
    }
  }

  Then( """^Page is: '(.*)'$""") {
    (path: String) => withCurrentDriver { implicit webDriver =>
      assert(webDriver.getCurrentUrl.endsWith(path), s"URL path did not end with '$path'")
    }
  }

  Then( """^user is on the home page$""") {
    () => withCurrentDriver { implicit webDriver =>
      assert(webDriver.getCurrentUrl.endsWith("/pertax"), s"URL path did not end with '/pertax'")
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
