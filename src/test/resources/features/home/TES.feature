@suite
Feature: TES/TAI/PAYE
  As a PAYE user
  I need to be able to access my PAYE record
  So that I can manage my affairs

  JIRA story history: MTA-1190, MTA-1969, MTA-2036

  Scenario: User is enrolled in PAYE regime and should be able to see link to PAYE
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    And user sees text 'How you pay Income Tax' on the home page
    And user sees 'Pay As You Earn (PAYE)' link on the page and its href is as expected

  Scenario: GG User is enrolled in PAYE regime and should be able to see link to PAYE
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user sees text 'How you pay Income Tax' on the home page
    And user sees 'Pay As You Earn (PAYE)' link on the page and its href is as expected
    And user sees 'Self Assessment' link on the page and its href is as expected

  Scenario: User is NOT enrolled in PAYE regime and should NOT be able to see link to PAYE, but able to see SA bucket link
    Given User with No Active PAYE account, but SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user sees text 'How you pay Income Tax' on the home page
    And user does not see the link  'Pay As You Earn (PAYE)' on the home page
    And user sees 'Self Assessment' link on the page and its href is as expected

  Scenario: User is NOT enrolled in PAYE regime and no active SA Enrolment should NOT be able to see link to PAYE and SA bucket link
    Given User with No Active PAYE and No SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user does not see text 'How you pay Income Tax' on the home page
    And user does not see the link  'Pay As You Earn (PAYE)' on the home page
    And user does not see the link  'Self Assessment' on the home page

  Scenario: User is NOT enrolled in PAYE regime and HAS a SA Enrolment should NOT be able to see link to PAYE and SA bucket link
    Given A user with No PAYE but SA account is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user does not see text 'How you pay Income Tax' on the home page
    And user does not see the link  'Pay As You Earn (PAYE)' on the home page
    And user does not see the link  'Self Assessment' on the home page