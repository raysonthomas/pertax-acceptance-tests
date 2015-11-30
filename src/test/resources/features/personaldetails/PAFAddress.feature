@wip
Feature: Update Personal Details
  As a user
  I need to be able to change my address
  So that HMRC holds the correct info about me

  JIRA story history: MTA-1349,MTA_1420

  Scenario: Positive update address entering postcode
    Given user 'Martin Hempton' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user clicks on 'Update your postal address' link
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    And user selects the address '11 Test Street, Testtown, FX97 4TU' and continues
    Then user clicks on 'updateAddress' button
    And user is on the page with title 'Your address has been updated' and URL is as expected
    And user clicks on 'Return to your personal details' link
    And user is on the page with title 'Your address' and URL is as expected

  Scenario: Positive update address entering postcode without space
    Given user 'Martin Hempton' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user clicks on 'Update your postal address' link
    And user updates 'postcode' with 'FX974TU'
    Then user clicks on 'submitAddressFinder' button
    And user selects the address '11 Test Street, Testtown, FX97 4TU' and continues
    Then user clicks on 'updateAddress' button
    And user is on the page with title 'Your address has been updated' and URL is as expected
    And user clicks on 'Return to your personal details' link
    And user is on the page with title 'Your address' and URL is as expected

  Scenario: Positive update address entering postcode and address line
    Given user 'Martin Hempton' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user clicks on 'Update your postal address' link
    And user updates 'filter' with '11'
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    And address '11 Test Street','Testtown','FX97 4TU' is displayed
    Then user clicks on 'updateAddress' button
    And user is on the page with title 'Your address has been updated' and URL is as expected
    And user clicks on 'Return to your personal details' link
    And user is on the page with title 'Your address' and URL is as expected

  Scenario: Negative - User does not have their Postcode in the database
    Given user 'Martin Hempton' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user clicks on 'Update your postal address' link
    And user updates 'postcode' with 'NE7 7HN'
    Then user clicks on 'submitAddressFinder' button
    And error message for 'postcode' is 'Your address cannot be found. You can try again or enter your address yourself.'

  Scenario: Negative - User finds their Postcode but not their address
    Given user 'Martin Hempton' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user clicks on 'Update your postal address' link
    And user updates 'filter' with '100'
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    And error message for 'postcode' is 'Your address cannot be found. You can try again or enter your address yourself.'

  Scenario: User uses an Invalid Postcode
    Given user 'Martin Hempton' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user clicks on 'Update your postal address' link
    And user updates 'postcode' with 'ZZZ ZZZ'
    Then user clicks on 'submitAddressFinder' button
    And error message for 'postcode' is 'Enter a valid UK postcode'







