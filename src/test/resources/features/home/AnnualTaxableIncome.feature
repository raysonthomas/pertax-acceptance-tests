@suite
Feature: Annual Taxable Income estimate information
  As a user
  I want to see my Annual Taxable Income estimate information on the home page
  So I can be sure that HMRC holds my correct taxable income details
  
  JIRA story history: MTA-491

  Scenario: Annual Taxable Income estimate is visible on the home page
    Given user 'Jim Ferguson' is logged into the service
    When user is on the home page
    Then The Annual Taxable Income section is displayed
    And that section contains annual taxable income estimate
    And that section contains a tax estimate
    And the 'View details' link leads to the TAI tax estimate page
    And Tax you'll pay link leads to the TAI tax you'll pay page


