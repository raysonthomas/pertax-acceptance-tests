#@suite
Feature: MTA-7_View Name
  As a HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds the correct name.

  Scenario: View Name in Personal Details Page
    Given Ryan Little has logged in to his account
    When Ryan Little navigates to Personal Details Page
    Then Personal Details page should be displayed
    And "Mr Ryan Little" should be displayed

    

