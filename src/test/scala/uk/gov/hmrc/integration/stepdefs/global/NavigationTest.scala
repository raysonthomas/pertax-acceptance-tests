package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.page.{LandingPageActions, GlobalActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class NavigationTest extends ScalaDsl with EN with Matchers {

  Given( """^PTA landing page is displayed$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElements(By.cssSelector(".heading-xlarge"))
        .filter(_.getText == "Your account") should not be 'empty
    }
  }

  Given( """^Personal Details link is visible$""") {
    withCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      webDriver.findElements(By.linkText("Personal details")) should not be 'empty
    }
  }

  When( """^(.*) clicks on Personal Details link$""") {
    (user: String) =>
    withCurrentDriver { implicit webDriver =>
      LandingPageActions.clickPersonalDetailsLink
    }
  }

  Then( """^Personal Details page is displayed$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElements(By.cssSelector(".heading-xlarge"))
        .filter(_.getText == "Your Profile") should not be 'empty
    }
  }

  Then( """^Income Tax Estimate Summary is displayed on PTA Landing page$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElements(By.cssSelector(".heading-medium"))
        .filter(_.getText == "Your Income Tax estimate for 2014 to 2015") should not be 'empty
    }
  }

  Then( """^Link to PAYE service is displayed as View your Income Tax estimate$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElements(By.linkText("View your Income Tax estimate")) should not be 'empty
    }
  }

}
