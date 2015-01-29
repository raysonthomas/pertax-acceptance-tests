package uk.gov.hmrc.integration.selenium

import org.openqa.selenium.WebDriver

object CurrentDriver {

  private var webDriver: WebDriver = null


  def invalidate = {
    if (webDriver != null)
      webDriver.quit()
    webDriver = null
  }

  def getWebDriver = {
    if (webDriver == null)
      webDriver = DriverFactory.buildWebDriver
    webDriver
  }

  def withCurrentDriver[T](block: WebDriver => T) = {
    block(getWebDriver)
  }
}
