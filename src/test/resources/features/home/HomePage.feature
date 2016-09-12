@suite12
Feature: Home Page segmentation
  As a user
  I want to see PTA home page with proper segmentation and bucketing
  Also test the breadcrumb is as expected

  JIRA story history: MTA-1135, MTA-1848, MTA-1783, MTA-1966, MTA-1964, MTA-1990 , MTA-2115 , MTA-2116

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

    Then user is able to see a section 'Services you might need'
    And user sees text 'View your taxable income and see any company benefits that may affect the amount, for example a company car or medical benefit.' on the home page
    And user sees text 'If you're married or in a civil partnership and you earn less than £11,000, you may benefit from applying for Marriage Allowance.' on the home page
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected
    And user sees 'View your company benefits' link on the page and its href is as expected



  Scenario: GG User who has applied for lifetime allowance navigates to PTA homepage and sees lifetime allowance bucket
    Given   User who has applied for lifetime allowance is logged into the service using gg
    Then    user is on the page with title 'Personal tax account' and URL is as expected
    And     user sees 'Lifetime allowance protection' link on the page and the href is as expected
    And     user sees text 'See your existing protection details.' on the home page


  Scenario: Verify User who has applied for lifetime allowance navigates to PTA homepage and sees lifetime allowance bucket
    Given   A user who has applied for lifetime allowance is logged into the service using verify
    Then    user is on the page with title 'Personal tax account' and URL is as expected
    And     user sees 'Lifetime allowance protection' link on the page and the href is as expected
    And     user sees text 'See your existing protection details.' on the home page
