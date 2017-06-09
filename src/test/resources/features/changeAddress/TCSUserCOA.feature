@suite
Feature: Verify my home address
  As a HMRC Customer who’s got interest in TCS,
  I need to tell HMRC what my home is, and be able to change my home address.

  JIRA story history: MTA-1691


  Scenario: User changes home address
    Given TCS user is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on visible 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    And user clicks on 'Change your address' link
    Then user sees text 'Do you get tax credits?' on the page
    Then user selects the option Yes for Tax Credits
    Then user continues from Tax Credits page
#    And user is on the page with expected URL



  Scenario: PERTAX_FRONTEND is Restarted with toggle feature on
    Given The service PERTAX FRONTEND is restarted with tax credits toggle


  Scenario: User changes home address
    Given TCS user is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on visible 'Update your address' link
    And user clicks on 'Change your address' link
    Then user sees text 'Do you live in more than one place?' on the page
    Then user selects the option No
    Then user continues from Your address page
    And user updates 'postcode' with 'FX97 4TU'
    Then user clicks on 'submitAddressFinder' button
    Then user waits for select address page
    And user selects the address '10 Test Street, Testtown, FX97 4TU' and continues
    Then user waits for 'When did you start living here?' page
    And user updates date field 'startDate.day' with '02'
    And user updates date field 'startDate.month' with '04'
    And user updates date field 'startDate.year' with '2016'
    Then user continues from Enter start date page
    Then user clicks on Confirm and save button on Check your answers page
    Then user waits for 'Your address has been updated' page
    And user is on the page with title 'Your address has been updated' and whose URL is as expected


  Scenario: PERTAX_FRONTEND is Restarted with toggle feature on
    Given The service 'PERTAX_FRONTEND' is restarted