package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class AnnualTaxableIncomeTest extends ScalaDsl with EN {

  Then( """^'(.*)' section is displayed$""") {
    (sectionName: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.findElements(By.cssSelector(".annual-taxable-income h2")).filter(_.getText == sectionName).nonEmpty,
        s"'$sectionName' was not found in '.annual-taxable-income h2' field"
      )
    }
  }

  And( """^'.*' section contains a tax estimate$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.findElements(By.cssSelector(".income-estimate p")).nonEmpty,
          "Annual Taxable Income estimate was not found in '.income-estimate p' field"
        )
      }
  }

  And( """^the 'View details' link leads to the TAI landing page$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        val targetURL = "/check-income-tax/income-tax"
        assert(webDriver.findElements(By.cssSelector(".income-estimate a")).filter(_.getAttribute("href").contains(targetURL)).nonEmpty,
          s"the 'View details' link leads to the TAI tax estimate page URL '$targetURL' was not found in '.income-estimate a' field"
        )
      }
  }

  And( """^Tax you'll pay link leads to the TAI landing page$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        val targetURL = "/check-income-tax/income-tax"
        assert(webDriver.findElements(By.cssSelector(".tax-estimate a")).filter(_.getAttribute("href").contains(targetURL)).nonEmpty,
          s"Tax you'll pay link leads to the TAI tax you'll pay page URL '$targetURL' was not found in '.tax-estimate a' field"
        )
      }
  }

}
