@wip
Feature: Link to tax Credits in benefits and Credits
  As a user
  I am able to use a different route if I am a Tax Credits user


  JIRA story history: MTA-1656

  Scenario: Verify user can see TCS link in Benefits and Credits section
    Given user 'Martin Hempton' is logged into the service
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected




