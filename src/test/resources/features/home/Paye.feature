@wip
Feature: PAYE
  As a PAYE user
  I need to be able to access my PAYE record
  So that I can manage my affairs

  JIRA story history: MTA-1190

  Scenario: User is enrolled in PAYE regime and should be able to see link to PAYE
    Given user 'John Densmore' is logged into the service
    When user sees 'Pay as you earn' link on the page and its href is as expected
    Then user clicks on 'Pay as you earn' link
    And user is on the page with title 'Check your Income Tax' and URL is as expected
    And user navigates to personal tax account
