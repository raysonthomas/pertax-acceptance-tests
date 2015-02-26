@suite
Feature: View Name
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct name

  Scenario: View Name in Your personal details Page
    Given 'Robert Jeffries' is logged in to PTA
    And 'Your account' page is displayed
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then 'Your personal details' page is displayed
    And Name 'Mrs Robert Jeffries' is visible



# JIRA story history: MTA-7