package uk.gov.hmrc.integration.stepdefs.zzz

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver
import uk.gov.hmrc.integration.selenium.CurrentDriver._



class zzzShutdown extends ScalaDsl with EN {

  Then( """^Shut down the WebDriver$""") {
    CurrentDriver.invalidate
  }
}