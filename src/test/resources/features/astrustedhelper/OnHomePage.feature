@suite
Feature: Use PTA service as a helper
  As a user
  I want to see my Annual Taxable Income estimate information on the home page
  So I can be sure that HMRC holds my correct taxable income details

  JIRA story history: MTA-1096

  Scenario: Approve request for help
    Given user 'Martin Hempton' is logged into the service
    Then user clicks on 'View your permissions' link
    And user clicks on 'Help John' link to help someone
    And user selects PTA
    And