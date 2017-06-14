@suite

Feature: As a PTA user
  I want to know when I have made an overpayment to HMRC
  So that I can get my money back

  JIRA story history: MTA-2115, MTA-2162



  Scenario: when a user has paid too much tax in the previous tax year and has requested a refund which is currently being processed
    Given A user who has requested a refund currently being processed is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And   user sees text 'You paid too much tax' on the home page
    And   user sees text 'HM Revenue and Customs are processing your £1,000.00 refund.' on the home page

  Scenario: when a user has been sent a BACS payment for their refund
    Given A user who has has been sent a BACS payment is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And   user sees text 'You paid too much tax' on the home page
    And   user sees text 'HM Revenue and Customs paid you a refund of £1,000.00 on 2 January 2016.' on the home page

  Scenario:when a user has been sent a cheque for their refund they should see a banner with the below details
    Given A user who has has been sent a cheque is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And   user sees text 'You paid too much tax' on the home page
    And   user sees text 'HM Revenue and Customs sent you a cheque for £1,000.00 on 2 January 2016.' on the home page

  Scenario: when a user has not got an overpayment
    Given A user without a tax underpayment is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And   user does not see text 'You have paid too much tax' on the home page

  Scenario: when a user has paid too little tax in the previous tax year and has not made an additional payment yet
    Given A user who has paid too little tax is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And   user sees text 'You have paid too little tax' on the home page
    And   user sees text 'You owe HM Revenue and Customs £1,000.00 for the 2016 to 2017 tax year.' on the home page
    And   user sees 'Get more details' link on the page and its href is as expected

  Scenario: when a user has paid too much tax in the previous tax year and has not requested a refund yet
    Given A user who has not requested a refund yet is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And   user sees text 'You have paid too much tax' on the home page
    And   user sees text 'HM Revenue and Customs owe you a £1,000.00 refund for the 2016 to 2017 tax year.' on the home page
    And   user sees 'Get your refund' link on the page and its href is as expected

  Scenario: when a user doesn't owe anymore income tax to HMRC
    Given A user who owes no income tax to pay is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And user sees text 'You don't owe anymore Income Tax' on the home page
    And user sees text 'You have no payments to make to HMRC for the tax year 2016 to 2017' on the home page
    And user sees text '' on the home page

  Scenario: when a user doesn't have a record on income tax
    Given A user who has no record on income tax is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And user sees text 'Income Tax not yet calculated' on the home page
    And user sees text 'Please wait for your tax calculation letter(P800)' on the home page
    And user sees text 'Get more information about when your P800 will arrive' on the home page

   Scenario: when a user has part paid their income tax
     Given A user who has part paid income tax is logged into the service using gg
     And user completes 2FA Journey
     And user completes IV Uplift Journey
     And user Continues the journey to PTA
     Then  user is on the page with title 'Personal tax account' and URL is as expected
     And user sees text 'You paid too little Income Tax' on the home page
     And user sees text 'You owe HMRC £500 for the 2016 to 2017 tax year' on the home page
     And user sees text 'Get more information about the tax you owe' on the home page

    Scenario:  When a user has a balanced status for the tax year
     Given A user who has part paid income tax is logged into the service using gg
     And user completes 2FA Journey
     And user completes IV Uplift Journey
     And user Continues the journey to PTA
     Then  user is on the page with title 'Personal tax account' and URL is as expected
     And user sees text 'You paid the right of Income Tax last year' on the home page
     And user sees text 'You don't owe HMRC anything for the tax year 2017 to 2017' on the home page
     And user sees text 'Get more information about the tax you paid' on the home page









