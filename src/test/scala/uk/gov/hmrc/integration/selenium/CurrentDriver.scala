package uk.gov.hmrc.integration.selenium

import java.io.PrintWriter
import java.util.Calendar

import org.openqa.selenium.{TakesScreenshot, By, WebDriver}
import uk.gov.hmrc.integration.page.GlobalActions

object CurrentDriver {

  private implicit var webDriver: WebDriver = null

  
  def clearSession(): Unit = {

      if (
        webDriver != null &&
        !webDriver.getCurrentUrl.endsWith("/ida/startlogin") &&
        !webDriver.getCurrentUrl.endsWith("do-uplift&accountType=individual") &&
        !webDriver.getCurrentUrl.endsWith("do-uplift&accountType=individual&origin=PERTAX") &&
        !webDriver.getCurrentUrl.endsWith("personal-account&accountType=individual&origin=PERTAX") &&
        !webDriver.getCurrentUrl.contains("/tax-credits-service/personal/change-address") &&
        !webDriver.getCurrentUrl.contains("identity-check-complete") &&
        !webDriver.getCurrentUrl.endsWith("/signed-out") &&
        !webDriver.getCurrentUrl.endsWith("/personal-account/feedback-thanks") &&
        !webDriver.getCurrentUrl.endsWith("enteractivationpin") &&
        !webDriver.getCurrentUrl.endsWith("/signed-out?origin=PERTAX")

      )

    {
      GlobalActions.maybeClickMenu
      GlobalActions.clickLinkThenExplicitWaitForPath(By.linkText("Sign out"), "/personal-account/signed-out?origin=PERTAX")
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
  
  def ifCurrentDriver[T](block: PartialFunction[WebDriver, T]): Option[T] = {
    if (webDriver != null) {
      block.lift(webDriver)
    }
    else None
  }

  def ifCurrentDriverTakesSnapshot[T](block: TakesScreenshot => T): Option[T] = {
    ifCurrentDriver {
      case takesSnapshot: TakesScreenshot =>
        block(takesSnapshot)
    }
  }

  def provisioningCurrentDriver[T](block: WebDriver => T) = {
    block(getWebDriver)
  }
}
