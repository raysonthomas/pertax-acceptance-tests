package uk.gov.hmrc.integration.selenium

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}

/**
 * Created by nic on 19/01/2015.
 */
object CustomExpectedConditions {

  def urlEndsWith(suffix: String)(implicit webDriver: WebDriver): ExpectedCondition[Boolean] = {
    new ExpectedCondition[Boolean] {
      override def apply(wd: WebDriver): Boolean = {
        wd.getCurrentUrl.endsWith(suffix)
      }
    }
  }
}
