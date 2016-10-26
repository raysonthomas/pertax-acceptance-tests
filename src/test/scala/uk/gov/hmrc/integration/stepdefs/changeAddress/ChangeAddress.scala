package uk.gov.hmrc.integration.stepdefs.changeAddress

import cucumber.api.Scenario
import cucumber.api.java.Before
import cucumber.api.scala.{EN, ScalaDsl}
import org.jsoup.Jsoup
import org.openqa.selenium.{WebDriverException, OutputType, TakesScreenshot, By}
import org.openqa.selenium.support.ui.WebDriverWait
import uk.gov.hmrc.integration.page.GlobalActions
import uk.gov.hmrc.integration.selenium.CurrentDriver._
import uk.gov.hmrc.integration.selenium.{Snapshotter, CustomExpectedConditions}
import uk.gov.hmrc.integration.utils.Configuration

import scala.collection.JavaConversions._

class ChangeAddress extends ScalaDsl with EN {

  Then( """^user updates .*'(.*)' with '(.*)'$""") {
    (objID: String, value: String) => provisioningCurrentDriver { implicit webDriver =>
      val field = webDriver.findElement(By.id(objID))
      field.clear()
      field.sendKeys(value)
    }
  }


  // this step definition does nothing if it is not qa environment (because we cant modify address in stubs)
  Then( """^Updated Address '(.*)', '(.*)', '(.*)', '(.*)', '(.*)' should be visible$""") {
    (addressLine1: String, addressLine2: String, addressLine3: String, addressLine4: String, postCode: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        if (System.getProperty("environment", "local").toLowerCase == "qa") {
          val addressElements = Array(addressLine1, addressLine2, addressLine3, addressLine4, postCode).filter(_ != "")
          val expectedAddress = addressElements.mkString("\n")
          val actualAddress = webDriver.findElement(By.cssSelector("address")).getText
          assert(expectedAddress == actualAddress, s"\nexpected address:\n $expectedAddress \ndid not match actual address:\n $actualAddress")
        }
      }
  }

  //Then( """^error message for .*'(.*)' is '(.*)'$""") {
  Then( """^error message for date field is '(.*)' and .*'(.*)'$""") {
    (expectedError: String, mainError: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        //        val selectedSource = Jsoup.parse(webDriver.getPageSource).select( """input[name="$field"]""").head.parent()
        val selectedSource = Jsoup.parse(webDriver.getPageSource).select( """#startDate-fieldset""").head.parent()

        if (expectedError == "None") {
          assert(!selectedSource.html().contains("error-notification"), s"\nTest expected no error for date but there is an error message (check if test input is correct)")
        }

        if (expectedError != "None") {
          assert(selectedSource.text().contains(expectedError), expectedError + " was not found in " + selectedSource.text())
        }

        //        assert(webDriver.getPageSource.contains(mainError), s"\n'$mainError' not found on page when expected")


        val selectedSource1 = Jsoup.parse(webDriver.getPageSource).select( """#errors""").head.parent()

        if (mainError == "None") {
          assert(!selectedSource1.html().contains("error-heading"), "\nTest expected no error but it contained an error message (check if test input is correct)")
        }

        if (mainError != "None") {
          assert(selectedSource1.text().contains(mainError), "Error" + expectedError + " was not found in " + selectedSource1.text())
        }

      }
  }


  And( """^address '(.*)','(.*)','(.*)' is displayed$""") {
    (Line1: String, Line2: String, Postcode: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        assert(webDriver.findElement(By.id("line1")).getAttribute("value") == Line1, s"\nexpected text:\n $Line1 did not match actual address line")
        assert(webDriver.findElement(By.id("line2")).getAttribute("value") == Line2, s"\nexpected text:\n $Line2 did not match actual address line")
        assert(webDriver.findElement(By.id("postcode")).getAttribute("value") == Postcode, s"\nexpected text:\n $Postcode did not match actual address line")

      }

  }

