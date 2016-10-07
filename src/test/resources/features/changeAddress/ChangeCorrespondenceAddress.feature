@suite
Feature: Verify my correspondence address
  As a HMRC Customer
  I need to be able view and change my correspondence address.

  JIRA story history: MTA-1691


  Scenario: User with correspondence address is able to view their correspondence address
    Given A user with a Correspondence Address is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    And Postal address '11 Test Street', 'Testtown', '', '', 'FX97 4TU' should be visible
    Then user sees text 'Get letters sent to a different address' on the page
    And user sees 'Change where we send your letters' link on the page and its href is as expected

  Scenario: User able to change their correspondence address
    Given A user with a Correspondence Address is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user clicks on 'Change where we send your letters' link
    Then user is on the page with title 'Find an address' and URL is as expected
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    And user selects new address '8 Test Street, Testtown, FX97 4TU' and continues
    Then user continues from Edit the address page
    And user is on the page with title 'Your address has been updated' with correct URL for postal address update
    And user clicks on 'Return to your account home' link
    And user is on the page with title 'Personal tax account' and URL is as expected

