@suite
Feature: MCI User
  As a user
  I want to see Technical Difficulties page as expected

  JIRA story history: MTA-2125

  Scenario: Check that the home page has proper segmentation
    Given A user with MCI Indicator set as true is logged into the service using verify
    Then user is on the page with title 'Personal tax account' and URL is as expected
    And MCI user sees text 'There is a problem accessing your account' on the page
    And MCI user sees text 'We need to speak to you before you can access your personal tax account.' on the page
    And MCI user sees text 'How to contact us' on the page
    And MCI user sees text 'Phone lines are less busy before 10am Monday to Friday.' on the page
    And user sees 'Find out about call charges (opens in a new window)' link on the page and its href is as expected






