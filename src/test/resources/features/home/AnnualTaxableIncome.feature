@suite
Feature: Annual Taxable Income estimate information
  As a user
  I want to see my Annual Taxable Income estimate information on the home page
  So I can be sure that HMRC holds my correct taxable income details
  
  JIRA story history: MTA-491, MTA-905

  Scenario: Annual Taxable Income estimate is visible on the home page
    Given user 'Jim Ferguson' is logged into the service
    When user is on the page with title 'Your personal tax account'
    Then Annual Taxable Income section is displayed
    And Annual Taxable Income section contains annual taxable income estimate
    And Annual Taxable Income section contains a tax estimate

  Scenario: Navigation from PTA to TAI service and back
    Given user 'Jim Ferguson' is logged into the service
    When user is on the page with title 'Your personal tax account'
    And user clicks on 'View details' link
    And user clicks on 'Account home' breadcrumb link
    And user clicks on 'Income Tax' link
    And user clicks on 'Account home' breadcrumb link


