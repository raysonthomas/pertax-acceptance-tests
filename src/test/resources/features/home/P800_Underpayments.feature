@suite


Feature: As a PTA user
  I want to know when I have made an overpayment to HMRC
  So that I can get my money back



  Scenario: when a user has paid too much tax in the previous tax year and has requested a refund which is currently being processed
    Given A user who has requested a refund currently being processed is logged into the service using verify
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And   user sees text 'You have paid too much tax' on the home page
    And   user sees text 'HM Revenue and Customs are processing your £1,000 refund.' on the home page

  Scenario: when a user has been sent a BACS payment for their refund
    Given A user who has has been sent a BACS payment is logged into the service using verify
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And   user sees text 'You have paid too much tax' on the home page
    And   user sees text 'HM Revenue and Customs paid you a refund of £1,000' on the home page

  Scenario:when a user has been sent a cheque for their refund they should see a banner with the below details
    Given A user who has has been sent a cheque is logged into the service using verify
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And   user sees text 'You have paid too much tax' on the home page
    And   user sees text 'HM Revenue and Customs sent you a cheque for £1,000' on the home page

  Scenario: when a user has not got an overpayment
    Given A user without a tax underpayment is logged into the service using verify
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And   user does not see text 'You paid too much tax' on the home page
    And   user does not see text 'You have paid too much tax' on the home page

  Scenario: when a user has paid too little tax in the previous tax year and has not made an additional payment yet
    Given A user who has paid too little tax is logged into the service using verify
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And   user sees text 'You have paid too little tax' on the home page
    And   user sees text 'You owe HM Revenue and Customs £2,000 for the 2015 to 2016 tax year.' on the home page
    And   user sees 'Get more details' link on the page and its href is as expected

  Scenario: when a user has paid too much tax in the previous tax year and has not requested a refund yet
    Given A user who has not requested a refund yet is logged into the service using verify
    Then  user is on the page with title 'Personal tax account' and URL is as expected
    And   user sees text 'You have paid too much tax' on the home page
    And   user sees text 'HM Revenue and Customs owe you a £1,000 refund for the 2015 to 2016 tax year.' on the home page
    And   user sees 'Get your refund' link on the page and its href is as expected




