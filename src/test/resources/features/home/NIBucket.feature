@suite
Feature: NI Bucket
  As a user
  I want to see my National Insurance Record

  JIRA story history: MTA-1788, MTA-1818

  Scenario: As Verify user, check that the NI Bucket page is displayed as expected
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    Then user clicks on 'National Insurance' link
    And Breadcrumb is: 'Account home'
    Then user is on the page with title 'National Insurance summary' and URL is as expected
    And heading 'National Insurance' is visible on NI page
    And user is able to see a section 'Check your National Insurance record' on NI Page
    And user sees text 'See a record of the National Insurance contributions which count towards your State Pension and check for any gaps.' on the NI page
    And user sees text 'The personal tax account is a new service – in the future we'll show you more details from your National Insurance record.' on the NI page
    And user sees 'Check your National Insurance record' link on the page and its href is as expected
    And user clicks on 'Account home' breadcrumb link
    And user is on the page with title 'Personal tax account' and URL is as expected

  Scenario: As a Uplifted GG user, check that the NI Bucket page is displayed as expected
    Given A user with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then user clicks on 'National Insurance' link
    And Breadcrumb is: 'Account home'
    Then user is on the page with title 'National Insurance summary' and URL is as expected
    And heading 'National Insurance' is visible on NI page
    And user is able to see a section 'Check your National Insurance record' on NI Page
    And user sees text 'See a record of the National Insurance contributions which count towards your State Pension and check for any gaps.' on the NI page
    And user sees text 'The personal tax account is a new service – in the future we'll show you more details from your National Insurance record.' on the NI page
    And user sees 'Check your National Insurance record' link on the page and its href is as expected
    And user clicks on 'Account home' breadcrumb link
    And user is on the page with title 'Personal tax account' and URL is as expected

  Scenario: As a Not Uplifted GG user, check that the user is asked to uplift to see the NI information
    Given A user with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user Aborts the IV Uplift
    And user is on the page with title 'We're unable to confirm your identity' with expected URL







