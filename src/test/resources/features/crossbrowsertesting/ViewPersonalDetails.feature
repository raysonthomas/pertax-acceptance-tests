@wip @crossbrowser
Feature: View Name
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct personal details

  Scenario: View Your personal details Page
    Given 'Robert Jeffries' is logged in to PTA
    And 'Your account' page is displayed
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then 'Your personal details' page is displayed
    And Name 'Mrs Robert Jeffries' is visible
    And NINO 'ZN522915C' is visible
    And 'rjeffries@example.com' is displayed as email address
    And '23 April 2013' is displayed as the Date moved to this address
    And Current Address 'Benton Park View', 'Longbenton', 'Tyne and Wear', 'North Tyneside', 'NE1 1AA' should be visible
    And 'Update your address' link should be visible
    And Income Tax Estimate is displayed as '£1361.40'
    And Link to PAYE service is displayed as 'View your Income Tax estimate'

  Scenario: Not View all Your personal details Page
    Given 'Timothy Bull' is logged in to PTA
    And 'Your account' page is displayed
    When 'Timothy Bull' clicks on 'Personal details' link
    Then 'Your personal details' page is displayed
    And 'Your email' label is not displayed
