@wip
Feature: Trusted helper on the personal details page
  As a trusted helper
  I want to help my helpee
  I want to see the helpee's details not mine

  JIRA story history: MTA-1097

  Scenario: View personal details as a trusted helper
    Given user 'Martin Hempton' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'View your permissions' link
    And user clicks on 'Help John' link to help someone
    And user selects PTA service to help with
    And user is on the page with title 'Your personal tax account' and URL is as expected
    When user clicks on 'Personal details' link
    Then user is on the page with title 'Personal details' and URL is as expected
    And text 'John Densmore' is visible in the banner
    And user is able to see 'Return to your own account' link on the page
    Then user clicks on link 'Return to your own account'
<<<<<<< HEAD
    And user is on the page with title 'Trusted Helper contacts' and URL is as expected
    And user navigates to personal tax account
=======
    And user is on the page with title 'Trusted helper contacts' and URL is as expected
    And user navigates to personal tax account
>>>>>>> 2591283cd1057e173ccf2e71450c581645ce0066
