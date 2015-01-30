package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest.Matchers
import uk.gov.hmrc.integration.page.IDAActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._

class LogInTest extends ScalaDsl with EN with Matchers {

  Given( """^(.*) is logged in to PTA$""") {
    (user: String) =>
      val personProperty = personProperties(user)
      withCurrentDriver { implicit webDriver =>
        IDAActions.enterURL
        webDriver.findElement(By.id("username")).sendKeys(personProperty.username)
        webDriver.findElement(By.id("password")).sendKeys(personProperty.password)
        IDAActions.clickSubmit
      }
  }

}
