@suite
Feature: Home Page segmentation
  As a user
  I want to see PTA home page with proper segmentation and bucketing
  Also test the breadcrumb is as expected

  JIRA story history: MTA-1135, MTA-1848, MTA-1783, MTA-1966, MTA-1964, MTA-1990 , MTA-2115 , MTA-2116, MTA-2364, MTA-2559, MTA-2515, MTA-2564, MTA-2639

  Scenario: Check that the home page has proper segmentation
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    When user is on the page with title 'Personal tax account' and URL is as expected
    Then Breadcrumb is: ''
    And heading 'Child Benefit and tax credits' is visible
    And user sees 'Tax credits' link on the page and its href is as expected
    And user sees text 'Check your tax credits record.' on the home page
    Then user clicks on 'Tax credits' link
    Then user is on the page with title 'Your tax credits' and URL is as expected
    And Breadcrumb is: 'Account home'
    And text 'Your tax credits' is visible on Tax credits Page
    And user clicks back button
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user sees 'Child Benefit' link on the page and its href is as expected
    And user sees text 'Tell us about changes that may affect your Child Benefit.' on the home page
    And user sees 'National Insurance' link on the page and its href is as expected
    And user sees 'Company benefits' link on the page and its href is as expected
    And user sees text 'See how company car and medical benefit could affect your taxable income.' on the home page
    And heading 'Pension and retirement' is visible
    And user sees 'State Pension forecast' link on the page and its href is as expected
    Then user is able to see a section 'Services you might need'
    And user sees text 'If you receive Child Benefit, and your child was aged 16 on or before 31 August, you need to tell us if your child is staying in education or training.' on the home page
    And user sees 'Tell us if your child is staying in education or training' link on the page and its href is as expected
    And user sees text 'If you're married or in a civil partnership and you earn less than £11,500, you may benefit from applying for Marriage Allowance.' on the home page
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected

#  Scenario: Check that the home page has proper segmentation for Online SA user
#    Given User with a PAYE account and SA account is logged into the service using gg
#    And user completes 2FA Journey
#    And user completes IV Uplift Journey
#    And user Continues the journey to PTA
#    And user is on the page with title 'Personal tax account' and URL is as expected
#    And user sees text 'Important deadlines' on the home page
#    And user sees text 'The deadline for completing tax returns for 2015 to 2016 is 31 January 2017' on the home page
#    And user sees 'View your Self Assessment' link on the page and its href is as expected

  Scenario: User sets up the LTA
    Given   Protections are added

  Scenario: GG User who has applied for lifetime allowance navigates to PTA homepage and sees lifetime allowance bucket
    Given   User who has applied for lifetime allowance is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then user is on the page with title 'Personal tax account' and URL is as expected
    And user sees 'Lifetime allowance protection' link on the page and its href is as expected
    And user sees text 'See your existing protection details' on the home page

  Scenario: Verify User who has applied for lifetime allowance navigates to PTA homepage and sees lifetime allowance bucket
    Given   A user who has applied for lifetime allowance is logged into the service using verify
    Then user is on the page with title 'Personal tax account' and URL is as expected
    And user sees 'Lifetime allowance protection' link on the page and its href is as expected
    And user sees text 'See your existing protection details' on the home page

  Scenario: Prompt for all PTA users to see link on homepage for User Research
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    Then user is on the page with title 'Personal tax account' and URL is as expected
    And user sees 'Help us with our research (opens in new window)' link on the page and its href is as expected
    And user clicks on Help us with our research opens in new window link for user  research
    And an outbound click event to 'https://zwgy80l7.optimalworkshop.com/treejack/navigation' is sent to google analytics





