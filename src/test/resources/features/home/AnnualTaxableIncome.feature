@suite
Feature: Annual Taxable Income estimate information
  As a user
  I want to see my Annual Taxable Income estimate information on the home page
  So I can be sure that HMRC holds my correct taxable income details
  
  JIRA story history: MTA-491

  Scenario: Annual Taxable Income estimate is visible on the home page
    Given user 'Jim Ferguson' is logged into the service
    When user is on the home page
    Then Annual Taxable Income section is visible
    And Annual Taxable Income is displayed as '£17,467'

