@wip
Feature: Full Name is displayed on the Home Page
  As a user
  I want to see my full name on the home page
  So I can be sure it's my stuff I'm seeing

  JIRA story history: MTA-492

  Scenario: View my full name on the home pagel
    Given 'Jim Ferguson' is logged in to PTA
    And Page address path is: '/pertax'
    Then Full Name Heading is: 'Jim Ferguson'