  Then( """user selects the option No$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.id("residencyChoice-sole")).click()

    }
  }

  Then( """user selects the option Yes$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.id("residencyChoice-primary")).click()

    }
  }

  Then( """user selects the option Yes for Tax Credits$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.id("value-true")).click()

    }
  }

  Then( """user selects the option No for Tax Credits$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.id("value-false")).click()

    }
  }


  Then( """user continues from Your address page$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector(".form-group.inline>button")).click()
      //      (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("/your-address/primary/find-address")))

    }
  }

  Then( """^user waits for primary find address page$""") {
    () =>
      provisioningCurrentDriver { implicit webDriver =>
        (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("/your-address/primary/find-address")))
      }
  }

  Then( """^user waits for find address page$""") {
    () =>
      provisioningCurrentDriver { implicit webDriver =>
        (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("/your-address/sole/find-address")))
      }
  }


  Then( """user continues from Tax Credits page$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector(".form-group.inline>button")).click()
    }
  }

  Then( """user waits for residency choice$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("/your-address/residency-choice")))

    }
  }
  Then( """user continues from Select your address page$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.id("submitAddressSelector")).click()

    }
  }

  Then( """user continues from Edit the address page$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.id("updateAddress")).click()

    }
  }

  Then( """user continues from Enter start date page$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector(".button")).click()

    }
  }

  Then( """user clicks on Confirm and save button on Check your answers page$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      webDriver.findElement(By.cssSelector(".column-whole>form>button")).click()
    }
  }

  Then( """^user selects the address '(.*)' and continues$""") {
    (address: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        if (webDriver.getPageSource.contains(address))
          webDriver.findElement(By.xpath(".//*[@type='radio' and @id='radio-1' and @value='GB990091234582']")).click()
        //        (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.buttonVisible(".//*[@id='submitAddressSelector']")))
        webDriver.findElement(By.xpath(".//*[@id='submitAddressSelector']")).click()
        (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("/your-address/sole/enter-start-date")))
      }
  }

  Then( """^user selects the address '(.*)'$""") {
    (address: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        if (webDriver.getPageSource.contains(address))
          webDriver.findElement(By.xpath(".//*[@type='radio' and @value='GB990091234582']")).click()

      }
  }

  Then( """^user selects new address '(.*)' and continues$""") {
    (address: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        if (webDriver.getPageSource.contains(address))
          webDriver.findElement(By.xpath(".//*[@type='radio' and @value='GB990091234579']")).click()
        //          (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.buttonVisible(".//*[@id='submitAddressSelector']")))
        webDriver.findElement(By.xpath(".//*[@id='submitAddressSelector']")).click()
      }
  }
  Then( """^user waits to enter start date$""") {
    () =>
      provisioningCurrentDriver { implicit webDriver =>
        (new WebDriverWait(webDriver, Configuration("defaultWait").toInt).until(CustomExpectedConditions.urlEndsWith("/your-address/primary/enter-start-date")))
      }
  }


  Then( """^user is on the page with title '(.*)' whose URL is as expected$""") {
    (expectedPageTitle: String) => provisioningCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      val currentUrl = webDriver.getCurrentUrl
      val urlTail: String = "/personal-account/your-address/postal/thank-you"
      assert(currentUrl.endsWith(urlTail), s"\n current page URL was:\n $currentUrl \nit did not end with:\n $urlTail")
      assert(actualPageTitle == expectedPageTitle, s"Page title '$actualPageTitle' is not equal to '$expectedPageTitle'")
    }
  }


  Then( """^user is on the page with title '(.*)' and whose URL is as expected$""") {
    (expectedPageTitle: String) => provisioningCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      val currentUrl = webDriver.getCurrentUrl
      val urlTail: String = "/personal-account/your-address/sole/thank-you"
      assert(currentUrl.endsWith(urlTail), s"\n current page URL was:\n $currentUrl \nit did not end with:\n $urlTail")
      assert(actualPageTitle == expectedPageTitle, s"Page title '$actualPageTitle' is not equal to '$expectedPageTitle'")
    }
  }


  Then( """^the error message for .*'(.*)' is '(.*)'$""") {
    (field: String, expectedError: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        val selectedSource = Jsoup.parse(webDriver.getPageSource).select( s"""input[name="$field"]""").head.parent()

        if (expectedError == "None") {
          assert(!selectedSource.html().contains("error-notification"),
            s"\nTest expected no error for '$field'\nbut it contained an error message (check if test input is correct)")
        }

        if (expectedError != "None") {
          assert(selectedSource.text().contains(expectedError),
            expectedError + " was not in " + selectedSource.text())
        }

      }
  }

  Then( """^Home address '(.*)', '(.*)', '(.*)', '(.*)', '(.*)' should be visible$""") {
    (addressLine1: String, addressLine2: String, addressLine3: String, addressLine4: String, postCode: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        val addressElements = Array(addressLine1, addressLine2, addressLine3, addressLine4, postCode).filter(_ != "")
        val expectedAddress = addressElements.mkString("\n")
        val actualAddress = webDriver.findElement(By.cssSelector("address")).getText
        assert(expectedAddress == actualAddress, s"$expectedAddress did not match $actualAddress")
      }
  }

  Then( """^Postal address '(.*)', '(.*)', '(.*)', '(.*)', '(.*)' should be visible$""") {
    (addressLine1: String, addressLine2: String, addressLine3: String, addressLine4: String, postCode: String) =>
      provisioningCurrentDriver { implicit webDriver =>
        val addressElements = Array(addressLine1, addressLine2, addressLine3, addressLine4, postCode).filter(_ != "")
        val expectedAddress = addressElements.mkString("\n")
        val actualAddress = webDriver.findElement(By.cssSelector(".panel-indent>address")).getText
        assert(expectedAddress == actualAddress, s"$expectedAddress did not match $actualAddress")
      }
  }

  Then( """^user is on the page with expected URL$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      val currentUrl = webDriver.getCurrentUrl
      assert(currentUrl.endsWith("/tax-credits-service/personal/change-address"), "\n current page URL did not end as expected}")

    }
  }

  And( """^user does not see a manual entry link matching: '(.*)'$""") {
    (linkName: String) => provisioningCurrentDriver { implicit webDriver =>
      assert(!webDriver.getPageSource.contains(linkName), s"$linkName is present on the page when not expected")
    }
  }

  And( """^user sees a manual entry link matching: '(.*)'$""") {
    (linkName: String) => provisioningCurrentDriver { implicit webDriver =>
      assert(webDriver.getPageSource.contains(linkName), s"$linkName is not present on the page when expected")
    }
  }

  Then( """^user is on the page with title '(.*)' with correct URL for postal address update$""") {
    (expectedPageTitle: String) => provisioningCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      val currentUrl = webDriver.getCurrentUrl
      assert(currentUrl.endsWith("/your-address/postal/edit-address"), "current URL does not end with /your-address/postal/edit-address")
      assert(actualPageTitle == expectedPageTitle, s"Page title '$actualPageTitle' is not equal to '$expectedPageTitle'")
    }
  }

  Then( """^user is on the page with title '(.*)' and URL is as expected for the postal address change$""") {
    (expectedPageTitle: String) => provisioningCurrentDriver { implicit webDriver =>
      val actualPageTitle = webDriver.getTitle
      val currentUrl = webDriver.getCurrentUrl
      assert(currentUrl.endsWith("/personal-account/your-address/postal/thank-you"), "current URL does not end with /personal-account/your-address/sole/thank-you")
      assert(actualPageTitle == expectedPageTitle, s"Page title '$actualPageTitle' is not equal to '$expectedPageTitle'")
    }
  }



  import ScenarioStore._
  @Before
  def storeScenario(s: Scenario) {
    scenario = s
  }


  Then( """^user clicks on Change where we send your letters link on your address page$""") {
    () => provisioningCurrentDriver { implicit webDriver =>
      val ele = webDriver.findElement(By.cssSelector("[class=\"button grey margin-top\"][href=\"/personal-account/your-address/postal/find-address\"]"))

      println(ele.getTagName)
      println(ele.getAttribute("href"))
      println(ele.getText)
      println(assert(ele.isEnabled, "Not enabled"))

      ifCurrentDriverTakesSnapshot { takesSnapShot =>
        Snapshotter.takeSnapshot(takesSnapShot, scenario)
      }


      ele.click()

      try {
        (new WebDriverWait(webDriver, Configuration("defaultWait").toInt)).until(CustomExpectedConditions.urlEndsWith("/your-address/postal/find-address"))
      }
      catch {
        case e: Exception =>
          ifCurrentDriverTakesSnapshot { takesSnapShot =>
            Snapshotter.takeSnapshot(takesSnapShot, scenario)
          }
          println(webDriver.getCurrentUrl)
          throw new RuntimeException(e)
      }
    }
  }
}

object ScenarioStore {
  var scenario: Scenario = null
}