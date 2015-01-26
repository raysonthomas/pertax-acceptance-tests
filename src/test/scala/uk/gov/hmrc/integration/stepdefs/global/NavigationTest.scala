package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest.Matchers
import uk.gov.hmrc.integration.page.{LandingPageActions, GlobalActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class NavigationTest extends ScalaDsl with EN with Matchers {

  Given( """^PTA landing page is displayed$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.getTitle shouldBe "Hello John Densmore"
    }
  }

  Given( """^sees the Personal Details link$""") {
    withCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      webDriver.findElements(By.linkText("Personal details")) should not be 'empty
    }
  }

  When( """^John Densmore clicks on Personal Details link$""") {
    withCurrentDriver { implicit webDriver =>
      LandingPageActions.clickPersonalDetailsLink
    }
  }

  Then( """^John Densmore sees Personal Details page$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.getTitle shouldBe "Personal Details"
    }
  }

  Then( """^sees the Income Tax Estimate link$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElements(By.linkText("Tax estimate")) should not be 'empty
    }
  }

}
