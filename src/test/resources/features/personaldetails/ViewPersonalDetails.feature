@wip
Feature: View Personal Details
  As a user
  I need to view my personal details,
  So that I can verify that HMRC holds my correct name, address and nino

  JIRA story history: MTA-7, MTA-8, MTA-260, MTA-516

  Scenario: View personal details page
    Given user 'Martin Hempton' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    When user clicks on 'Update your address' link
    Then user is on the page with title 'Your address' and URL is as expected
    And Postal address '6 Howsell Road', 'Llanddew', '', '', 'DN16 3FB' should be visible

    