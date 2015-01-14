package uk.gov.hmrc.integration.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import uk.gov.hmrc.integration.page.{LandingPageActions, IDAActions}
import uk.gov.hmrc.integration.selenium.DriverContainer._


class ViewNameTest extends ScalaDsl with EN with Matchers {

  
  val idaActions = new IDAActions(webDriver)
  val lpActions = new LandingPageActions(webDriver)
  
  Given( """^Ryan Little has logged in to his account$""") {
    () => {
      idaActions.enterURL
      idaActions.clickLoginStub
    }
  }

  When( """^Ryan Little navigates to Personal Details Page$""") {
    () => {
      lpActions.clickViewPersonalDetailsLink
    }

  }

  Then( """^"Personal Details page should be displayed$""") {
    () => {
      webDriver.getTitle shouldBe "Personal Details"
    }
  }

  Then( """^"Mr Ryan Little" should be displayed$""") {
    () => {
      webDriver.findElement(By.cssSelector(".pertax-personal-details>dl>dd:nth-of-type(1)")).getText shouldBe "John"
      webDriver.findElement(By.cssSelector(".pertax-personal-details>dl>dd:nth-of-type(2)")).getText shouldBe "Densmore"
    }
  }
}
