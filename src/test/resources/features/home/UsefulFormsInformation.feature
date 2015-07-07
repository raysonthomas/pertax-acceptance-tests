@suite
Feature: Useful Information forms links
  As a user
  I want to see links to useful forms from HMRC
  
  JIRA story history: MTA-496

  Scenario: View Income Tax forms link is visible on the home page
    Given user 'Jim Ferguson' is logged into the service
    When user is on the page with title 'Your personal tax account'
    Then View Income Tax forms link is correct