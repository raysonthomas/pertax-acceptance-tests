package uk.gov.hmrc.integration.stepdefs.holly

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._


class PersonalAllowanceTests extends ScalaDsl with EN {

  Given( """^'(.*)' has a personal allowance of £'(.*)'$""") {
    (user: String, personalAllowance: String) =>
    withCurrentDriver { implicit webDriver =>

      println(user)
      println(personalAllowance)

    }
  }

  Given( """^'(.*)' works at '(.*)' Employer Ref: '(.*)' / Payroll ID: '(.*)' as a '(.*)'$""") {
    (user: String, employer: String, employerRef: String, payrollID: String, jobTitle: String) =>
    withCurrentDriver { implicit webDriver =>

      println(user)
      println(employer)
      println(employerRef)
      println(payrollID)
      println(jobTitle)

    }
  }

  Given( """^PTA forecasts yearly income as £'(.*)' because FPS data for Employer Ref: '(.*)' / Payroll ID: '(.*)' states cumulative '(.*)' earnings: April=£'(.*)', May=£'(.*)', June=£'(.*)', July=£'(.*)'$""") {
    (yearlyIncomeForecast: String, employerRef: String, payrollID: String, incomeGranularity: String, cumulativeAtApril: String, cumulativeAtMay: String, cumulativeAtJune: String, cumulativeAtJuly: String) =>
      withCurrentDriver { implicit webDriver =>

        println(yearlyIncomeForecast)
        println(employerRef)
        println(payrollID)
        println(incomeGranularity)
        println(cumulativeAtApril)
        println(cumulativeAtMay)
        println(cumulativeAtJune)
        println(cumulativeAtJuly)

      }
  }

  Given( """^FPS holds data stating that '(.*)' Employer Ref: '(.*)' has assigned '(.*)' a tax code of '(.*)' on Payroll ID: '(.*)'$""") {
    ( employer: String, employerRef: String, person: String, taxCode: String, payrollID: String) =>
      withCurrentDriver { implicit webDriver =>

        println(employer)
        println(employerRef)
        println(person)
        println(taxCode)
        println(payrollID)

      }
  }

  Then( """^PTA Alerts the user about his unused Personal Allowance of '(.*)'$""") {
    (unusedPersonalAllowance: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(!webDriver.findElement(By.cssSelector(".heading-medium")).getText.equals(s"You have $unusedPersonalAllowance as unused Personal allowance"),
        s"could not find text:'You have $unusedPersonalAllowance as unused Personal allowance' on the screen *sad panda*")
    }
  }

}
