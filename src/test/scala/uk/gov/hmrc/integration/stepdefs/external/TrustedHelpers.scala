package uk.gov.hmrc.integration.stepdefs.external

import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Assert
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils.Configuration
import uk.gov.hmrc.integration.utils.TestDataSource._

import scala.collection.JavaConversions._

class TrustedHelpers extends ScalaDsl with EN {

  When( """^user searches for '(.*)', '(.*)', '(.*)', '(.*)-(.*)-(.*)' DD-MM-YYYY and submits the request$""") {
    (name: String, surname: String, nino: String, dobDay: String, dobMonth: String, dobYear: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.id("firstName")).sendKeys(name)
        webDriver.findElement(By.id("lastName")).sendKeys(surname)
        webDriver.findElement(By.id("nino")).sendKeys(nino)
        webDriver.findElement(By.id("dob.day")).sendKeys(dobDay)
        webDriver.findElement(By.id("dob.month")).sendKeys(dobMonth)
        webDriver.findElement(By.id("dob.year")).sendKeys(dobYear)
        webDriver.findElement(By.id("submit")).click()
        (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(ExpectedConditions.elementToBeClickable(By.id("radio-1"))))
        webDriver.findElement(By.xpath(".//input[@id='radio-1']")).click()
        webDriver.findElement(By.id("auto_id_confirm_button")).click()
        webDriver.findElement(By.xpath(".//input[@id='radio-2']")).click()
        webDriver.findElement(By.id("auto_id_confirmed_button")).click()
      }
  }

  When( """^user submits his decision to help$""") {
    () =>
      provisioningCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.id("radio-1")).click()
        webDriver.findElement(By.id("auto_id_confirm_submit")).click()
      }
  }

  When( """^user clicks on '(.*)' link to help someone$""") {
    (linkName: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.linkText(linkName)).click()
      }
  }

  When( """^user clicks on link '(.*)'$""") {
    (linkName: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.linkText(linkName)).click()
      }
  }

  And( """^user is able to see '(.*)' link on the page$""") {
//        Thread.sleep(2000)
    (expectedLinkText: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.linkText(expectedLinkText))
      }
  }

  When( """^user selects PTA service to help with$""") {
    () =>
      provisioningCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.id("pertax")).click()
        webDriver.findElement(By.id("accessServiceButton")).click()
      }
  }

  Then( """^text '(.*)' is visible in the banner$""") {
    (name: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        val banner = webDriver.findElement(By.xpath(".//*[@id='attorneyBanner']/div[1]/div"))
        assert(banner.getText.contains(name), s"\n$name text was not found in banner"
        )
      }
  }

  Then( """^user removes existing relations if any$""") {
    () =>
      provisioningCurrentDriver { implicit webDriver =>

        if (webDriver.getPageSource.contains("End contact")){
          webDriver.findElement(By.linkText("End contact")).click()
          webDriver.findElement(By.id("radio-1")).click()
          webDriver.findElement(By.id("auto_id_confirm_submit")).click()
          (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("/help-cancelled")))
          println("help cancelled page is displayed")
          Thread.sleep(3000)
          webDriver.findElement(By.partialLinkText("Trusted Helpers")).click()
//          webDriver.findElement(By.linkText("Return to my Trusted Helper contacts")).click()
          (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("/trusted-helpers")))

        }

        if (webDriver.getPageSource.contains("Cancel request")){
          webDriver.findElement(By.linkText("Cancel request")).click()
          webDriver.findElement(By.id("cancel_request")).click()
          Thread.sleep(3000)
//          webDriver.findElement(By.linkText("Return to my Trusted Helper contacts")).click()
          webDriver.findElement(By.partialLinkText("Trusted Helpers")).click()
        }
      }
  }




  Then( """^user ends contact$""") {
    () =>
      provisioningCurrentDriver { implicit webDriver =>

          webDriver.findElement(By.linkText("End contact")).click()
          webDriver.findElement(By.id("radio-1")).click()
          webDriver.findElement(By.id("auto_id_confirm_submit")).click()
      }
  }

}
