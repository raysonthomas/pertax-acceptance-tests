package uk.gov.hmrc.integration.selenium

import java.net.URL

import org.openqa.selenium.chrome.{ChromeDriver, ChromeDriverService}
import org.openqa.selenium.firefox.{FirefoxDriver}
import org.openqa.selenium.remote.RemoteWebDriver
import RemoteWebDriverFactory._

/**
 * Created by nic on 13/01/2015.
 */
object DriverContainer {

  System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"/src/test/resources/chromedriver")

  // keep this val around in case the tests are going to executed from within IntelliJ
  lazy val webDriver = System.getProperty("browser", "win-firefox-remote") match {
    case "firefox-local"      => createLocalFirefoxDriver
    case "chrome-local"       => createLocalChromeDriver
    case "win-firefox-remote" => createRemoteWinFirefoxDriver
    case "win-chrome-remote"  => createRemoteWinChromeDriver
    case "safari-remote"      => createRemoteSafari7Driver
    case _ => throw new IllegalArgumentException(s"Browser type not recognised")
  }

  //Local Drivers
  def createLocalFirefoxDriver = new FirefoxDriver
  def createLocalChromeDriver = new ChromeDriver

  //Aliases
  def createRemoteWinFirefoxDriver = buildWin8firefox33CapDriver
  def createRemoteWinChromeDriver  = buildWin81chrome38CapDriver
  def createRemoteSafari7Driver    = buildMacosxMavericksSafari7Driver

}
