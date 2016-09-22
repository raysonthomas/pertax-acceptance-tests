package uk.gov.hmrc.integration.selenium

import cucumber.api.Scenario
import org.openqa.selenium.{WebDriverException, OutputType, TakesScreenshot, WebDriver}

object Snapshotter {

  def takeSnapshot(takesScreenshot: TakesScreenshot, result: Scenario) =  {
    try {
      val screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES)
      result.embed(screenshot, "image/png")
    }
    catch {
      case e: WebDriverException =>
        e.printStackTrace(System.err)
    }    
  }

}
