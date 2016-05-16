@suite
Feature: Verify my home address
  As a HMRC Customer who’s got more than one home,
  Having no effective from date,
  I need to tell HMRC what my main home is, and be able to change my home address.

  JIRA story history: MTA-1691


  Scenario: User has no effective from date on record
    Given user 'Christopher Grantham' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected


  Scenario: User changes home address
    Given user 'Christopher Grantham' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
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
    Then user continues from Edit the address page
    Then user sees text 'When did this become your main home?' on the page
    And user updates date field 'startDate.day' with '01'
    And user updates date field 'startDate.month' with '01'
    And user updates date field 'startDate.year' with '2016'
    Then user continues from Enter start date page
    Then user sees text 'Check your details' on the page
    Then user sees text '8 Test Street' on the page
    Then user sees text '1 January 2016' on the page
    Then user clicks on Confirm and save button on Check your answers page
    And user is on the page with title 'Your address has been updated' and URL is as expected
    And user clicks on 'Return to your account home' link
    And user is on the page with title 'Your personal tax account' and URL is as expected
