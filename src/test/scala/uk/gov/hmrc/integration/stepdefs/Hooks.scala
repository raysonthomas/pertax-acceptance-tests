package uk.gov.hmrc.integration.stepdefs

import cucumber.api.java.{Before, After}
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.WebDriver
import org.scalatest.Matchers
import uk.gov.hmrc.integration.selenium.DriverFactory




class Hooks extends ScalaDsl with EN with Matchers {


  @Before
  def initialize = {

  }

  @After
  def tearDown = {
    CurrentDriver.invalidate
  }
}

