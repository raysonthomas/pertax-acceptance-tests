package uk.gov.hmrc.integration.selenium

import java.util.concurrent.TimeUnit

import org.openqa.selenium.{WebDriverException, WebDriver}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeDriverService}
import org.openqa.selenium.firefox.FirefoxDriver
import uk.gov.hmrc.integration.selenium.RemoteWebDriverFactory._

object DriverFactory {

  System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"/src/test/resources/chromedriver")

  def buildWebDriver = {
    val webDriver = System.getProperty("browser", "firefox-local") match {
      case "firefox-local"        => createLocalFirefoxDriver
      case "chrome-local"         => createLocalChromeDriver
      case "winxp-ie6-remote"     => createRemoteWinXPie6Driver
      case "winxp-ie7-remote"     => createRemoteWinXPie7Driver
      case "win7-ie8-remote"      => createRemoteWin7ie8Driver
      case "win7-ie9-remote"      => createRemoteWin7ie9Driver
      case "win7-ie10-remote"     => createRemoteWin7ie10Driver
      case "win7-ie11-remote"     => createRemoteWin7ie11Driver
      case "win8-ie11-remote"     => createRemoteWin8ie10Driver
      case "win8.1-ie11-remote"   => createRemoteWin81ie11Driver
      case "macos-safari7-remote" => createRemoteSafar7Driver
      case "macos-safari8-remote" => createRemoteSafar8Driver
      case "macos-chrome-remote"  => createRemoteChrome38river
      case "macos-firefox-remote" => createRemoteFirefox33Driver
      case "iphone5s-remote"      => createRemoteBuildIphone5SDriver
      case _ => throw new IllegalArgumentException(s"Browser type not recognised")
    }

    webDriver.manage.timeouts.implicitlyWait(25, TimeUnit.SECONDS)
    
    try {
      webDriver.manage.window.maximize()
    }
    catch {
      case e: WebDriverException => //Swallow exception
    }
    
    webDriver
  }

  //Local Drivers
  def createLocalFirefoxDriver = new FirefoxDriver
  def createLocalChromeDriver = new ChromeDriver

  //Aliases for the cross browser testing  
  //Aliases-WIN-XP for the cross browser testing
  def createRemoteWinXPie7Driver  = buildWinXPie7Driver
  def createRemoteWinXPie6Driver  = buildWinXPie6Driver

  //Aliases-WIN-7 for the cross browser testing
  def createRemoteWin7ie8Driver = buildWin7ie8Driver
  def createRemoteWin7ie9Driver = buildWin7ie9Driver
  def createRemoteWin7ie10Driver = buildWin7ie10Driver
  def createRemoteWin7ie11Driver = buildWin7ie11Driver

  //Aliases-WIN-8 for the cross browser testing
  def createRemoteWin8ie10Driver = buildWin8ie10Driver
  
  //Aliases-WIN-8.1 for the cross browser testing
  def createRemoteWin81ie11Driver = buildWin81ie11Driver
   
  //Aliases-MAC for the cross browser testing
  def createRemoteSafar7Driver    = buildMacosxMavericksSafari7Driver
  def createRemoteSafar8Driver    = buildMacosxYosemitesSafari8Driver
  def createRemoteChrome38river    = buildMacosxYosemitechrome38Driver
  def createRemoteFirefox33Driver  = buildMacosxYosemitefirefox33Driver
  
  //Aliases-IOS Device for the cross browser testing
  def createRemoteBuildIphone5SDriver  = buildIosIphone5SDriver
}

