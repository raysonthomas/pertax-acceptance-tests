package uk.gov.hmrc.integration.stepdefs.service

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebElement}
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.Configuration

import scala.collection.JavaConversions._

class BreadCrumbTest extends ScalaDsl with EN {

  Then( """^Breadcrumb is: '(.*)'$""") {
    (expectedBreadcrumb: String) =>
      provisioningCurrentDriver { implicit webDriver =>

        if (expectedBreadcrumb == "") {
          assert(!webDriver.getPageSource.contains("global-breadcrumb"), "global-breadcrumb was present but it should not be present")
        }
        else {

          val expectedBreadcrumbList: List[String] = expectedBreadcrumb.split(">").map(_.trim).toList
          val actualBreadcrumbElementList = webDriver.findElements(By.cssSelector("#global-breadcrumb li")).toList

          val actualBreadcrumb = {
            def loop(in: List[WebElement], acc: List[(String, Option[String])]): List[(String, Option[String])] = in match {
              case Nil      => acc //Shouldn't happen, 'x :: Nil' will be final iteration
              case x :: Nil => (x.getText, None) :: acc
              case x :: xs  => loop(xs, (x.getText, x.findElements(By.tagName("a")).map(_.getAttribute("href")).headOption) :: acc)
            }
            loop(actualBreadcrumbElementList, Nil).reverse
          }

          //this is where breadcrumb URLs are defined
          def verifyBreadcrumbUrl(textAndUrl: (String, Option[String])): Boolean = {
            def urlEndsWithOrFalse(o: Option[String], e: String): Boolean = o.exists(_.endsWith(e))
            val (text, url) = textAndUrl
            text match {
              case "Account home" => url.get.endsWith("/personal-account?b=true")
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

  Then( """^user is on the page with title '(.*)' after clicking Account Home breadcrumb$""") {
    (expectedPageTitle: String) => provisioningCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      val currentUrl = webDriver.getCurrentUrl
      assert(currentUrl.endsWith("/personal-account?b=true"), "\n current page URL was:\n $currentUrl \nit did not end with:\n /personal-account?b=true")
      assert(actualPageTitle == expectedPageTitle, s"Page title '$actualPageTitle' is not equal to '$expectedPageTitle'")
    }
  }

}
