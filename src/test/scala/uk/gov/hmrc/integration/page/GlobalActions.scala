package uk.gov.hmrc.integration.page

import org.openqa.selenium.{WebDriver, By}
import uk.gov.hmrc.integration.utils.Configuration

object GlobalActions {

  def maybeClickMenu(implicit webDriver: WebDriver) = {
    val dims = webDriver.findElement(By.cssSelector("body")).getSize
    if (dims.width <= Configuration.DeviceViewBreakpoint)
      webDriver.findElement(By.linkText("Menu")).click()
  }
}
