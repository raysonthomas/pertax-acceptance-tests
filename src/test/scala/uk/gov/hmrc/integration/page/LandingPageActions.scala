package uk.gov.hmrc.integration.page

import org.openqa.selenium.{By, WebDriver}


class LandingPageActions {

  def clickViewPersonalDetailsLink(implicit webDriver: WebDriver) = {
    webDriver.findElement(By.linkText("View personal details")).click()
  }
}
