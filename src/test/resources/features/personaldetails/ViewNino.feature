@suite
Feature: PTA:View NINO
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct NINO

  Scenario: View NINO in Personal Details Page

    Given John Densmore is logged in to PTA
    And PTA landing page is displayed
    When John Densmore clicks on Personal Details link
    Then Personal Details page is displayed
    And NINO CS700100A is visible


# JIRA story history: MTA-260