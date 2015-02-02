@suite
Feature: PTA:View Income Tax Estimate Summary
  As an HMRC Customer
  I must be able to view Income Tax Estimate Summary on PTA landing page
  So I can be sure HMRC holds all my correct PAYE details

  Scenario: Income Tax Estimate Summary is displayed on PTA Landing page
    Given Robert Jeffries is logged in to PTA
    And PTA landing page is displayed
    Then Income Tax Estimate Summary is displayed on PTA Landing page

  Scenario: Income Tax Estimate value is displayed on Income Tax Estimate Summary
    Given Robert Jeffries is logged in to PTA
    And PTA landing page is displayed
    Then Income Tax Estimate is displayed as £1361.40

  Scenario: Link to PAYE service is displayed on Income Tax Estimate Summary
    Given Robert Jeffries is logged in to PTA
    And PTA landing page is displayed
    Then Link to PAYE service is displayed as View your Income Tax estimate



# JIRA story history: MTA-269
