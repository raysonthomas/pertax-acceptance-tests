package uk.gov.hmrc.integration.page

import org.openqa.selenium.{By, WebDriver}


class LandingPageActions {

  def clickPersonalDetailsLink(implicit webDriver: WebDriver) = {
    webDriver.findElement(By.cssSelector("#proposition-links>li>a")).click()
  }
}
