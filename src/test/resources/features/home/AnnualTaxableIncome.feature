@suite
Feature: Annual Taxable Income estimate information
  As a user
  I want to see my Annual Taxable Income estimate information on the home page
  So I can be sure that HMRC holds my correct taxable income details
  
  JIRA story history: MTA-491

  Scenario: Annual Taxable Income estimate is visible on the home page
    Given user 'Jim Ferguson' is logged into the service
    When user is on the Your personal tax account page
    Then The Annual Taxable Income section is displayed
    And that section contains annual taxable income estimate
    And that section contains a tax estimate
    And the 'View details' link leads to the TAI landing page
    And Tax you'll pay link leads to the TAI landing page


