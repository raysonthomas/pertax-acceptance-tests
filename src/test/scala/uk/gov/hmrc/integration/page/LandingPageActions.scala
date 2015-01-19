package uk.gov.hmrc.integration.page

import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions


class LandingPageActions {

  def clickPersonalDetailsLink(implicit webDriver: WebDriver): Unit = {
    webDriver.findElement(By.linkText("Personal details")).click()
    (new WebDriverWait(webDriver, 15)).until(CustomExpectedConditions.urlEndsWith("/pertax/personalDetails"))
  }
}
