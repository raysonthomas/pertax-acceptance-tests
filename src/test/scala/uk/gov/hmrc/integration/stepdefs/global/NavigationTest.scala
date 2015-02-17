package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions

import scala.collection.JavaConversions._

class NavigationTest extends ScalaDsl with EN {

  When( """^'(.*)' clicks on '(.*)' link$""") {
    (user: String, linkName: String) =>
    withCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      GlobalActions.clickLinkThenExplicitWaitForPath(By.linkText(linkName))
    }
  }

  Then( """^'(.*)' page is displayed$""") { (heading: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".heading-xlarge")).filter(_.getText == s"$heading").isEmpty == false,
        s"'$heading' was not found as '.heading-xlarge'"
      )
    }
  }

  Then( """^Income Tax Estimate Summary is displayed on '(.*)' page$""") {
    (pageName: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".heading-medium")).filter(_.getText == "Your Income Tax estimate for 2014 to 2015").isEmpty == false,
        "Your Income Tax estimate for 2014 to 2015 was not found"
      )
    }
  }

  Then( """^Link to PAYE service is displayed as '(.*)'$""") { (linkName: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".column-two-thirds>a")).filter(_.getText == linkName).isEmpty == false,
        s"$linkName was not found"
      )
    }
  }

}
