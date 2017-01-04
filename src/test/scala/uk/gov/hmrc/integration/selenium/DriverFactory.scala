package uk.gov.hmrc.integration.selenium

import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriverException
import org.openqa.selenium.chrome.{ChromeDriver, ChromeDriverService}
import org.openqa.selenium.firefox.{FirefoxDriver, MarionetteDriver}
import uk.gov.hmrc.accessibility.AccessibilityDriver
import uk.gov.hmrc.integration.selenium.RemoteWebDriverFactory._
import uk.gov.hmrc.integration.utils.Configuration

object DriverFactory {

  System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/usr/local/bin/chromedriver")
//  System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"/src/test/resources/chromedriver")
//  System.setProperty("webDriver.gecko.driver", "/usr/bin/geckodriver")
  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/geckodriver")

  def buildWebDriver = {
    val webDriver = System.getProperty("browser", "firefox-local") match {
      case "firefox-local"            => new MarionetteDriver
      case "chrome-local"             => new ChromeDriver
      case "accessibility"            => new AccessibilityDriver(23748,List("^http://localhost:9232/personal-account(.*)".r))
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
      case "galaxys5-remote"          => buildAndroidSamsungGalaxyS5Driver
      case _                          => throw new IllegalArgumentException("Browser type not recognised")
    }

    webDriver.manage.timeouts.implicitlyWait(Configuration("defaultWait").toInt, TimeUnit.SECONDS)

    try {
      webDriver.manage.window.maximize()
    }
    catch {
      case e: WebDriverException => //Swallow exception
    }
    
    webDriver
  }
}