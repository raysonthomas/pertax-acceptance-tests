package uk.gov.hmrc.integration.selenium

import java.io.File

import cucumber.api.Scenario
import org.apache.commons.io.FileUtils
import org.openqa.selenium.{OutputType, TakesScreenshot, WebDriver, WebDriverException}

object Snapshotter {

  def takeSnapshot(takesScreenshot: TakesScreenshot, result: Scenario) =  {
    try {
      val screenshot: File = takesScreenshot.getScreenshotAs(OutputType.FILE)
      FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/target/cucumber/images/urlScreenshot.png"))
    }
    catch {
      case e: WebDriverException =>
        e.printStackTrace(System.err)
    }    
  }

  def takeErrorSnapshot(takesScreenshot: TakesScreenshot, result: Scenario) =  {
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
