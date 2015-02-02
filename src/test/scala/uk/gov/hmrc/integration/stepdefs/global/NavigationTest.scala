package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.{LandingPageActions, GlobalActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class NavigationTest extends ScalaDsl with EN {

  Given( """^PTA landing page is displayed$""") {
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".heading-xlarge")).filter(_.getText == "Your account").isEmpty == false,
        "'Your account' was not found"
      )
    }
  }

  When( """^(.*) clicks on Personal Details link$""") {
    (user: String) =>
    withCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      LandingPageActions.clickPersonalDetailsLink
    }
  }

  Then( """^Personal Details page is displayed$""") {
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".heading-xlarge")).filter(_.getText == "Your personal details").isEmpty == false,
        "Your personal details was not found"
      )
    }
  }

  Then( """^Income Tax Estimate Summary is displayed on PTA Landing page$""") {
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".heading-medium")).filter(_.getText == "Your Income Tax estimate for 2014 to 2015").isEmpty == false,
        "Your Income Tax estimate for 2014 to 2015 was not found"
      )
    }
  }

  Then( """^Link to PAYE service is displayed as (.*)$""") { (linkName: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".column-two-thirds>a")).filter(_.getText == linkName).isEmpty == false,
        s"$linkName was not found"
      )
    }
  }

}
