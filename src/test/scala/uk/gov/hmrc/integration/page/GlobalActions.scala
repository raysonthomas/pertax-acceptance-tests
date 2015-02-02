package uk.gov.hmrc.integration.page

import org.openqa.selenium.{By, WebDriver}


object GlobalActions {

  def maybeClickMenu(implicit webDriver: WebDriver): Unit = {
    val dims = webDriver.findElement(By.cssSelector("body")).getSize
    if (dims.width <= uk.gov.hmrc.integration.utils.Configuration.DeviceViewBreakpoint) {
      webDriver.findElement(By.linkText("Menu")).click()
    }
  }
}
