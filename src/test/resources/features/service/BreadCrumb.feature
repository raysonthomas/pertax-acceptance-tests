@suite @smoke
Feature: Breadcrumb for Personal Tax Account
  As a user
  I must be able to see navigation links to all parent pages
  So that I don't get lost

  JIRA story history: MTA-292, MTA-587, MTA-690

  Scenario: See Breadcrumb while navigating through PTA
    Given user 'Robert Jeffries' is logged into the service
    When user is on the page with title 'Your personal tax account'
    Then Breadcrumb is: ''
    And user clicks on 'Personal details' link
    And user is on the page with title 'Personal details'
    And Breadcrumb is: 'Account home'
    And user clicks on 'Account home' breadcrumb link
    And user is on the page with title 'Your personal tax account'
