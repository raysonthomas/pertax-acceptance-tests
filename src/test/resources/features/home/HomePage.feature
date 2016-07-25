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
    Then user is on the page with title 'Your tax credits' and URL is as expected
    And Breadcrumb is: 'Account home'
    And text 'Your tax credits' is visible on Tax credits Page
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

    And user clicks on 'Account home' breadcrumb link
    And user is on the page with title 'Personal tax account' and URL is as expected




    Scenario: When a user has paid too much tax in the previous tax year and has not requested a refund yet

      Given A user who has not requested a refund yet is logged into the service using verify
      Then  user is on the page with title 'Personal tax account' and URL is as expected
      And   user sees text 'You have paid too much tax' on the home page
      And   user sees text 'HM Revenue and Customs owe you a £1,000 refund for the 2015 to 2016 tax year.' on the home page
      And   user sees 'Get your refund' link on the page and its href is as expected


    Scenario: When a user has paid too much tax in the previous tax year and has requested a refund which is currently being processed
      Given A user who has requested a refund currently being processed is logged into the service using verify
      Then  user is on the page with title 'Personal tax account' and URL is as expected
      And   user sees text 'You paid too much tax' on the home page
      And   user sees text 'HM Revenue and Customs are processing your £1,000 refund.' on the home page

    Scenario: When a user has been sent a BACS payment for their refund
      Given A user who has has been sent a BACS payment is logged into the service using verify
      Then  user is on the page with title 'Personal tax account' and URL is as expected
      And   user sees text 'You paid too much tax' on the home page
      And   user sees text 'HM Revenue and Customs paid you a refund of £1,000' on the home page

    Scenario:When a user has been sent a cheque for their refund they should see a banner with the below details
     Given A user who has has been sent a cheque is logged into the service using verify
     Then  user is on the page with title 'Personal tax account' and URL is as expected
     And   user sees text 'You paid too much tax' on the home page
     And   user sees text 'HM Revenue and Customs sent you a cheque for £1,000' on the home page

    Scenario: When a user has not got an overpayment
      Given A user without a tax underpayment is logged into the service using verify
      Then  user is on the page with title 'Personal tax account' and URL is as expected
      And   user does not see text 'You paid too much tax' on the home page
      And   user does not see text 'You have paid too much tax' on the home page

     Scenario: When a user has paid too little tax in the previous tax year and has not made an additional payment yet
        Given A user who has paid too little tax is logged into the service using verify
        Then  user is on the page with title 'Personal tax account' and URL is as expected
        And   user sees text 'You have paid too little tax' on the home page
        And   user sees text 'You owe HM Revenue and Customs £2,000 for the 2015 to 2016 tax year.' on the home page
        And   user sees 'Get more details' link on the page and its href is as expected



