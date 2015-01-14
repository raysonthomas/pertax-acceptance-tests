package uk.gov.hmrc.integration.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers
import uk.gov.hmrc.integration.page.PageHelper
import uk.gov.hmrc.integration.selenium.DriverContainer._
import org.openqa.selenium._


class GoogleWorks extends ScalaDsl with EN with Matchers {

  Given( """^I am at https://duckduckgo.com$""") {
    () => {
      webDriver.get("https://duckduckgo.com")
    }
  }

  When( """^I search for 'The Godfather'$""") {
    () => {
      webDriver.findElement(By.cssSelector("input[name='q']")).sendKeys("The Godfather")
      webDriver.findElement(By.cssSelector("input[type='submit']")).click()
    }

  }

  Then( """^I should have IMDb returned in my results$""") {
    () => {
      assert(webDriver.getPageSource.contains("IMDb"))
    }
  }
}