package uk.gov.hmrc.integration.stepdefs.external

import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Assert
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{WebElement, WebDriver, By}
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.utils.TestDataSource._
import scala.collection.JavaConversions._

class TrustedHelpers extends ScalaDsl with EN {

  When( """^user searches for '(.*)', '(.*)', '(.*)', '(.*)-(.*)-(.*)' DD-MM-YYYY and submits the request$""") {
    (name: String, surname: String, nino: String, dobDay: String, dobMonth: String, dobYear: String) =>
      withCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.id("firstName")).sendKeys(name)
        webDriver.findElement(By.id("lastName")).sendKeys(surname)
        webDriver.findElement(By.id("nino")).sendKeys(nino)
        webDriver.findElement(By.id("dob.day")).sendKeys(dobDay)
        webDriver.findElement(By.id("dob.month")).sendKeys(dobMonth)
        webDriver.findElement(By.id("dob.year")).sendKeys(dobYear)
        webDriver.findElement(By.id("submit")).click()
        webDriver.findElement(By.id("radio-1")).click()
        webDriver.findElement(By.id("auto_id_confirm_button")).click()
        webDriver.findElement(By.id("radio-2")).click()
        webDriver.findElement(By.id("auto_id_confirmed_button")).click()
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

  When( """^user clicks on link '(.*)'$""") {
    (linkName: String) =>
      withCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.linkText(linkName)).click()
      }
  }

  And( """^user is able to see '(.*)' link on the page$""") {
    (expectedLinkText: String) =>
      withCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.linkText(expectedLinkText))
      }
  }

  When( """^user selects PTA service to help with$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.id("pertax")).click()
        webDriver.findElement(By.id("accessServiceButton")).click()
      }
  }

  Then( """^text '(.*)' is visible in the banner$""") {
    (name: String) =>
      withCurrentDriver { implicit webDriver =>
        val banner = webDriver.findElement(By.xpath(".//*[@id='attorneyBanner']/div[1]/div"))
        assert(banner.getText.contains(name), s"\n$name text was not found in banner"
        )
      }
  }

  Then( """^user removes existing relations if any$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
          if (!webDriver.findElements(By.linkText("End contact")).isEmpty) {
          webDriver.findElement(By.linkText("End contact")).click()
          webDriver.findElement(By.id("radio-1")).click()
          webDriver.findElement(By.id("auto_id_confirm_submit")).click()
          webDriver.findElement(By.linkText("Return to my Trusted Helper contacts")).click()
        }

        if (!webDriver.findElements(By.linkText("Cancel request")).isEmpty) {
          webDriver.findElement(By.linkText("Cancel request")).click()
          webDriver.findElement(By.id("cancel_request")).click()
          webDriver.findElement(By.linkText("Return to my Trusted Helper contacts")).click()
        }
      }
  }

}
