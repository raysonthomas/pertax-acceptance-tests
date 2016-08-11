package uk.gov.hmrc.integration.stepdefs.external

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import java.util.ArrayList

import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.utils.TestDataSource._

class HomePage extends ScalaDsl with EN {

   Then( """^heading '(.*)' is visible$""") {
    (name: String) =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.getPageSource.contains(name), s"\n$name heading was not found in page"
        )
      }
  }

  And( """^user sees text '(.*)' on the home page$""") { (text: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }

  And( """^user sees text '(.*)' is visible on Child Benefit Page$""") { (text: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(text), s"Text $text not found on page")
    }
  }

  And( """^user does not see text '(.*)' on the home page$""") { (text: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(!webDriver.getPageSource.contains(text), s"Text $text found on page when not expected")
    }
  }

  When( """^user sees '(.*)'.* link on the page and the href is as expected""") {
    (linkName: String) => withCurrentDriver { implicit webDriver =>
      GlobalActions.maybeClickMenu
      GlobalActions.clickLinkThenExplicitWaitForPath(By.linkText(linkName))
    }
  }

And( """^user sees '(.*)' link for EU Referendum$""") { (link: String) =>
 withCurrentDriver { implicit webDriver =>
   val href = webDriver.findElement(By.partialLinkText(link)).getAttribute("href")
   assert(href.contains("eureferendum.gov.uk"), "link href did not match expected")

  }
 }


  And( """^user does not see the link  '(.*)' on the home page$""") { (linkName: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(!webDriver.getPageSource.contains(linkName), s"$linkName is present on the page")

    }
  }

}