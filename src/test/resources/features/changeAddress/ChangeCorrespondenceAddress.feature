@suite
Feature: Verify my correspondence address
  As a HMRC Customer
  I need to be able view and change my correspondence address.

  JIRA story history: MTA-1691, MTA-2390, MTA-2372

  Scenario: User with correspondence address is able to view their correspondence address. User able to change their correspondence address
    Given A user with a Correspondence Address is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on visible 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    And Postal address '11 Test Street', 'Testtown', '', '', 'FX97 4TU' should be visible
    Then user sees text 'Get letters sent to a different address' on the page
    And user sees 'Change where we send your letters' link on the page and its href is as expected
    Then user clicks on Change where we send your letters link on your address page
    Then user is on the page with title 'Find an address' and URL is as expected
    And Breadcrumb is: 'Account home>Your address'
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    Then user waits for select address page
    And user selects new address '8 Test Street, Testtown, FX97 4TU' and continues
    Then user continues from Edit the address page
    Then user waits for 'Your address has been updated' page
    And user is on the page with title 'Your address has been updated' with correct URL for postal address update
    And user clicks on 'Return to your account home' link
    And user is on the page with title 'Personal tax account' and URL is as expected

#  Scenario: PAY_AS_YOU_EARN_STUB is Restarted
#    Given The service 'PAY_AS_YOU_EARN_STUB' is restarted

  Scenario: Manual Correspondence Address update
    Given A user changing Correspondence Address manually is logged into the service using verify
    And user clicks on visible 'Update your address' link
    And user sees 'Change where we send your letters' link on the page and its href is as expected
    Then user clicks on Change where we send your letters link on your address page
    And user updates 'filter' with '100000001'
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    Then user waits for 'Find an address' page
    Then user sees text 'Enter your address yourself' on the page
    And user sees a manual entry link matching: 'Enter your address yourself'
    And user clicks on 'Enter your address yourself' link
    Then user waits for the Enter your address page
    And user is on the page with title 'Enter the address' and with text Enter the address
    Then user is able to see a section 'Enter the address'