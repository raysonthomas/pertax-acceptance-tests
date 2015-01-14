package uk.gov.hmrc.integration.selenium

import java.net.URL

import org.openqa.selenium.remote.{RemoteWebDriver, DesiredCapabilities}

object RemoteWebDriverFactory {

  private val browserStackCaps    = List("browserstack.debug" -> "true", "browserstack.local" -> "false")

  // OS for Windows
  private val windowsXPCaps       = List("os" -> "Windows", "os_version" -> "XP") ++ browserStackCaps
  private val windows7Caps        = List("os" -> "Windows", "os_version" -> "7") ++ browserStackCaps
  private val windows8Caps        = List("os" -> "Windows", "os_version" -> "8") ++ browserStackCaps
  private val windows81Caps       = List("os" -> "Windows", "os_version" -> "8.1") ++ browserStackCaps

  // OS for MAC OS-X
  private val macosxMavericksCaps = List("os" -> "OS X", "os_version" -> "Mavericks") ++ browserStackCaps
  private val macosxYosemiteCaps  = List("os" -> "OS X", "os_version" -> "Yosemite") ++ browserStackCaps

  //Browsers and OS for windows and IE
  private val winXPie6Caps = List("browser" -> "IE", "browser_version" -> "6.0") ++ windowsXPCaps
  private val winXPie7Caps = List("browser" -> "IE", "browser_version" -> "7.0") ++ windowsXPCaps
  private val win7ie8Caps = List("browser" -> "IE", "browser_version" -> "8.0") ++ windows7Caps
  private val win7ie9Caps = List("browser" -> "IE", "browser_version" -> "9.0") ++ windows7Caps
  private val win7ie10Caps = List("browser" -> "IE", "browser_version" -> "10.0") ++ windows7Caps
  private val win7ie11Caps = List("browser" -> "IE", "browser_version" -> "11.0") ++ windows7Caps
  private val win8ie10Caps = List("browser" -> "IE", "browser_version" -> "10.0") ++ windows8Caps
  private val win81ie11Caps = List("browser" -> "IE", "browser_version" -> "11.0") ++ windows81Caps

  //Browsers and OS for windows and chrome
  private val win8chrome38Caps = List("browser" -> "Chrome", "browser_version" -> "38.0") ++ windows8Caps
  private val win81chrome38Caps = List("browser" -> "Chrome", "browser_version" -> "38.0") ++ windows81Caps

  //Browsers and OS for windows and firefox
  private val win8firefox33Caps = List("browser" -> "Firefox", "browser_version" -> "33.0") ++ windows8Caps
  private val win81firefox33Caps = List("browser" -> "Firefox", "browser_version" -> "33.0") ++ windows81Caps

  //Browsers and OS for MAC OS-X, chrome, firefox and safari
  private val macosxMavericksSafari7Caps = List("browser" -> "Safari", "browser_version" -> "7.0") ++ macosxMavericksCaps
  private val macosxYosemiteSafari8Caps = List("browser" -> "Safari", "browser_version" -> "8.0") ++ macosxYosemiteCaps
  private val macosxYosemitechrome38Caps = List("browser" -> "Chrome", "browser_version" -> "38.0") ++ macosxYosemiteCaps
  private val macosxYosemitefirefox33Caps = List("browser" -> "Firefox", "browser_version" -> "33.0") ++ macosxYosemiteCaps

  private val browserStackURL = s"http://srimanmittapally1:Sauyv85GKXmkxFwAxbmY@hub.browserstack.com/wd/hub"

  private def buildRemoteWebDriver(caps: List[(String,String)]) = {
    val dc = new DesiredCapabilities
    for( (k,v) <- caps )
      dc.setCapability(k, v)
    new RemoteWebDriver(new URL(browserStackURL), dc)
  }

  // for Windows
  lazy val buildWinXPie6Driver = buildRemoteWebDriver(winXPie6Caps)
  lazy val buildWinXPie7Driver = buildRemoteWebDriver(winXPie7Caps)
  lazy val buildWin7ie8Driver = buildRemoteWebDriver(win7ie8Caps)
  lazy val buildWin7ie9Driver = buildRemoteWebDriver(win7ie9Caps)
  lazy val buildWin7ie10Driver = buildRemoteWebDriver(win7ie10Caps)
  lazy val buildWin7ie11Driver = buildRemoteWebDriver(win7ie11Caps)
  lazy val buildWin8ie10Driver = buildRemoteWebDriver(win8ie10Caps)
  lazy val buildWin81ie11Driver = buildRemoteWebDriver(win81ie11Caps)
  lazy val buildWin8chrome38Driver = buildRemoteWebDriver(win8chrome38Caps)
  lazy val buildWin81chrome38CapDriver = buildRemoteWebDriver(win81chrome38Caps)
  lazy val buildWin8firefox33CapDriver = buildRemoteWebDriver(win8firefox33Caps)
  lazy val buildWin81firefox33Driver = buildRemoteWebDriver(win81firefox33Caps)

  //for MAC OS-X
  lazy val buildMacosxMavericksSafari7Driver = buildRemoteWebDriver(macosxMavericksSafari7Caps)
  lazy val buildMacosxYosemitesSafari8Driver = buildRemoteWebDriver(macosxYosemiteSafari8Caps)
  lazy val buildMacosxYosemitechrome38Driver = buildRemoteWebDriver(macosxYosemitechrome38Caps)
  lazy val buildMacosxYosemitefirefox33Driver = buildRemoteWebDriver(macosxYosemitefirefox33Caps)
}
