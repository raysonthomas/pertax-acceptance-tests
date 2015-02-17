@suite
Feature: View Name
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct name

  Scenario: View Name in Your personal details Page
    Given 'John Densmore' is logged in to PTA
    And 'Your account' page is displayed
    When 'John Densmore' clicks on 'Personal details' link
    Then 'Your personal details' page is displayed
    And Name 'Mr John Densmore' is visible



# JIRA story history: MTA-7