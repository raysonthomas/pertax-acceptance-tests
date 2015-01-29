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

  Then( """^Check your income tax link is visible that points to PAYE protocol://host:port/beta10/beta10-index$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElements(By.linkText("Tax estimate")) should not be 'empty
    }
  }

}
