package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest.Matchers
import uk.gov.hmrc.integration.page.IDAActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._

class LogInTest extends ScalaDsl with EN with Matchers {

  Given( """^(.*) has logged in to PTA$""") {
    (user: String) =>
      val props = personProperties(user)
      withCurrentDriver { implicit webDriver =>
        IDAActions.enterURL
        webDriver.findElement(By.id("username")).sendKeys(props.username)
        webDriver.findElement(By.id("password")).sendKeys(props.password)
        IDAActions.clickSubmit
      }
  }

}
