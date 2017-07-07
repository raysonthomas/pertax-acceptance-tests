package uk.gov.hmrc.integration.page

import org.openqa.selenium.WebDriver
import uk.gov.hmrc.integration.utils.GoogleAnalytics
import uk.gov.hmrc.integration.utils.GoogleAnalytics.GaCall


object GoogleAnalyticsAssertions {

  def assertGoogleAnalyticsEventSent(category: String, action: String, label: String)(implicit webDriver: WebDriver) = {
    val expectedArgs: List[String] = List("ga", "send", "event", category, action, label)
    assert(
      GoogleAnalytics.getAllGaCalls(webDriver).contains(GaCall(expectedArgs)),
      s"""No call to google analytics matching ga('${expectedArgs.mkString("','")}') detected"""
    )
  }

  def assertGoogleAnalyticsPageViewSent(label: String)(implicit webDriver: WebDriver) = {
    val expectedArgs: List[String] = List("ga", "set", "pageview", label)
    assert(
      GoogleAnalytics.getAllGaCalls(webDriver).contains(GaCall(expectedArgs)),
      s"""No call to google analytics matching ga('${expectedArgs.mkString("','")}') detected"""
    )
  }
}
