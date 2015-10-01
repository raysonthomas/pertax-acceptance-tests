package uk.gov.hmrc.integration.stepdefs.external

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._

class TrustedHelpers extends ScalaDsl with EN {

  When( """^user enters details for '(.*)', '(.*)', '(.*)', '(.*)-(.*)-(.*)' DD-MM-YYYY$""") {
    (name: String, surname: String, nino: String, dobDay: String, dobMonth: String, dobYear: String) =>
      withCurrentDriver { implicit webDriver =>

        val firstNameField = webDriver.findElement(By.id("firstName"))
        val lastNameField = webDriver.findElement(By.id("lastName"))
        val ninoField = webDriver.findElement(By.id("nino"))
        val dayField = webDriver.findElement(By.id("dob.day"))
        val monthField = webDriver.findElement(By.id("dob.month"))
        val yearField = webDriver.findElement(By.id("dob.year"))

        firstNameField.sendKeys(name)
        lastNameField.sendKeys(surname)
        ninoField.sendKeys(nino)
        dayField.sendKeys(dobDay)
        monthField.sendKeys(dobMonth)
        yearField.sendKeys(dobYear)

      }
  }

  When( """^user confirms that the found helper's NINO is '(.*)'$""") {
    (expectedNino: String) =>
      withCurrentDriver { implicit webDriver =>

        val actualNino = webDriver.findElement(By.id("auto_id_nino")).getText
        assert(actualNino == expectedNino, s"\n# expected nino was: $expectedNino\n# actual nino was: $actualNino\n")

        val yesButton = webDriver.findElement(By.id("radio-1"))
        yesButton.click()

        val continueButton = webDriver.findElement(By.id("auto_id_confirm_button"))
        continueButton.click()

      }
  }

  When( """^user submits his decision to help$""") {
    (expectedNino: String) =>
      withCurrentDriver { implicit webDriver =>

        val yesButton = webDriver.findElement(By.id("radio-1"))
        yesButton.click()

        val submitButton = webDriver.findElement(By.id("auto_id_confirm_submit"))
        submitButton.click()

      }

  }

  When( """^user chooses Personal Tax Account option$""") {
    () =>
      withCurrentDriver { implicit webDriver =>

        val PTAradio = webDriver.findElement(By.id("pertax"))
        PTAradio.click()

        val accessServiceButton = webDriver.findElement(By.id("accessServiceButton"))
        accessServiceButton.click()

      }

  }


  And( """^user clicks on the link Help John$""") {
    () =>
      withCurrentDriver { implicit webDriver =>

        val helplink = webDriver.findElement(By.partialLinkText("Help John"))
        helplink.click()

//        val accessServiceButton = webDriver.findElement(By.id("accessServiceButton"))
//        accessServiceButton.click()

      }

  }

}
