package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class AnnualTaxableIncomeTest extends ScalaDsl with EN {

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
