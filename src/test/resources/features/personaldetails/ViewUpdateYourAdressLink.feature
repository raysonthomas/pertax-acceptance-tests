@suite
Feature: View Update your address link
  As an HMRC Customer who has recently changed address
  I need to inform HMRC about this
  So that my details in the records are up-to-date

  Scenario: Update your address link is visible in Your personal details Page
    Given 'Robert Jeffries' is logged in to PTA
    And 'Your account' page is displayed
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then 'Your personal details' page is displayed
    And Current Address 'Benton Park View', 'Longbenton', 'Tyne and Wear', 'North Tyneside', 'NE1 1AA' should be visible
    And 'Update your address (Opens in new window)' link should be visible


  
   # JIRA story history: MTA-120