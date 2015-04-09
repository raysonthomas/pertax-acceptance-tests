@suite
Feature: View Income Tax Estimate Summary
  As an HMRC Customer
  I must be able to view Income Tax Estimate Summary on PTA landing page
  So I can be sure HMRC holds all my correct PAYE details

  JIRA story history: MTA-269

  Scenario: Income Tax Estimate Summary is displayed on Your account page
    Given 'Jim Ferguson' is logged in to PTA
    And Page is: 'Your account'
    Then Content visible: 'Your Income Tax estimate for 2015 to 2016'

  Scenario: Income Tax Estimate value is displayed on Income Tax Estimate Summary
    Given 'Jim Ferguson' is logged in to PTA
    And Page is: 'Your account'
    Then Income Tax Estimate is displayed as '£1361.40'

  Scenario: Link to PAYE service is displayed on Income Tax Estimate Summary
    Given 'Jim Ferguson' is logged in to PTA
    And Page is: 'Your account'
    Then Link to PAYE service is displayed as 'View your Income Tax estimate'
