@wip
Feature: Full Name is displayed on the Home Page
  As a user
  I want to see my full name on the home page
  So I can be sure that I have logged in with the right account

  JIRA story history: none yet

  Scenario: View my full name on the home pagel
    Given 'Jim Ferguson' is logged in to PTA
    And Page address path is: '/pertax'
    Then Full Name Heading is: 'Jim Ferguson'