@suite
Feature: View NINO
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct NINO

  Scenario: View NINO in Your personal details Page
    Given 'John Densmore' is logged in to PTA
    And 'Your account' page is displayed
    When 'John Densmore' clicks on 'Personal details' link
    Then 'Your personal details' page is displayed
    And NINO 'CS700100A' is visible



# JIRA story history: MTA-260