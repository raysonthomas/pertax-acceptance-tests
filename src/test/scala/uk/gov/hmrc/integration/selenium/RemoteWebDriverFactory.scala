package uk.gov.hmrc.integration.selenium

import java.net.URL

import org.openqa.selenium.remote.{RemoteWebDriver, DesiredCapabilities}

object RemoteWebDriverFactory {

  private val browserStackCaps    = List("browserstack.debug" -> "true", "browserstack.local" -> "true")

  // OS for Windows
  private val windowsXPCaps       = List("os" -> "Windows", "os_version" -> "XP") ++ browserStackCaps
  private val windows7Caps        = List("os" -> "Windows", "os_version" -> "7") ++ browserStackCaps
  private val windows8Caps        = List("os" -> "Windows", "os_version" -> "8") ++ browserStackCaps
  private val windows81Caps       = List("os" -> "Windows", "os_version" -> "8.1") ++ browserStackCaps

  // OS for MAC OS-X
  private val macosxMavericksCaps = List("os" -> "OS X", "os_version" -> "Mavericks") ++ browserStackCaps
  private val macosxYosemiteCaps  = List("os" -> "OS X", "os_version" -> "Yosemite") ++ browserStackCaps
  
  //platform for browsername mobile devices
  private val iosIphoneCaps = List("browserName" -> "iPhone", "platform" -> "MAC") ++ browserStackCaps
  private val androidPhoneCaps = List("browserName" -> "android", "platform" -> "ANDROID") ++ browserStackCaps

  //platform for browsername ios ipad devices
  private val iosIpadRetinaCaps = List("browserName" -> "iPad", "platform" -> "MAC") ++ browserStackCaps
  
  
  
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
  private val win7chrome38Caps = List("browser" -> "Chrome", "browser_version" -> "38.0") ++ windows7Caps
  private val win8chrome38Caps = List("browser" -> "Chrome", "browser_version" -> "38.0") ++ windows8Caps
  private val win81chrome38Caps = List("browser" -> "Chrome", "browser_version" -> "38.0") ++ windows81Caps

  //Browsers and OS for windows and firefox
  private val win7firefox33Caps = List("browser" -> "Firefox", "browser_version" -> "33.0") ++ windows7Caps
  private val win8firefox33Caps = List("browser" -> "Firefox", "browser_version" -> "33.0") ++ windows8Caps
  private val win81firefox33Caps = List("browser" -> "Firefox", "browser_version" -> "33.0") ++ windows81Caps

  //Browsers and OS for MAC OS-X, chrome, firefox and safari
  private val macosxMavericksSafar7Caps = List("browser" -> "Safari", "browser_version" -> "7.0") ++ macosxMavericksCaps
  private val macosxYosemiteSafar8Caps = List("browser" -> "Safari", "browser_version" -> "8.0") ++ macosxYosemiteCaps
  private val macosxYosemitechrome38Caps = List("browser" -> "Chrome", "browser_version" -> "38.0") ++ macosxYosemiteCaps
  private val macosxYosemitefirefox33Caps = List("browser" -> "Firefox", "browser_version" -> "33.0") ++ macosxYosemiteCaps
  
  //Browsername,platform for IOS mobile Devices
  private val iosIphone5SCaps = List("device" -> "iPhone 5S", "emulator" -> "true") ++ iosIphoneCaps

  //Browsername,platform for IOS ipad Devices
  private val iosIpadMiniRetinaCaps = List("device" -> "iPad mini Retina") ++ iosIpadRetinaCaps
  private val iosIpad4thGenCaps = List("device" -> "iPad 4th Gen") ++ iosIpadRetinaCaps
  private val iosIpadAirCaps = List("device" -> "iPad Air") ++ iosIpadRetinaCaps
  private val androidSamsungGalaxyS5Caps = List("device" -> "Samsung Galaxy S5") ++ androidPhoneCaps
  
  

  //private val browserStackURL = s"http://kristapsmelderis1:8YLTc2VvzcxoNQadFpNk@hub.browserstack.com/wd/hub"
  //  private val browserStackURL = s"http://raysonaccenture1:hGsxKmx1tqwGsqpVqWpw@hub.browserstack.com/wd/hub"
  private val browserStackURL = s"http://kuldeepwadhwa1:mq3rdAu3o9e329cqKHMg@hub.browserstack.com/wd/hub"

  private def buildRemoteWebDriver(caps: List[(String,String)]) = {
    val dc = new DesiredCapabilities
    for( (k,v) <- caps )
      dc.setCapability(k, v)
    dc.setCapability("project","PERTAX")
    dc.setCapability("build", "LOCAL")
    new RemoteWebDriver(new URL(browserStackURL), dc)
  }

  // for Windows
  def buildWinXPie6Driver = buildRemoteWebDriver(winXPie6Caps)
  def buildWinXPie7Driver = buildRemoteWebDriver(winXPie7Caps)
  def buildWin7ie8Driver = buildRemoteWebDriver(win7ie8Caps)
  def buildWin7ie9Driver = buildRemoteWebDriver(win7ie9Caps)
  def buildWin7ie10Driver = buildRemoteWebDriver(win7ie10Caps)
  def buildWin7ie11Driver = buildRemoteWebDriver(win7ie11Caps)
  def buildWin8ie10Driver = buildRemoteWebDriver(win8ie10Caps)
  def buildWin81ie11Driver = buildRemoteWebDriver(win81ie11Caps)
  def buildWin7chrome38Driver = buildRemoteWebDriver(win7chrome38Caps)
  def buildWin8chrome38Driver = buildRemoteWebDriver(win8chrome38Caps)
  def buildWin81chrome38CapDriver = buildRemoteWebDriver(win81chrome38Caps)
  def buildWin7firefox33CapDriver = buildRemoteWebDriver(win7firefox33Caps)
  def buildWin8firefox33CapDriver = buildRemoteWebDriver(win8firefox33Caps)
  def buildWin81firefox33Driver = buildRemoteWebDriver(win81firefox33Caps)

  //for MAC OS-X
  def buildMacosxMavericksSafari7Driver = buildRemoteWebDriver(macosxMavericksSafar7Caps)
  def buildMacosxYosemitesSafari8Driver = buildRemoteWebDriver(macosxYosemiteSafar8Caps)
  def buildMacosxYosemitechrome38Driver = buildRemoteWebDriver(macosxYosemitechrome38Caps)
  def buildMacosxYosemitefirefox33Driver = buildRemoteWebDriver(macosxYosemitefirefox33Caps)
  
  //for IOS devices
  def buildIosIphone5SDriver = buildRemoteWebDriver(iosIphone5SCaps)
  def buildIosIpadMiniRetinaDriver = buildRemoteWebDriver(iosIpadMiniRetinaCaps)
  def buildAndroidSamsungGalaxyS5Driver = buildRemoteWebDriver(androidSamsungGalaxyS5Caps)
  
}
