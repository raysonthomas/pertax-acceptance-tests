package uk.gov.hmrc.integration.page

import java.net.URL

import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils.Configuration

object GlobalActions {

  def maybeClickMenu(implicit webDriver: WebDriver): Unit = {
    val dims = webDriver.findElement(By.cssSelector("body")).getSize
    if (dims.width <= uk.gov.hmrc.integration.utils.Configuration.DeviceViewBreakpoint) {
      webDriver.findElement(By.linkText("Menu")).click()
    }
  }

  def clickLinkThenExplicitWaitForPath(selector: By, path: String = "")(implicit webDriver: WebDriver): Unit = {
    val urlPath = if(path.isEmpty) webDriver.findElement(selector).getAttribute("href") else path
    webDriver.findElement(selector).click()
    (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.urlEndsWith(urlPath))
  }
}
