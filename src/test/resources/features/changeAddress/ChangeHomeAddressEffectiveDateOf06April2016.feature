@suite
Feature: Verify my home address
  As a HMRC Customer who’s got more than one home,
  Having effective from date of 06 April 2016,
  I need to tell HMRC what my home is, and be able to change my home address.

  JIRA story history: MTA-1691

  Scenario: User has an effective from date of 6th April 2016 and able to view correct details
    Given A user with Effective From date 06 April 2016 is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user is able to see a section '6 April 2016'
    And user is able to see 'Change your address' link on the page

  Scenario: User changes home address
    Given A user with Effective From date 06 April 2016 is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user is able to see a section '6 April 2016'
    And user clicks on 'Change your address' link
    Then user sees text 'Do you get tax credits?' on the page
    Then user selects the option No for Tax Credits
    Then user continues from Tax Credits page
    Then user sees text 'Do you live in more than one place?' on the page
    Then user selects the option Yes
    Then user continues from Your address page
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    And user selects new address '8 Test Street, Testtown, FX97 4TU' and continues
    Then user sees text 'When did this become your main home?' on the page
    And user updates date field 'startDate.day' with '07'
    And user updates date field 'startDate.month' with '04'
    And user updates date field 'startDate.year' with '2016'
    Then user continues from Enter start date page
    Then user sees text 'Check your details' on the page
    Then user sees text '8 Test Street' on the page
    Then user sees text '7 April 2016' on the page
    Then user clicks on Confirm and save button on Check your answers page
    And user is on the page with title 'Your address has been updated' and URL is as expected
    And user clicks on 'Return to your account home' link
    And user is on the page with title 'Personal tax account' and URL is as expected

