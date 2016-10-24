package uk.gov.hmrc.integration.stepdefs

import cucumber.api.Scenario
import cucumber.api.java.{Before, After}
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{OutputType, TakesScreenshot, WebDriverException, WebDriver}
import org.scalatest.Matchers
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.{Snapshotter, CurrentDriver, DriverFactory}


class Hooks extends ScalaDsl with EN with Matchers {
  @Before
  def initialize = {

  }

  //Executes after each scenario in a feature
  @After
  def tearDown(result: Scenario){
//    ifCurrentDriverTakesSnapshot { takesSnapShot =>
//      Snapshotter.takeSnapshot(takesSnapShot, result)
//    }
    CurrentDriver.clearSession()
  }
}

