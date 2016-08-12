@suite
Feature: MCI User
  As a user
  I want to see Technical Difficulties page as expected

  JIRA story history: MTA-2125, MTA-2211

  Scenario: Check that the home page has proper segmentation
    Given A user with MCI Indicator set as true is logged into the service using verify
    Then user is on the page with title 'There's a problem logging you in' and URL is as expected
    And MCI user sees text 'There's a problem logging you in' on the page
    And MCI user sees text 'We need to speak to you before you can log in to your account.' on the page
    And MCI user sees text 'How to fix this' on the page
    And MCI user sees text 'Phone 0300 200 3300' on the page
    And MCI user sees text 'Tell the adviser this is an 'MCI issue'' on the page
    And MCI user sees text 'Other ways to contact us' on the page
    And MCI user sees text 'Outside UK: +44 135 535 9022' on the page
    And MCI user sees text 'Phone lines are open 8am to 8pm Monday to Friday and 8am to 4pm on Saturday.' on the page
    And MCI user sees text 'Phone lines are less busy before 10am Monday to Friday.' on the page
    And user sees 'Find out about call charges (opens in a new window)' link on the page and its href is as expected






