package uk.gov.hmrc.integration.selenium

import org.openqa.selenium.{By, JavascriptExecutor, TakesScreenshot, WebDriver}
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
        !webDriver.getCurrentUrl.endsWith("/feedback-survey/ableToDo") &&
        !webDriver.getCurrentUrl.endsWith("/feedback-survey/thankYou?origin=PERTAX") &&
        !webDriver.getCurrentUrl.endsWith("/personal-account/feedback-thanks") &&
        !webDriver.getCurrentUrl.endsWith("enteractivationpin") &&
        !webDriver.getCurrentUrl.endsWith("/signed-out?origin=PERTAX") &&
        !webDriver.getCurrentUrl.endsWith("/enrolment-exception-list") &&
        !webDriver.getCurrentUrl.endsWith("self-assessment%2Find%2F111112222%2Ftaxreturn%2F1617%2Foptions") &&
        !webDriver.getCurrentUrl.endsWith("self-assessment%2Find%2F123459876%2Ftaxreturn%2F1617%2Foptions")
      )

    {
      GlobalActions.maybeClickMenu
      GlobalActions.clickLinkThenExplicitWaitForPath(By.linkText("Sign out"), "/feedback-survey/ableToDo")
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

  def ifCurrentDriverExecutesJavascript[T](block: JavascriptExecutor => T): Option[T] = {
    ifCurrentDriver {
      case javascriptExecutor: JavascriptExecutor =>
        block(javascriptExecutor)
    }
  }

  def provisioningCurrentDriver[T](block: WebDriver => T) = {
    val wd = getWebDriver
    ifCurrentDriverExecutesJavascript { jsExecutor =>
       jsExecutor.executeScript(
         """var ga = function() {
           |
           |  console.log($.extend({}, arguments));
           |}
         """.stripMargin)
    }
    block(wd)
  }
}
