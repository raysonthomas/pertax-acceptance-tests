@suite
Feature: View Date Moved
  As an HMRC Customer
  I need to view my current Address's Valid From date,
  So I can verify HMRC holds the correct details

  JIRA story history: MTA-272

  Scenario: Date moved is displayed on Your personal details page
    Given 'Robert Jeffries' is logged in to PTA
    And Page is: '/pertax'
    When 'Robert Jeffries' clicks on 'Personal details' link
    Then Page is: '/pertax/personalDetails'
    And '23 April 2013' is displayed as the Date moved to this address

  Scenario: Date moved is not displayed on Your personal details page if there is no value for it
    Given 'Timothy Bull' is logged in to PTA
    And Page is: '/pertax'
    When 'Timothy Bull' clicks on 'Personal details' link
    Then Page is: '/pertax/personalDetails'
    And 'Date moved to this address' label is not displayed
