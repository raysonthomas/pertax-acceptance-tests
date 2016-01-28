@suite
Feature: Trusted helper relation setup
  As a tester
  I want to set helper relation between two users
  So I can test the functionality of PTA as a trusted helper

  JIRA story history: MTA-1096, MTA-1097

  Scenario: Ask someone for their help
    Given user 'M Andrew' is logged into the service
    And user clicks on 'View your trusted helper contacts' link
    And user removes existing relations if any
    Then user clicks on 'Ask someone for their help' link
    And user searches for 'Martin', 'Hempton', 'AB216913B', '25-12-1977' DD-MM-YYYY and submits the request
    And user navigates to personal tax account home page

  Scenario: Approve request for help
    Given user 'Martin Hempton' is logged into the service
    Then user clicks on 'View your trusted helper contacts' link
    And user clicks on 'Respond to M's request' link to help someone
    And user submits his decision to help
    And user navigates to personal tax account home page




