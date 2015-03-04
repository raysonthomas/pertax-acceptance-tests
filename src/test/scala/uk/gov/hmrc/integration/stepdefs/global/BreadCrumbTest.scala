package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class BreadCrumbTest extends ScalaDsl with EN {

  Then( """^'(.*)' breadcrumb link is displayed$""") { (linkName: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(
        webDriver.findElements(By.cssSelector(".group>li")).filter(_.getText == linkName).isEmpty == false,
        s"$linkName was not found"

      )
    }
  }

  Then( """^'(.*)' clicks on '(.*)' breadcrumb link$""") { (user: String, linkName: String) =>
    withCurrentDriver { implicit webDriver =>
      GlobalActions.clickLinkThenExplicitWaitForPath(By.linkText(linkName))
    }
  }

}
