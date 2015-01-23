package uk.gov.hmrc.integration.stepdefs.personaldetails

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.page.{IDAActions, LandingPageActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._

import scala.collection.JavaConversions._

class ViewNameTest extends ScalaDsl with EN with Matchers {

  val idaActions = new IDAActions
  val lpActions = new LandingPageActions


  Given("""^Ryan Little has logged in to his account$""") {
    withCurrentDriver { implicit webDriver =>
      idaActions.enterURL
      idaActions.clickLoginStub
    }
  }

  Given("""^should be on 'Personal tax account' page$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.getTitle shouldBe "Hello John Densmore"
    }
  }

  Given("""^should see the 'Personal details' link$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElements(By.linkText("Menu")).map(_.click()) //Click Menu if present
      webDriver.findElements(By.linkText("Personal details")) should not be 'empty
    }
  }


  When("""^Ryan Little click on 'Personal details' link$""") {
    withCurrentDriver { implicit webDriver =>
      lpActions.clickPersonalDetailsLink
    }
  }

  Then("""^Ryan little should be see 'Personal Details' page$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.getTitle shouldBe "Personal Details"
    }
  }

  Then("""^Mr Ryan Little" should be displayed$""") {
    withCurrentDriver { implicit webDriver =>
      val ctp = webDriver.findElements(By.cssSelector(".content__body > p"))
      ctp.filter(_.getText == "John Densmore") should not be 'empty
    }
  }
}
