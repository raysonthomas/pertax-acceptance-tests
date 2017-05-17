@suite
Feature: Use PTA service as a helper
  As a user
  I want to see my Annual Taxable Income estimate information on the home page
  So I can be sure that HMRC holds my correct taxable income details

  JIRA story history: MTA-1096

  Scenario: View PTA home as a trusted helper
    Given A user who is a trusted helper is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on View your trusted helper contacts link
    And user clicks on 'Help Nick' link to help someone
    When user selects PTA service to help with
    Then user is on the page with title 'Personal tax account' and URL is as expected
    And text 'Nick Pace' is visible in the banner
    And user is able to see 'Return to your own account' link on the page
    And user clicks on link 'Return to your own account'
    And user ends contact
    Then user signs out
    Then user sees text 'Give feedback' on the page
