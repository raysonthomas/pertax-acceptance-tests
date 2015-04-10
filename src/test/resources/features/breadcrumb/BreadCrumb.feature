@suite @smoke
Feature: Breadcrumb for Personal Tax Account
  As a PTA user
  I must be able to see navigation links to the current and all parent pages
  So that I don't get lost

  JIRA story history: MTA-292

  Scenario: See Breadcrumb while navigating through PTA
    Given 'Robert Jeffries' is logged in to PTA
    When Page is: 'Your account'
    Then Breadcrumb is: 'Home'
    And 'Robert Jeffries' clicks on 'Personal details' link
    And Page is: 'Your personal details'
    And Breadcrumb is: 'Home > Personal Details'
    And 'Robert Jeffries' clicks on 'Home' breadcrumb link
    And Page is: 'Your account'
