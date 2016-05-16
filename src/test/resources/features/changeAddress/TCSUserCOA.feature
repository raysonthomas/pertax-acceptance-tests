@suite
Feature: Verify my home address
  As a HMRC Customer who’s got interest in TCS,
  I need to tell HMRC what my home is, and be able to change my home address.

  JIRA story history: MTA-1691


  Scenario: User changes home address
    Given GG user 'SA Hazel Young' is logged into the service
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    And user clicks on 'Change your address' link
    Then user sees text 'Do you get tax credits?' on the page
    Then user selects the option Yes for Tax Credits
    Then user continues from Tax Credits page
    And user is on the page with expected URL



