@suite
Feature: Home Page segmentation
  As a user
  I want to see PTA home page with proper segmentation and bucketing
  Also test the breadcrumb is as expected

  JIRA story history: MTA-1135, MTA-1848, MTA-1783, MTA-1966, MTA-1964, MTA-1990 , MTA-2115

  Scenario: Check that the home page has proper segmentation
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    When user is on the page with title 'Personal tax account' and URL is as expected
    Then Breadcrumb is: ''

    And heading 'Your benefits and tax credits' is visible
    And user sees 'Tax credits' link on the page and its href is as expected
    And user sees text 'Check your tax credits record.' on the home page
    Then user clicks on 'Tax credits' link
    Then user is on the page with title 'Service not available' and URL is as expected
    And Breadcrumb is: 'Account home'
    And text 'Service not available' is visible on Tax credits Page
    And user clicks on 'Account home' breadcrumb link
    And user is on the page with title 'Personal tax account' and URL is as expected

    And user sees text 'Your State Pension' on the home page
    And user sees 'National Insurance' link on the page and its href is as expected
    And user sees 'State Pension forecast' link on the page and its href is as expected
    And user sees 'View your company benefits' link on the page and its href is as expected


    And user sees 'Child Benefit forms' link on the page and its href is as expected
    And user sees text 'Tell us about changes that may affect your Child Benefit.' on the home page


    Then user clicks on 'Child Benefit forms' link
    Then user is on the page with title 'Child Benefit forms' and URL is as expected
    And Breadcrumb is: 'Account home'
    And text 'Child Benefit forms' is visible on Child Benefit Page
    And text 'If you currently claim Child Benefit you may need to use one of these forms to tell us about changes.' is visible on Child Benefit Page
    And text 'Check if you can claim Child Benefit' is visible on Child Benefit Page
    And text 'If you don’t claim Child Benefit you normally qualify for it if you’re responsible for a child under 16 (or under 20 if they stay in approved education or training) and you live in the UK.' is visible on Child Benefit Page
    And user sees 'Check if you can claim Child Benefit (opens in new window)' link on the page and its href is as expected
#    And user clicks on 'Account home' breadcrumb link
#    And user is on the page with title 'Personal tax account' and URL is as expected
#    And   user sees 'Get more details' link on the page and its href is as expected

