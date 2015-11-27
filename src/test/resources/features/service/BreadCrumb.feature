@suite @smoke
Feature: Breadcrumb for Personal Tax Account
  As a user
  I must be able to see navigation links to all parent pages
  So that I don't get lost

  JIRA story history: MTA-292, MTA-587, MTA-690

  FIXME - these breadcrumb tests should be refactored into the other
    scenarios to negate the need for navigating through the application again

  Scenario: See Breadcrumb while navigating through PTA
    Given user 'Martin Hempton' is logged into the service
    When user is on the page with title 'Your personal tax account' and URL is as expected
    Then Breadcrumb is: ''
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    And Breadcrumb is: 'Account home'
    And user clicks on 'Account home' breadcrumb link
    And user is on the page with title 'Your personal tax account' and URL is as expected
