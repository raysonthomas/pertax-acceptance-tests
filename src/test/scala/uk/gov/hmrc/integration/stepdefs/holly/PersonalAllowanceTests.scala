package uk.gov.hmrc.integration.stepdefs.holly

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.selenium.CurrentDriver._


class PersonalAllowanceTests extends ScalaDsl with EN {

  Given( """^'(.*)' has a personal allowance of £'(.*)'$""") {
    (user: String, personalAllowance: String) =>
    withCurrentDriver { implicit webDriver =>

    }
  }

  Given( """^'(.*)' works at '(.*)' Employer Ref: '(.*)' / Payroll ID: '(.*)' as a '(.*)'$""") {
    (user: String, employer: String, employerRef: String, payrollID: String, jobTitle: String) =>
    withCurrentDriver { implicit webDriver =>

    }
  }

  Given( """^PTA forecasts yearly income as £'(.*)' because FPS data for Employer Ref: '(.*)' / Payroll ID: '(.*)' states cumulative '(.*)' earnings: April=£'(.*)', May=£'(.*)', June=£'(.*)', July=£'(.*)'$""") {
    (yearlyIncomeForecast: String, employerRef: String, payrollID: String, incomeGranularity: String, cumulativeAtApril: String, cumulativeAtMay: String, cumulativeAtJune: String, cumulativeAtJuly: String) =>
      withCurrentDriver { implicit webDriver =>

      }
  }

  Given( """^FPS holds data stating that '(.*)' Employer Ref: '(.*)' has assigned '(.*)' a tax code of '(.*)' on Payroll ID: '(.*)'$""") {
    ( employer: String, employerRef: String, person: String, taxCode: String, payrollID: String) =>
      withCurrentDriver { implicit webDriver =>

      }
  }

  Then( """^PTA Alerts the user: '(.*)'$""") {
    (alert: String) =>
    withCurrentDriver { implicit webDriver =>
      assert(!webDriver.findElement(By.cssSelector(".annual-income-notification")).getText.equals(alert + ".*"),
        s"could not find text:'$alert' in '.annual-income-notification' field")
    }
  }

}
