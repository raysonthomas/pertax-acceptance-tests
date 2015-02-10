package uk.gov.hmrc.integration.selenium

import java.util.concurrent.TimeUnit

import org.openqa.selenium.{Dimension, WebDriverException, WebDriver}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeDriverService}
import org.openqa.selenium.firefox.FirefoxDriver
import uk.gov.hmrc.integration.selenium.RemoteWebDriverFactory._

object DriverFactory {

  System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"/src/test/resources/chromedriver")

  def buildWebDriver = {
    val webDriver = System.getProperty("browser", "firefox-local") match {
      case "firefox-local"            => new FirefoxDriver
      case "chrome-local"             => new ChromeDriver
      case "winxp-ie6-remote"         => buildWinXPie6Driver
      case "winxp-ie7-remote"         => buildWinXPie7Driver
      case "win7-ie8-remote"          => buildWin7ie8Driver
      case "win7-ie9-remote"          => buildWin7ie9Driver
      case "win7-ie10-remote"         => buildWin7ie10Driver
      case "win7-ie11-remote"         => buildWin7ie11Driver
      case "win8.1-ie11-remote"       => buildWin81ie11Driver
      case "win8-ie10-remote"         => buildWin8ie10Driver
      case "win7-firefox-remote"      => buildWin7firefox33CapDriver
      case "win7-chrome-remote"       => buildWin7chrome38Driver
      case "macos-safari7-remote"     => buildMacosxMavericksSafari7Driver
      case "macos-safari8-remote"     => buildMacosxYosemitesSafari8Driver
      case "macos-chrome-remote"      => buildMacosxYosemitechrome38Driver
      case "macos-firefox-remote"     => buildMacosxYosemitefirefox33Driver
      case "iphone5s-emu-remote"      => buildIosIphone5SDriver
      case "samsungGalaxyS5-remote"   => buildAndroidSamsungGalaxyS5Driver
      case _                          => throw new IllegalArgumentException(s"Browser type not recognised")
    }

    val TimeOutInSeconds = 35
    webDriver.manage.timeouts.implicitlyWait(TimeOutInSeconds, TimeUnit.SECONDS)
    
    try {
      webDriver.manage.window.maximize()
    }
    catch {
      case e: WebDriverException => //Swallow exception
    }
    
    webDriver
  }
}