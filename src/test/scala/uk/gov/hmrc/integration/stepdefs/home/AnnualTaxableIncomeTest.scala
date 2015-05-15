package uk.gov.hmrc.integration.stepdefs.home

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import scala.collection.JavaConversions._

class AnnualTaxableIncomeTest extends ScalaDsl with EN {

  Given( """^Annual Taxable Income section is visible$""") {
    () =>
    withCurrentDriver { implicit webDriver =>
      val testable = "Annual taxable income"
      assert(webDriver.findElements(By.cssSelector(".heading-large.no-margin-bottom")).filter(_.getText == testable).nonEmpty,
        s"$testable was not found in '.heading-large.no-margin-bottom' field"
      )
    }
  }

  Given( """^Annual Taxable Income is displayed as '(.*)'$""") {
    (annualTaxableIncomeValue: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.findElements(By.cssSelector(".bold-xlarge.no-margin-top.no-margin-bottom")).filter(_.getText == annualTaxableIncomeValue).nonEmpty,
        s"'$annualTaxableIncomeValue' was not found in '.bold-xlarge.no-margin-top.no-margin-bottom' field"
      )
    }
  }

}
