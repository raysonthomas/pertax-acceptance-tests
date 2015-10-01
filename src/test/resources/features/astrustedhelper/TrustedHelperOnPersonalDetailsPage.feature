@wip
Feature: Trusted helper on the personal details page
  As a trusted helper
  I want to help my helpee
  I want to see the helpee's details not mine
  JIRA story history: MTA-1097



  Scenario: Login to PTA and as a Trusted Helper, help a helpee
    Given user 'Martin Hempton' is logged into the service
    When user is on the page with title 'Your personal tax account'
    And user clicks on 'View your permissions' link
    And user clicks on 'Help John' link to help someone
    And user chooses Personal Tax Account option
    Then user navigates to personal tax account
    When user clicks on 'Personal details' link
    Then user is on the page with title 'Personal details'
    And Name 'John Densmore' is visible
    And Current Address 'Matheson House', 'Matheson House', 'Matheson House', 'Matheson House', 'TF3 4ER' should be visible
    And NINO 'CS 70 01 00 A' is visible
    And user is able to see 'Return to your own account' link on the page
    Then user clicks on link 'Return to your own account'
    And user is on the page with title 'Trusted helper contacts'
    And user navigates to personal tax account




