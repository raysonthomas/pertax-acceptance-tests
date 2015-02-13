package uk.gov.hmrc.integration.page

import mx4j.tools.config.DefaultConfigurationBuilder.New
import org.openqa.selenium.support.ui.{WebDriverWait}
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import java.net.URL

import uk.gov.hmrc.integration.utils.Configuration


object LandingPageActions {

  def clickLinkByName(linkName: String)(implicit webDriver: WebDriver): Unit = {
    val urlPath = new URL(webDriver.findElement(By.linkText(linkName)).getAttribute("href")).getPath
    webDriver.findElement(By.linkText(linkName)).click()
    (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.urlEndsWith(s"$urlPath"))
  }

}