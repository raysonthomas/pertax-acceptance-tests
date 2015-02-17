@suite
Feature: View Address
  As an HMRC Customer
  I need to view my personal details,
  So that I can verify that HMRC holds my correct address

  Scenario: View Address in Your personal details Page
    Given 'John Densmore' is logged in to PTA
    And 'Your account' page is displayed
    When 'John Densmore' clicks on 'Personal details' link
    Then 'Your personal details' page is displayed
    And Current Address 'Benton Park View', 'Longbenton', 'Tyne and Wear', 'North Tyneside', 'NE1 1AA' should be visible



# JIRA story history: MTA-8