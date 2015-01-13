package uk.gov.hmrc.integration.stepdefs

import cucumber.api.Scenario
import cucumber.api.java.{Before, After}
import cucumber.api.scala.{EN, ScalaDsl}

import org.scalatest.Matchers
import uk.gov.hmrc.integration.selenium.DriverContainer._

class Hooks extends ScalaDsl with EN with Matchers {


  @Before
  def setUp(result: Scenario) {

  }

  @After
  def tearDown(result: Scenario) {
    webDriver.quit()
  }
}