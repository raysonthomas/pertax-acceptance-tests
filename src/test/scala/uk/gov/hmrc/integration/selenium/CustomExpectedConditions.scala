package uk.gov.hmrc.integration.selenium

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}

object CustomExpectedConditions {

  def urlEndsWith(suffix: String)(implicit webDriver: WebDriver): ExpectedCondition[Boolean] = {
    new ExpectedCondition[Boolean] {
      override def apply(wd: WebDriver): Boolean = {
        val u = wd.getCurrentUrl
        u.endsWith(suffix)
      }
    }
  }

  def titleIs(title: String)(implicit webDriver: WebDriver): ExpectedCondition[Boolean] = {
    new ExpectedCondition[Boolean] {
      override def apply(wd: WebDriver): Boolean = {
        wd.getTitle.equalsIgnoreCase(title)
      }
    }
  }

  def pageContains(suffix: String)(implicit webDriver: WebDriver): ExpectedCondition[Boolean] = {
    new ExpectedCondition[Boolean] {
      override def apply(wd: WebDriver): Boolean = {
        wd.getPageSource.contains(suffix)
      }
    }
  }

  def buttonVisible(selector: String)(implicit webDriver: WebDriver): ExpectedCondition[Boolean] = {
    new ExpectedCondition[Boolean] {
      override def apply(wd: WebDriver): Boolean = {
        wd.findElement(By.xpath(selector)).isDisplayed
        wd.findElement(By.xpath(selector)).isEnabled
      }
    }
  }

  def linkVisible(selector: String)(implicit webDriver: WebDriver): ExpectedCondition[Boolean] = {
    new ExpectedCondition[Boolean] {
      override def apply(wd: WebDriver): Boolean = {
        wd.findElement(By.partialLinkText(selector)).isDisplayed
        wd.findElement(By.partialLinkText(selector)).isEnabled
      }
    }
  }

}
