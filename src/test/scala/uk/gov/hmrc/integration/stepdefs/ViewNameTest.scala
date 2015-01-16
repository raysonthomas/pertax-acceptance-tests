package uk.gov.hmrc.integration.stepdefs

import cucumber.api.Scenario
import cucumber.api.java.{After, Before}
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{WebDriver, By}
import org.scalatest._
import uk.gov.hmrc.integration.page.{LandingPageActions, IDAActions}
import uk.gov.hmrc.integration.selenium.DriverFactory
import scala.collection.JavaConversions._


class ViewNameTest extends ScalaDsl with EN with Matchers {

  implicit def webDriver = CurrentDriver.getWebDriver

  val idaActions = new IDAActions
  val lpActions = new LandingPageActions
  
  
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

  Then( """^Personal Details page should be displayed$""") {
    () => {
      webDriver.getTitle shouldBe "Personal Details"
    }
  }

  Then( """^"Mr Ryan Little" should be displayed$""") {
    () => {
      val dds = webDriver.findElements(By.cssSelector(".pertax-personal-details>dl>dd"))
      dds.filter(_.getText == "John") should not be 'empty
      dds.filter(_.getText == "Densmore") should not be 'empty
    }
  }
}
