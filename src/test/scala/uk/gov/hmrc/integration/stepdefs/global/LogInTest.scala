package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers
import uk.gov.hmrc.integration.page.IDAActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class LogInTest extends ScalaDsl with EN with Matchers {

  Given( """^John Densmore has logged in to PTA$""") {
    withCurrentDriver { implicit webDriver =>
      IDAActions.enterURL
      IDAActions.clickLoginStub
    }
  }

}
