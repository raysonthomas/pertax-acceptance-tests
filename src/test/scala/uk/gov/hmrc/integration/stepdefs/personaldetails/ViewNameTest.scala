package uk.gov.hmrc.integration.stepdefs

import uk.gov.hmrc.integration.utils.TestDataSource._

import scala.collection.JavaConversions._

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.page.{GlobalActions, IDAActions, LandingPageActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class ViewNameTest extends ScalaDsl with EN with Matchers {

  Given("""^John Densmore has logged in to PTA$""") {
    withCurrentDriver { implicit webDriver =>
      IDAActions.enterURL
      IDAActions.clickLoginStub
    }
  }

  Given("""^PTA landing page is displayed$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.getTitle shouldBe "Hello John Densmore"
    }
  }

  Given("""^sees the Personal Details link$""") {
    withCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      webDriver.findElements(By.linkText("Personal details")) should not be 'empty
    }
  }

  When("""^John Densmore clicks on Personal Details link$""") {
    withCurrentDriver { implicit webDriver =>
      LandingPageActions.clickPersonalDetailsLink
    }
  }

  Then("""^John Densmore sees Personal Details page$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.getTitle shouldBe "Personal Details"
    }
  }

  Then("""^Mr John Densmore is displayed$""") {
    withCurrentDriver { implicit webDriver =>
      val pd = getTestPersonDetailsByName("John Densmore")
      webDriver.findElements(By.cssSelector(".content__body > p"))
        .filter(_.getText == pd.person.titledName) should not be 'empty
    }
  }
}
