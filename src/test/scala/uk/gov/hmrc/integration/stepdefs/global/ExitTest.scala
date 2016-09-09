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
      webDriver.findElement(By.id("beforeUsingYourPersonalTaxAccount-1")).click()
    }
  }

  Then( """^user selects no radio button on 'before using your tax account' question""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.id("beforeUsingYourPersonalTaxAccount-0")).click()
    }
  }

  Then( """^user selects other checkbox""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("input[name=\"other\" ][id=\"other\"]")).click()
    }
  }

  Then( """^the 'Friend or family member' checkbox should not be selected""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("input[name=\"#friendOrFamily\" ][id=\"#friendOrFamily\"]")).clear()
    }
  }

  When( """^user selects checkbox 'I didn’t get help' on 'get help' question""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("input[name=\"#didntNeedHelp\" ][id=\"#didntNeedHelp\"]")).clear()
    }
  }

  Then( """^the 'I didn't get help' checkbox should not be selected""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("input[name=\"#didntNeedHelp\" ][id=\"#didntNeedHelp\"]")).clear()
    }
  }

  When( """user selects 'Friend or family member' checkbox""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("input[name=\"#friendOrFamily\" ][id=\"#friendOrFamily\"]")).click()
    }
  }

  And( """user selects 'I didn’t get help' checkbox""") {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector("input[name=\"#didntNeedHelp\" ][id=\"#didntNeedHelp\"]")).click()
    }
  }

  And( """^user now sees the '(.*)' text box""" ) {(Textboxname: String)=>
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.findElement(By.name(Textboxname)).isDisplayed, "The expected text box was not displayed")
    }
  }

  And( """^user sees the radio button '(.*)'$""") {
    (answer: String) =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.getPageSource.contains(answer), "The answers not found when expected")
      }
  }

  Then( """^user sees checkbox '(.*)'$""") {
    (answer: String) =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.getPageSource.contains(answer),"Checkbox for answer not found")
        //        webDriver.findElement(By.xpath(".//*[@type='checkbox' and @value='"+answer+"']"))
      }
  }

  Then( """^user sees radio button '(.*)' with ID '(.*)'$""") {
    (button: String, id: String) =>
      withCurrentDriver { implicit webDriver =>
        if (webDriver.getPageSource.contains(button))
          webDriver.findElement(By.id(id))
      }
  }

  Then( """^user sees radio button 'Yes' under Before using your tax account$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.findElement(By.cssSelector("#beforeUsingYourPersonalTaxAccount-1")).isDisplayed, "Button not displayed")
      }
  }

  Then( """^user sees radio button 'No' under Before using your personal tax account$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.findElement(By.cssSelector("#beforeUsingYourPersonalTaxAccount-0")).isDisplayed, "Button not displayed")
      }
  }

  Then( """^user sees radio button 'Yes' under still need to phone or write to HMRC""" ) {
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.findElement(By.id("stillReduceHMRCPhoneCalls-2")).isDisplayed, "The expected button not displayed")
    }
  }

  Then( """^user sees radio button 'No' under still need to phone or write to HMRC$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.findElement(By.cssSelector("#stillReduceHMRCPhoneCalls-1")).isDisplayed, "Button not displayed")
      }
  }

  Then( """^user sees radio button 'Don't know' under still need to phone or write to HMRC$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.findElement(By.cssSelector("#stillReduceHMRCPhoneCalls-0")).isDisplayed, "Button not displayed")
      }
  }

  Then( """^user sees radio button 'Yes' under now need to phone or write to HMRC""" ) {
    withCurrentDriver { implicit webDriver =>
      assert(webDriver.findElement(By.id("nowReduceHMRCPhoneCalls-2")).isDisplayed, "The expected button not displayed")
    }
  }

  Then( """^user sees radio button 'No' under now need to phone or write to HMRC$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.findElement(By.cssSelector("#nowReduceHMRCPhoneCalls-1")).isDisplayed, "Button not displayed")
      }
  }

  Then( """^user sees radio button 'Don't know' under now need to phone or write to HMRC$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        assert(webDriver.findElement(By.cssSelector("#nowReduceHMRCPhoneCalls-0")).isDisplayed, "Button not displayed")
      }
  }

  Then( """^user selects radio button 'Yes' under still need to phone or write to HMRC""" ) {
    withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.id("stillReduceHMRCPhoneCalls-2")).click()
    }
  }

  Then( """^user selects radio button 'No' under Before using your tax account$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        webDriver.findElement(By.cssSelector("#beforeUsingYourTaxAccount-0")).click()
      }
  }

  Then( """^The selection Yes for still need to phone section is removed$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        assert(!webDriver.findElement(By.id("nowReduceHMRCPhoneCalls-2")).isSelected, "Button selected when not expected")
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

  When( """^Friend or Family is unselected$""") {
    withCurrentDriver { implicit webDriver =>
      val elem1 = webDriver.findElement(By.id("friendOrFamily"))
      assert(!(elem1.isSelected), "Checkbox selected when Not expected")
      val elem2 = webDriver.findElement(By.id("didntNeedHelp"))
      assert(elem2.isSelected, "Checkbox not selected when expected")
    }
  }

  When( """^user is able to select multiple checkboxes$""") {
    () =>
      withCurrentDriver { implicit webDriver =>
        val elem1 =  webDriver.findElement(By.id("charity"))
        elem1.click()
        assert(elem1.isSelected, "Checkbox not selected when expected")
        val elem2 = webDriver.findElement(By.id("citizensAdvice"))
        elem2.click()
        assert(elem2.isSelected, "Checkbox not selected when expected")
      }
  }

  And( """^user enters the 10 characters: '(.*)' into the free text box""") {
    (value: String) => withCurrentDriver { implicit webDriver =>
      val field = webDriver.findElement(By.cssSelector(".char-counter>textarea"))
      field.clear()
      field.sendKeys(value)
    }
  }

  And( """^user clicks on the Send feedback button on Exit survey page$""") {
    () => withCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.xpath(".//*[@id='content']/article/div/div/form/div/button")).click()
    }
  }
}