package uk.gov.hmrc.integration.selenium

import org.openqa.selenium.WebDriver
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.utils.Configuration
import scala.collection.JavaConversions._

object CurrentDriver {

  private var webDriver: WebDriver = null

  
  def reset(): Unit = {
    if (webDriver != null) {
      //FIXME - this should invalidate the session but it doesnt for some reason
      //webDriver.manage.deleteAllCookies()
      //GlobalActions.maybeClickMenu(webDriver)
      //GlobalActions.clickLinkByName("Sign out")(webDriver)
    }
  }

  def invalidate(): Unit = {
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
