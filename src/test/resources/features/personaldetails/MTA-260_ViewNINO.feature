@suite
Feature: MTA-260_View NINO
  As a HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds the correct NINO.

  Scenario: View NINO in Personal Details Page
    Given Ryan Little has logged in to his account
    When Ryan Little navigates to Personal Details Page
    Then Personal Details page should be displayed
    And "CS700100A" should be displayed