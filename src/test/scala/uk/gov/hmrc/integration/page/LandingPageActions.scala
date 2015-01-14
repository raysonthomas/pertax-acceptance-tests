package uk.gov.hmrc.integration.page

import org.openqa.selenium.{By, WebDriver}


class LandingPageActions(val webDriver: WebDriver) {

  def clickViewPersonalDetailsLink = {
    webDriver.findElement(By.linkText("View personal details")).click()
  }
}
