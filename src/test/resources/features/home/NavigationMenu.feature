@wip
Feature: Navigation menu is visible on the home page
  As a user
  I need to be able to navigate to other services within the account
  So that I can use them


  JIRA story history: MTA-494

  Scenario: Right hand Nav is visible on the home page
    Given 'Jim Ferguson' is logged in to PTA
    And Page address path is: '/home'
    Then right hand navigation menu header is : 'Your account'
    And right hand navigation hyperlink that leads to personal details is: 'Personal details'
    And right hand navigation hyperlink that leads to personal details is: '/profile'
