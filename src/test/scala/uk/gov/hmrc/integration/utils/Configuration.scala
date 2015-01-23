package uk.gov.hmrc.integration.utils

object Configuration {

  val PageTimeOut = 60

  val DeviceViewBreakpoint = 768

  lazy val environment = System.getProperty("environment", "local").toLowerCase match {
    case "local" => Map("url" -> "http://localhost:9232/pertax")
    case "dev" => Map("url" -> "https://www-dev.tax.service.gov.uk/pertax")
    case _ => throw new IllegalArgumentException(s"environment system property is invalid")
  }

  def apply(key: String) = environment(key)
}