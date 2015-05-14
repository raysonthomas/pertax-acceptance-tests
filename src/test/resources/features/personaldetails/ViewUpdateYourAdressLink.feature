@suite
Feature: View Update your address link
  As an HMRC Customer who has recently changed address
  I need to inform HMRC about this
  So that my details in the records are up-to-date

  JIRA story history: MTA-120

  Scenario: Update your address link is visible in Your personal details Page
    Given user 'Robert Jeffries' is logged into the service
    And Page is: '/pertax'
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then Page is: '/pertax/personalDetails'
    And Current Address 'Benton Park View', 'Longbenton', 'Tyne and Wear', 'North Tyneside', 'NE1 1AA' should be visible
    And 'Update your address' link should be visible