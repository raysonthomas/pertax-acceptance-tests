package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class AnnualTaxableIncomeTest extends ScalaDsl with EN {

  Then( """^The Annual Taxable Income section is displayed$""") {
    () =>
    withCurrentDriver { implicit webDriver =>
      val testable = "Annual taxable income"
      assert(webDriver.findElements(By.cssSelector(".annual-taxable-income h2")).filter(_.getText == testable).nonEmpty,
        s"'$testable' was not found in '.annual-taxable-income h2' field"
      )

    }
  }


  And( """^that section contains annual taxable income estimate$""") {
    () =>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.findElements(By.cssSelector(".income-estimate p")).nonEmpty,
        "Annual Taxable Income estimate was not found in '.income-estimate p' field"
      )
    }
  }


  And( """^that section contains a tax estimate$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.findElements(By.cssSelector(".tax-estimate-value")).nonEmpty,
          "Annual Taxable Income estimate was not found in '.tax-estimate-value' field"
        )
      }
  }

  And( """^the 'View details' link leads to the TAI tax estimate page$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        val targetURL = "/tai/incomes"
        assert(webDriver.findElements(By.cssSelector(".income-estimate a")).filter(_.getAttribute("href").contains(targetURL)).nonEmpty,
          s"the 'View details' link leads to the TAI tax estimate page URL '$targetURL' was not found in '.income-estimate a' field"
        )
      }
  }

  And( """^Tax you'll pay link leads to the TAI tax you'll pay page$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        val targetURL = "/tai/current-year"
        assert(webDriver.findElements(By.cssSelector(".tax-estimate a")).filter(_.getAttribute("href").contains(targetURL)).nonEmpty,
          s"Tax you'll pay link leads to the TAI tax you'll pay page URL '$targetURL' was not found in '.tax-estimate a' field"
        )
      }
  }




}
