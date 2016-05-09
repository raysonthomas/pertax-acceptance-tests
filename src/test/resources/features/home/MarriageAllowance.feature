@suite

Feature: Ability to apply for Marriage Allowance
  As a user
  I want to be notified about my eligibility for marriage allowance
  So that I can easily navigate to marriage allowance service and apply for it there

  JIRA story history: MTA-1194, MTA-1683, MTA-1625, MTA-1731

  Scenario: Login as a user who has not enrolled for Marriage Allowance (tax code does not end with a 'N' or 'M')
    Given user 'Martin Hempton' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    Then user is able to see a section 'Recommended services'
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected

  Scenario: Login as a user who has enrolled for Marriage Allowance (tax code ends with a 'M')
    Given user 'M Andrew' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    Then user is not able to see a recommendation section 'Recommended services'
    And user does not see a recommendation link matching: 'Check if you can get Marriage Allowance'

  Scenario: Login as a user who has enrolled for Marriage Allowance (tax code ends with a 'N')
    Given user 'Jayne Rockle' is logged into the service
    And user is on the page with title 'Your personal tax account' and URL is as expected
    Then user is not able to see a recommendation section 'Recommended services'
    And user does not see a recommendation link matching: 'Check if you can get Marriage Allowance'

  Scenario: Login as a GG user who is Uplifted and tax code does not end with a 'N' or 'M'
    Given GG user 'SA Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected
    Then user is able to see a section 'Recommended services'
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected

#  Scenario: Login as a GG user who is Not Uplifted and tax code does not end with a 'N' or 'M'
#    Given GG user 'SA Christopher Grantham' is logged into the service
#    And user completes 2FA Journey
#    And user Aborts the IV Uplift
#    And user Continues the journey to PTA
#    And user is on the page with title 'Your personal tax account' and URL is as expected
#    Then user is not able to see a recommendation section 'Recommended for you'
#    And user does not see a recommendation link matching: 'Check if you can get Marriage Allowance'

  Scenario: Login as a GG user who is Uplifted and tax code ends with a 'M'
    Given GG user 'SA M Andrew' is logged into the service
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected
    Then user is not able to see a recommendation section 'Recommended services'
    And user does not see a recommendation link matching: 'Check if you can get Marriage Allowance'

  Scenario: Login as a GG user who is Uplifted and tax code ends with a 'N'
    Given GG user 'SA Jayne Rockle' is logged into the service
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected
    Then user is not able to see a recommendation section 'Recommended services'
    And user does not see a recommendation link matching: 'Check if you can get Marriage Allowance'