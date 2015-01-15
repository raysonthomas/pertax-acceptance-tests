#@suite
Feature: MTA-8_View Address
  As a HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds the correct address.

  Scenario: View Address in Personal Details Page
    Given Ryan Little has logged in to his account
    When Ryan Little navigates to Personal Details Page
    Then Personal Details page should be displayed
    And 'Address' should be displayed