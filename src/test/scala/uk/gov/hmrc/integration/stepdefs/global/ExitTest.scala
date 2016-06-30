package uk.gov.hmrc.integration.stepdefs.global

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.openqa.selenium.By.ByCssSelector
import org.openqa.selenium.support.ui.WebDriverWait
import uk.gov.hmrc.integration.page._
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.CustomExpectedConditions
import uk.gov.hmrc.integration.utils.Configuration

class ExitTest extends ScalaDsl with EN {


  And( """^user sees text '(.*)' on the Exit page$""") {
    (expectedText: String) => withCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(expectedText), s"\n'$expectedText' text was not found on the page")
    }
  }

  Then( """^user selects yes radio button on 'before using your tax account' question""") {
      withCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.id("beforeUsingYourTaxAccount-1")).click()
      }
  }

  Then( """^user selects no radio button on 'before using your tax account' question""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.id("beforeUsingYourTaxAccount-0")).click()
    }
  }

  Then( """^user selects other checkbox""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.id("other")).click()
    }
  }


  And( """^user sees the radio button '(.*)'$""") {
    (answer: String) =>
      withCurrentDriver { implicit webDriver =>
        if (webDriver.getPageSource.contains(answer))
          webDriver.findElement(By.xpath(".//*[@type='radio' and @value='"+answer+"']"))

      }
  }


  Then( """^user sees checkbox '(.*)'$""") {
    (answer: String) =>
      withCurrentDriver { implicit webDriver =>
        if (webDriver.getPageSource.contains(answer))
          webDriver.findElement(By.xpath(".//*[@type='checkbox' and @value='"+answer+"']"))

      }
  }

  Then( """^user sees radio button '(.*)' with ID '(.*)'$""") {
    (button: String, id: String) =>
      withCurrentDriver { implicit webDriver =>
        if (webDriver.getPageSource.contains(button))
          webDriver.findElement(By.id(id))
      }
  }

  Then( """^and checkbox is ticked '(.*)'$""") {
    (answer: String) =>
      withCurrentDriver { implicit webDriver =>
        if (webDriver.getPageSource.contains(answer))
          webDriver.findElement(By.xpath(".//*[@type='checkbox' and @checked='true']"))

      }
  }

  When( """^user clicks checkbox '(.*)'$""") {
    (checkboxId: String) =>
      withCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.id(checkboxId)).click()
      }
  }

  Then( """^user now sees the 'do you still need to phone or write' question""" ) {
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.findElement(By.id("stillReduceHMRCPhoneCalls-2")).isDisplayed, "The expected button not displayed")
    }
  }

  Then( """^user now sees the 'Please state' text box""" ) {
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.findElement(By.id("pleaseState")).isDisplayed, "The expected text box was not displayed")
    }
  }

  Then( """^user now sees the 'do you now need to phone or write' question""" ) {
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.findElement(By.id("nowReduceHMRCPhoneCalls-2")).isDisplayed, "The expected button not displayed")
    }
  }

  And( """^user enters the 10 characters: '(.*)' into the free text box""") {
    (value: String) => withCurrentDriver { implicit webDriver =>
      val field = webDriver.findElement(By.className("char-counter"))
      field.clear()
      field.sendKeys(value)
    }
  }

  And( """^user clicks on the '(.*)' button$""") {
    (id: String) => withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.className(id)).click()
    }
  }


}
