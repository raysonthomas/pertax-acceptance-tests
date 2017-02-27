package uk.gov.hmrc.integration.utils

import org.openqa.selenium.{WebDriver, By}

object Configuration {

  val getUrlScreenshots = false

  val DeviceViewBreakpoint = 768

  val defaultWait = Option(System.getProperty("defaultWait")).getOrElse("30")

  lazy val environment = System.getProperty("environment", "local").toLowerCase match {
    case "local" => Map(
      "id" -> "local",
      "url" -> "http://localhost:9949/auth-login-stub",
      "defaultWait" -> defaultWait
    )
    case "dev" => Map(
      "id" -> "dev",
      "url" -> "https://www-dev.tax.service.gov.uk/personal-account",
      "defaultWait" -> defaultWait
    )
    case "qa" => Map(
      "id" -> "qa",
      "url" -> "https://web-qa.tax.service.gov.uk/personal-account",
      "defaultWait" -> defaultWait
    )
    case _ => throw new IllegalArgumentException(s"environment system property is invalid")
  }

  def apply(key: String) = environment(key)
}