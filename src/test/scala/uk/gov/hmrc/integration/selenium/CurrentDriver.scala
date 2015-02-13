package uk.gov.hmrc.integration.selenium

import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.utils.Configuration
import scala.collection.JavaConversions._

object CurrentDriver {

  private implicit var webDriver: WebDriver = null

  
  def clearSession(): Unit = {
    if (webDriver != null) {
      GlobalActions.clickLinkThenExplicitWaitForPath(By.linkText("Sign out"), "/ida/startlogin")
    }
  }

  def quitAndDestroy(): Unit = {
    if (webDriver != null)
      webDriver.quit()
    webDriver = null
  }

  def getWebDriver = {
    if (webDriver == null)
      webDriver = DriverFactory.buildWebDriver
    webDriver
  }

  def withCurrentDriver[T](block: WebDriver => T) = {
    block(getWebDriver)
  }
}
