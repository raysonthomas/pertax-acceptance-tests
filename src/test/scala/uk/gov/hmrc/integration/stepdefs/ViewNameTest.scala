package uk.gov.hmrc.integration.stepdefs

import cucumber.api.Scenario
import cucumber.api.java.{After, Before}
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{WebDriver, By}
import org.scalatest._
import uk.gov.hmrc.integration.page.{LandingPageActions, IDAActions}
import uk.gov.hmrc.integration.selenium.{CurrentDriver, DriverFactory}
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

  Given( """^should be on 'Personal tax account' page$""") {
    () => {
      webDriver.getTitle shouldBe "global.label.hello"
    }
  }

  Given( """^should see the 'Personal details' link$""") {
    () => {
      val ctp = webDriver.findElements(By.cssSelector("#proposition-links>li>a"))
      ctp.filter(_.getText == "Personal details") should not be 'empty
    }
  }


  When( """^Ryan Little click on 'Personal details' link$""") {
    () => {
      lpActions.clickPersonalDetailsLink

    }

  }

  Then( """^Ryan little should be see 'Persnal Details' page$""") {
    () => {
      webDriver.getTitle shouldBe "global.title.personal_details"
    }
  }

  Then( """^Mr Ryan Little" should be displayed$""") {
    () => {
      val ctp = webDriver.findElements(By.cssSelector(".content__body>p"))
      ctp.filter(_.getText == "John Densmore") should not be 'empty

    }
  }
}
