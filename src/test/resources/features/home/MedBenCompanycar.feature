@suite

Feature: Ability to make use of Medical Benefits and Company Car from PTA
  As a user
  I want to be able to use Medical Benefits and Company Car from PTA links from PTA home page

  JIRA story history: MTA-1949


  Scenario: GG user is able to use the 'check your taxable income' link to go to Company car and Medical benefits
    Given GG user 'SA Christopher Grantham' is logged into the service
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected
    Then user is able to see a section 'Recommended services'
    And user sees text 'Have you had a change in your company car or private medical insurance provided by your employer?' on the home page
    And user sees 'check your taxable income' link on the page and its href is as expected



