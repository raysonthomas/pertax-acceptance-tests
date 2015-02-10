package uk.gov.hmrc.integration.page

import org.openqa.selenium.support.ui.{WebDriverWait, ExpectedConditions}
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions


object LandingPageActions {

  def clickLinkByName(linkName: String)(implicit webDriver: WebDriver): Unit = {
    webDriver.findElement(By.linkText(linkName)).click()
    //TODO: use urlEndsWith but use a getDestinationURL variable not a hardcoded value
    (new WebDriverWait(webDriver, 15)).until(ExpectedConditions.titleContains(""))
  }

}