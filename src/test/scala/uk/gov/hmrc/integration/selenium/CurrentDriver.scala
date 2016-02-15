package uk.gov.hmrc.integration.selenium

import java.io.PrintWriter
import java.util.Calendar

import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.integration.page.GlobalActions

object CurrentDriver {

  private implicit var webDriver: WebDriver = null

  
  def clearSession(): Unit = {
    if (webDriver != null && !webDriver.getCurrentUrl.endsWith("/ida/startlogin") && !webDriver.getCurrentUrl.endsWith("do-uplift&accountType=individual")) {


     // new PrintWriter(Calendar.getInstance().getTime().toString+".html") { write( webDriver.getPageSource); close }

      GlobalActions.maybeClickMenu
      GlobalActions.clickLinkThenExplicitWaitForPath(By.linkText("Sign out"), "/personal-account/signed-out")
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
