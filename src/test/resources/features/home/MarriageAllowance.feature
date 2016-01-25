@suite

Feature: Ability to apply for Marriage Allowance
  As a user
  I want to be notified about my eligibility for marriage allowance
  So that I can easily navigate to marriage allowance service and apply for it there

  JIRA story history: MTA-1194, MTA-1683

  Scenario: Login as a user who has not enrolled for Marriage Allowance (tax code does not end with a 'N' or 'M')
    Given user 'Martin Hempton' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    Then user is able to see a section 'Marriage allowance'
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected

  Scenario: Login as a user who has enrolled for Marriage Allowance (tax code ends with a 'M')
    Given user 'M Andrew' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    Then user is able to see a section 'Marriage allowance'
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected

  Scenario: Login as a user who has enrolled for Marriage Allowance (tax code ends with a 'N')
    Given user 'Jayne Rockle' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    Then user is able to see a section 'Marriage allowance'
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected

  Scenario: Login as a GG user
    Given GG user 'SA Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected
    Then user is able to see a section 'Marriage allowance'
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected
