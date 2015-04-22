package uk.gov.hmrc.integration.utils

import org.openqa.selenium.{WebDriver, By}

object Configuration {

  val DeviceViewBreakpoint = 768

  lazy val environment = System.getProperty("environment", "local").toLowerCase match {
    case "local" => Map("id" -> "local", "url" -> "http://localhost:9232/pertax",              "defaultWait" -> "200")
    case "dev"   => Map("id" -> "dev",   "url" -> "https://www-dev.tax.service.gov.uk/pertax", "defaultWait" -> "70")
    case "qa"    => Map("id" -> "qa",    "url" -> "https://web-qa.tax.service.gov.uk/pertax",  "defaultWait" -> "70")
    case _ => throw new IllegalArgumentException(s"environment system property is invalid")
  }

  def apply(key: String) = environment(key)
}