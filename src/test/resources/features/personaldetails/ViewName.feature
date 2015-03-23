@suite
Feature: View Name
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct name

  JIRA story history: MTA-7

  Scenario: View Name in Your personal details Page
    Given 'Robert Jeffries' is logged in to PTA
    And Page is: 'Your account'
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then Page is: 'Your personal details'
    And Name 'Mrs Robert Jeffries' is visible