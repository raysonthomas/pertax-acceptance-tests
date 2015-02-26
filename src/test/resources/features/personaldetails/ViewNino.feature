@suite
Feature: View NINO
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct NINO

  Scenario: View NINO in Your personal details Page
    Given 'Robert Jeffries' is logged in to PTA
    And 'Your account' page is displayed
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then 'Your personal details' page is displayed
    And NINO 'ZN522915C' is visible



# JIRA story history: MTA-260