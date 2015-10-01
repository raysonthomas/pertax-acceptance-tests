package uk.gov.hmrc.integration.stepdefs.external

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._

class TrustedHelpers extends ScalaDsl with EN {

  When( """^user searches for '(.*)', '(.*)', '(.*)', '(.*)-(.*)-(.*)' DD-MM-YYYY and submits the request$""") {
    (name: String, surname: String, nino: String, dobDay: String, dobMonth: String, dobYear: String) =>
      withCurrentDriver { implicit webDriver =>
        //query
        webDriver.findElement(By.id("firstName")).sendKeys(name)
        webDriver.findElement(By.id("lastName")).sendKeys(surname)
        webDriver.findElement(By.id("nino")).sendKeys(nino)
        webDriver.findElement(By.id("dob.day")).sendKeys(dobDay)
        webDriver.findElement(By.id("dob.month")).sendKeys(dobMonth)
        webDriver.findElement(By.id("dob.year")).sendKeys(dobYear)
        webDriver.findElement(By.id("submit")).click()
        //confirm & submit request
        webDriver.findElement(By.id("radio-1")).click()
        webDriver.findElement(By.id("auto_id_confirm_button")).click()
      }
  }

  When( """^user submits his decision to help$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.id("radio-1")).click()
        webDriver.findElement(By.id("auto_id_confirm_submit")).click()
      }
  }

  When( """^user clicks on '(.*)' link to help someone$""") {
    (linkName: String) =>
      withCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.linkText(linkName)).click()
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


}
