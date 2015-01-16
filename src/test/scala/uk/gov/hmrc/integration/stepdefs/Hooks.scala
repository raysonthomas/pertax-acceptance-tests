package uk.gov.hmrc.integration.stepdefs

import cucumber.api.Scenario
import cucumber.api.java.{Before, After}
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.UnreachableBrowserException

import org.scalatest.Matchers
import uk.gov.hmrc.integration.selenium.DriverContainer
import uk.gov.hmrc.integration.selenium.DriverContainer._

class CurrentDriver extends ScalaDsl with EN with Matchers {
  
  CurrentDriver.instance = this
  
  var webDriver: WebDriver = null

  @Before
  def initialize = {
    webDriver = DriverContainer.buildWebDriver
  }

  @After
  def tearDown = {
    webDriver.quit()
  }
}

object CurrentDriver {
  var instance: CurrentDriver = null
}