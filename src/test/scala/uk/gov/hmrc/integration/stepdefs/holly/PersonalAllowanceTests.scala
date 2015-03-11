package uk.gov.hmrc.integration.stepdefs.holly

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._


class PersonalAllowanceTests extends ScalaDsl with EN {

  Given( """^'(.*)' has a personal allowance of £'(.*)'$""") {
    (personalAllowance: BigDecimal) =>
    withCurrentDriver { implicit webDriver =>

      println(personalAllowance)

    }
  }

  Given( """^'(.*)' works at '(.*)' Employer Ref: '(.*)' / Payroll ID: '(.*)' as a '(.*)'$""") {
    (user: String, employment: String, employerRef: String, payrollID: String, jobTitle: String) =>
    withCurrentDriver { implicit webDriver =>

      println(user)
      println(employment)
      println(employerRef)
      println(payrollID)
      println(jobTitle)

    }
  }

  Given( """^PTA forecasts yearly income as £'(.*)' because FPS data for Employer Ref: '(.*)' / Payroll ID: '(.*)' states cumulative '(.*)' earnings: April=£'(.*)', May=£'(.*)', June=£'(.*)', July=£'(.*)'$""") {
    (user: String, employment: String, employerRef: String, payrollID: String, jobTitle: String) =>
      withCurrentDriver { implicit webDriver =>

        println(user)
        println(employment)
        println(employerRef)
        println(payrollID)
        println(jobTitle)

      }
  }

  Given( """^FPS holds data stating that '(.*)' Employer Ref: '(.*)' has assigned '(.*)' a tax code of '(.*)' on Payroll ID: '(.*)'$""") {
    (user: String, employment: String, employerRef: String, payrollID: String, jobTitle: String) =>
      withCurrentDriver { implicit webDriver =>

        println(user)
        println(employment)
        println(employerRef)
        println(payrollID)
        println(jobTitle)

      }
  }

  Then( """^PTA Alerts the user about his unused Personal Allowance of '(.*)'$""") {
    (unusedPersonalAllowance: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(!webDriver.findElement(By.cssSelector(".heading-medium")).getText.equals(s"Your personal allowance is: $unusedPersonalAllowance"),
        s"'$unusedPersonalAllowance' value was not found in '.heading-medium' field")
    }
  }

}
