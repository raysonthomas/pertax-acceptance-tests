package uk.gov.hmrc.integration.stepdefs

import uk.gov.hmrc.integration.utils.TestDataSource._

import scala.collection.JavaConversions._

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.page.{GlobalActions, IDAActions, LandingPageActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class ViewNameTest extends ScalaDsl with EN with Matchers {

  Given("""^Ryan Little has logged in to his account$""") {
    withCurrentDriver { implicit webDriver =>
      IDAActions.enterURL
      IDAActions.clickLoginStub
    }
  }

  Given("""^should be on 'Personal tax account' page$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.getTitle shouldBe "Hello John Densmore"
    }
  }

  Given("""^should see the 'Personal details' link$""") {
    withCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      webDriver.findElements(By.linkText("Personal details")) should not be 'empty
    }
  }


  When("""^Ryan Little click on 'Personal details' link$""") {
    withCurrentDriver { implicit webDriver =>
      LandingPageActions.clickPersonalDetailsLink
    }
  }

  Then("""^Ryan little should be see 'Personal Details' page$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.getTitle shouldBe "Personal Details"
    }
  }

  Then("""^Mr Ryan Little should be displayed$""") {
    withCurrentDriver { implicit webDriver =>
      val pd = getTestPersonDetailsByName("John Densmore")

      webDriver.findElements(By.cssSelector(".content__body > p"))
        .filter(_.getText == pd.person.shortName) should not be 'empty
    }
  }
}
