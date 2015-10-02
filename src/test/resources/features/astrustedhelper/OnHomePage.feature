@suite
Feature: Use PTA service as a helper
  As a user
  I want to see my Annual Taxable Income estimate information on the home page
  So I can be sure that HMRC holds my correct taxable income details

  JIRA story history: MTA-1096

  Scenario: View PTA home as a trusted helper
    Given user 'Martin Hempton' is logged into the service
    And user is on the page with title 'Your personal tax account'
    And user clicks on 'View your permissions' link
    And user clicks on 'Help John' link to help someone
    When user selects PTA service to help with
    Then user is on the page with title 'Your personal tax account'
    And text 'John Densmore' is visible in the banner
    And user is able to see 'Return to your own account' link on the page
    And user clicks on link 'Return to your own account'
    And user is on the page with title 'Trusted helper contacts'
    And user navigates to personal tax account