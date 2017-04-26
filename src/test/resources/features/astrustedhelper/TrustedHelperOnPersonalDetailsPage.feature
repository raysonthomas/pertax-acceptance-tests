@suite
Feature: Trusted helper on the personal details page
  As a trusted helper
  I want to help my helpee
  I want to see the helpee's details not mine

  JIRA story history: MTA-1097

  Scenario: View personal details as a trusted helper
    Given A user who is a trusted helper is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on View your trusted helper contacts link
    And user clicks on 'Help M' link to help someone
    And user selects PTA service to help with
    And user is on the page with title 'Personal tax account' and URL is as expected
    When user clicks on 'Update your address' link
    Then user is on the page with title 'Your address' and URL is as expected
    And text 'M Andrew' is visible in the banner
    And user is able to see 'Return to your own account' link on the page
    Then user clicks on link 'Return to your own account'
    And user navigates to personal tax account home page