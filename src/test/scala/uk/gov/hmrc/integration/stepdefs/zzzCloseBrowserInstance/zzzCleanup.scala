package uk.gov.hmrc.integration.stepdefs.zzzCloseBrowserInstance

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver
import uk.gov.hmrc.integration.selenium.CurrentDriver._

class zzzCleanup extends ScalaDsl with EN {

  Then( """^Clean up$""") {
    CurrentDriver.quitAndDestroy()
  }
}