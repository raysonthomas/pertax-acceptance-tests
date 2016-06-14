@suite

Feature: Ability to apply for Marriage Allowance
  As a user
  I want to be notified about my eligibility for marriage allowance
  So that I can easily navigate to marriage allowance service and apply for it there

  JIRA story history: MTA-1194, MTA-1683, MTA-1625, MTA-1731, MTA-2037

  Scenario: Login as a user who has not enrolled for Marriage Allowance (tax code does not end with a 'N' or 'M')
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    Then user is able to see a section 'Recommended for you'
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected

  Scenario: Login as a user who has enrolled for Marriage Allowance (tax code ends with a 'M')
    Given A user with Tax Code ending with M is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    Then user is not able to see a recommendation section 'Recommended for you'
    And user does not see a recommendation link matching: 'Check if you can get Marriage Allowance'

  Scenario: Login as a user who has enrolled for Marriage Allowance (tax code ends with a 'N')
    Given A user with Tax Code ending with N is logged into the service using verify
    And user is on the page with title 'Personal tax account' and URL is as expected
    Then user is not able to see a recommendation section 'Recommended for you'
    And user does not see a recommendation link matching: 'Check if you can get Marriage Allowance'

  Scenario: Login as a GG user who is Uplifted and tax code does not end with a 'N' or 'M'
    Given  User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    Then user is able to see a section 'Recommended for you'
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected


  Scenario: Login as a GG user who is Uplifted and tax code ends with a 'M'
    Given User with Tax Code ending with M and SA is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    Then user is not able to see a recommendation section 'Recommended for you'
    And user does not see a recommendation link matching: 'Check if you can get Marriage Allowance'

  Scenario: Login as a GG user who is Uplifted and tax code ends with a 'N'
    Given User with Tax Code ending with N and SA is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    Then user is not able to see a recommendation section 'Recommended for you'
    And user does not see a recommendation link matching: 'Check if you can get Marriage Allowance'