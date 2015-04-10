package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{WebElement, By}
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
        val actualBreadcrumbElementList = webDriver.findElements(By.cssSelector("#global-breadcrumb li")).toList
        val actualBreadcrumb = {
          def loop(in: List[WebElement], acc: List[(String, Option[String])]): List[(String, Option[String])] = in match {
            case x :: Nil => (x.getText, None) :: acc
            case x :: xs => loop(xs, (x.getText, x.findElements(By.tagName("a")).map(_.getAttribute("href")).headOption) :: acc)
          }
          loop(actualBreadcrumbElementList, Nil).reverse
        }

        //this is where breadcrumb URLs are defined
        def verifyBreadcrumbUrl(textAndUrl: (String, Option[String])): Boolean = {
          def urlEndsWithOrFalse(o: Option[String], e: String): Boolean = o.exists(_.endsWith(e))
          val (text, url) = textAndUrl
          text match {
            case "Home" => url == Some(s"${Configuration("url")}")
            case _ => false
          }
        }

        //this tests breadcrumb text
        assert(actualBreadcrumb.map(_._1) == expectedBreadcrumbList,
          s"actual breadcrumb: (${actualBreadcrumb.map(_._1)}) did not match expected breadcrumb: ($expectedBreadcrumbList)")

        //this tests breadcrumb URLs
        actualBreadcrumb filter (_._2 != None) foreach { item =>
          assert(verifyBreadcrumbUrl(item), s"URL for ${item._1} was not correct")
        }
      }
  }

}