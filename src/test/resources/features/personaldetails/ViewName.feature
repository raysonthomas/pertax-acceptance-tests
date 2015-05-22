@suite
Feature: View Name
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct name

  JIRA story history: MTA-7

  Scenario: View Name in Your personal details Page
    Given user 'Robert Jeffries' is logged into the service
    And user is on the home page
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then user is on the personal details page
    And Name 'Mrs Robert Jeffries' is visible