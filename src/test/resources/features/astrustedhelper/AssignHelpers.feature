@suite
Feature: Trusted helper relation setup
  As a tester
  I want to set helper relation between two users
  So I can test the functionality of PTA as a trusted helper

  JIRA story history: MTA-1096, MTA-1097

  Scenario: Ask someone for their help
    Given user 'John Densmore' is logged into the service
    And user clicks on 'View your permissions' link
    And user removes existing relations if any
    Then user clicks on 'Ask someone for their help' link
    And user searches for 'Martin', 'Hempton', 'AB216913B', '25-12-1977' DD-MM-YYYY and submits the request
    And user clicks on 'Return to my Trusted Helper contacts' link
    And user navigates to personal tax account

  Scenario: Approve request for help
    Given user 'Martin Hempton' is logged into the service
    Then user clicks on 'View your permissions' link
    And user clicks on 'Respond to John's request' link to help someone
    And user submits his decision to help
    And user navigates to personal tax account




