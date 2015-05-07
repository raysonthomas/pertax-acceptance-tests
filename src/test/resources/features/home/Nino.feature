@wip
Feature: National Insurance Number (NINO) is displayed on the Home Page
  As a user
  I want to see my NINO on the home page
  So I can be reassured it's my stuff I'm seeing

  JIRA story history: MTA-493

  Scenario: View my NINO on the home page
    Given 'Jim Ferguson' is logged in to PTA
    And Page address path is: '/pertax'
    Then NINO Subheading is: 'National Insurance number: AA000003D'
