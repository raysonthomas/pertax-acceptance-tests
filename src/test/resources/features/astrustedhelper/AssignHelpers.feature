@wip
Feature: Trusted helper relation setup
  As a tester
  I want to set helper relation between two users
  So I can test the functionality of PTA as a trusted helper

  JIRA story history: MTA-1096

#  Scenario: Ask someone for their help
#    Given user 'John Densmore' is logged into the service
#    When user is on the page with title 'Your personal tax account'
#    Then user clicks on 'View your permissions' link
#    And user clicks on 'Ask someone for their help' link
#    And user enters details for 'Martin', 'Hempton', 'AB216913B', '25-12-1977' DD-MM-YYYY
#    And user clicks on 'submit' button
#    And user confirms that the found helper's NINO is 'AB216913B'
#    And user clicks on 'Return to my trusted helper contacts' link
#    And user navigates to personal tax account

  Scenario: Approve request for help
    Given user 'Martin Hempton' is logged into the service
    When user is on the page with title 'Your personal tax account'
    Then user clicks on 'View your permissions' link
    And user clicks on 'Respond to John's request' link
    And user submits his decision to help
    And user navigates to personal tax account




