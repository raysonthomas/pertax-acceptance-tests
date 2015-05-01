@suite
Feature: View Address
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct address

  JIRA story history: MTA-8

  Scenario: View Address in Your personal details Page
    Given 'Robert Jeffries' is logged in to PTA
    And Page is: '/pertax'
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then Page is: '/pertax/personalDetails'
    And Current Address 'Benton Park View', 'Longbenton', 'Tyne and Wear', 'North Tyneside', 'NE1 1AA' should be visible