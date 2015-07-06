@suite @smoke
Feature: Breadcrumb for Personal Tax Account
  As a PTA user
  I must be able to see navigation links to all parent pages
  So that I don't get lost

  JIRA story history: MTA-292, MTA-587, MTA-690

  Scenario: See Breadcrumb while navigating through PTA
    Given user 'Robert Jeffries' is logged into the service
    When user is on the home page
    Then Breadcrumb is: ''
    And 'Robert Jeffries' clicks on 'Personal details' link
    And user is on the personal details page
    And Breadcrumb is: 'Account home > Your personal details'
    And 'Robert Jeffries' clicks on 'Account home' breadcrumb link
    And user is on the home page
