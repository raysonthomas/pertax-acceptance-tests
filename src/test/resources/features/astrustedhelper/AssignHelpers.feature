@suite
Feature: Trusted helper relation setup
  As a tester
  I want to set helper relation between two users
  So I can test the functionality of PTA as a trusted helper

  JIRA story history: MTA-1096, MTA-1097, MTA-1864

  Scenario: Ask someone for their help
    Given A user who is a trusted helpee is logged into the service using verify
    And user clicks on View your trusted helper contacts link
    And user removes existing relations if any
    Then user clicks on 'Ask someone for their help' link
    And user searches for 'Martin', 'Hempton', 'AB216913B', '25-12-1977' DD-MM-YYYY and submits the request
    And user navigates to personal tax account home page

  Scenario: Approve request for help
    Given A user who is a trusted helper is logged into the service using verify
    And user clicks on View your trusted helper contacts link
    And user clicks on 'Respond to Nick's request' link to help someone
    And user submits his decision to help
    And user navigates to personal tax account home page

  Scenario: Verify content for text on End contact help page
    Given A user who is a trusted helper is logged into the service using verify
    And user clicks on View your trusted helper contacts link
    Then user clicks on 'End contact' link on Trusted Helpers page
    Then user sees text 'You will still be able to call' on the page
    Then user sees text 'for them if they are in the room with you' on the page
    And user navigates to personal tax account home page
