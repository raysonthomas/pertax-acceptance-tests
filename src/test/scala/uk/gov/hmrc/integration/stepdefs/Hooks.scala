package uk.gov.hmrc.integration.stepdefs

import cucumber.api.java.{Before, After}
import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers
import uk.gov.hmrc.integration.selenium.{CurrentDriver, DriverFactory}


class Hooks extends ScalaDsl with EN with Matchers {


  @Before
  def initialize = {

  }

  @After
  def tearDown = {
    CurrentDriver.invalidate
  }
}

