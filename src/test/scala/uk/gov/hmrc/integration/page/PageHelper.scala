package uk.gov.hmrc.integration.page

import org.openqa.selenium.{WebDriver, By, NoSuchElementException}
import org.scalatest.selenium.WebBrowser
import uk.gov.hmrc.integration.framework.{Server500ResponseException, Server502ResponseException}
import uk.gov.hmrc.integration.selenium.DriverFactory
import uk.gov.hmrc.integration.utils.{Configuration, FixedDelay}

object PageHelper extends WebBrowser {

  def elementDisplayed(by: By)(implicit webDriver: WebDriver) = !webDriver.findElements(by).isEmpty

  def waitForPageToBeLoaded(condition: => Boolean, exceptionMessage: String, timeoutInSeconds: Int = Configuration.PageTimeOut)(implicit webDriver: WebDriver) {
    val endTime = System.currentTimeMillis + timeoutInSeconds * 1000
    while (System.currentTimeMillis < endTime) {
      try {
        if (condition) {
          return
        }
      } catch {
        case _: RuntimeException =>
        // ignore exceptions during the timeout period because the condition
        // is throwing exceptions and we DO want to try the condition again until the timeout expires
      }
      // The following is to avoid to wait until timeout in case of well known errors
      val source: String = webDriver.getPageSource
      // 502
      if (source.contains("502 Bad Gateway")) {
        throw new Server502ResponseException
      }
      // GENERIC PLAY ERROR
      if (source.contains("play-error-page")) {
        throw new Server500ResponseException("ERROR OCCURRED \n" + webDriver.findElement(By.cssSelector("#detail")).getText)
      }
      //IDA LOGIN UNEXPECTED ERROR
      if (source.contains("An unexpected problem occurred during authentication.")) {
        throw new Server500ResponseException("IDA Login Error")
      }
      FixedDelay(100)
    }
    throw new HmrcPageWaitException(exceptionMessage + "\nThe current page was:\n" + webDriver.getPageSource)
  }

  class HmrcPageWaitException(exceptionMessage: String) extends Exception(exceptionMessage)

}
