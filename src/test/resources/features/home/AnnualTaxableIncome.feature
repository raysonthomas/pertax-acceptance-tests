@suite
Feature: Annual Taxable Income estimate information
  As a user
  I want to see my Annual Taxable Income estimate information on the home page
  So I can be sure that HMRC holds my correct taxable income details
  
  JIRA story history: MTA-491, MTA-905

  Scenario: Annual Taxable Income estimate is visible on the home page
    Given user 'Jim Ferguson' is logged into the service
    When user is on the page with title 'Your personal tax account'
    Then 'Your Income Tax' section is displayed
    And 'Your Income Tax' section contains a tax estimate


