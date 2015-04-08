package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._
import uk.gov.hmrc.integration.utils.Configuration

class BreadCrumbTest extends ScalaDsl with EN {

  Then( """^'(.*)' clicks on '(.*)' breadcrumb link$""") {
    (user: String, linkName: String) =>
      withCurrentDriver { implicit webDriver =>
        GlobalActions.clickLinkThenExplicitWaitForPath(By.linkText(linkName))
      }
  }

  Then( """^Breadcrumb is: '(.*)'$""") {
    (expectedBreadcrumb: String) =>
      withCurrentDriver { implicit webDriver =>

        val expectedBreadcrumbList = expectedBreadcrumb.split(">").map(_.trim).toList
        val actualBreadcrumbList = webDriver.findElements(By.cssSelector("#global-breadcrumb li")).toList
          .map(i => (i.getText, i.findElements(By.tagName("a")).map(_.getAttribute("href")).headOption))

        //this is where breadcrumb URLs are defined
        def verifyBreadcrumbUrl(textAndUrl: (String, Option[String])): Boolean = {
          def urlEndsWithOrFalse(o: Option[String], e: String): Boolean = o.exists(_.endsWith(e))
          val (text, url) = textAndUrl
          text match {
            case "Home" => url == Some(s"${Configuration("url")}" + "")
            case _ => false
          }
        }

        //this tests breadcrumb text
        assert(actualBreadcrumbList.map(_._1) == expectedBreadcrumbList,
          s"actual breadcrumb: (${actualBreadcrumbList.map(_._1)}) did not match expected breadcrumb: ($expectedBreadcrumbList)")

        //this tests breadcrumb URLs
        actualBreadcrumbList filter (_._2 != None) foreach { item =>
          assert(verifyBreadcrumbUrl(item), s"URL for ${item._1} was not correct")
        }
      }
  }

}