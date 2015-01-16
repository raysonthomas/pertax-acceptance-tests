package uk.gov.hmrc.integration.stepdefs

import scala.collection.JavaConversions._
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.page.{IDAActions, LandingPageActions}
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class ViewNameTest extends ScalaDsl with EN with Matchers {

  val idaActions = new IDAActions
  val lpActions = new LandingPageActions
  
  
  Given( """^Ryan Little has logged in to his account$""") {
    withCurrentDriver { implicit webDriver =>
      idaActions.enterURL
      idaActions.clickLoginStub
    }
  }

  When( """^Ryan Little navigates to Personal Details Page$""") {
    withCurrentDriver { implicit webDriver =>
      lpActions.clickViewPersonalDetailsLink
    }

  }

  Then( """^Personal Details page should be displayed$""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.getTitle shouldBe "Personal Details"
    }
  }

  Then( """^"Mr Ryan Little" should be displayed$""") {
    withCurrentDriver { implicit webDriver =>
      val dds = webDriver.findElements(By.cssSelector(".pertax-personal-details>dl>dd"))
      dds.filter(_.getText == "John") should not be 'empty
      dds.filter(_.getText == "Densmore") should not be 'empty
    }
  }
}
