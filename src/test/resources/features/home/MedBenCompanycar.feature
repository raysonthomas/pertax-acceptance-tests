@suite

Feature: Ability to make use of Medical Benefits and Company Car from PTA
  As a user
  I want to be able to use Medical Benefits and Company Car from PTA links from PTA home page

  JIRA story history: MTA-1949, MTA-1988


  Scenario: GG user is able to use the 'check your taxable income' link to go to Company car and Medical benefits
    Given User with active company benefits is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    Then user is able to see a section 'Services you might need'
    And user sees text 'View your taxable income and see any company benefits that may affect the amount, for example a company car or medical benefit.' on the home page
    And user sees 'View your company benefits' link on the page and its href is as expected

  Scenario: User without active company benefits sees appropriate content on home page
    Given User without active company benefits is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    Then user is able to see a section 'Services you might need'
    And user does not see text 'View your taxable income and see any company benefits that may affect the amount, for example a company car or medical benefit.' on the home page
    And user does not see the link  'View your company benefits' on the home page
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected

  Scenario: User without active company benefits but with Marriage Allowance sees appropriate content on home page
    Given User without active company benefits but marriage allowance is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    Then user is not able to see a recommendation section 'Services you might need'
    And user does not see text 'View your taxable income and see any company benefits that may affect the amount, for example a company car or medical benefit.' on the home page
    And user does not see the link  'View your company benefits' on the home page
    And user does not see a recommendation link matching: 'Check if you can get Marriage Allowance'



