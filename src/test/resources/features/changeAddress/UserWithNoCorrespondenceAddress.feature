@suite
Feature: Verify my correspondence address
  As a HMRC Customer
  I need to be able to add my correspondence address

  JIRA story history: MTA-1691

  Scenario: User with no correspondence address sees appropriate details. User with no correspondence address is able to add their correspondence address
    Given User with No Correspondence Address is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected
    Then user sees text 'Letters from HM Revenue and Customs currently get sent to your home address.' on the page
    And user sees 'Change where we send your letters' link on the page and its href is as expected
    Then user sees text 'Get letters sent to a different address' on the page
    And user sees 'Change where we send your letters' link on the page and its href is as expected
    Then user clicks on 'Change where we send your letters' link
    Then user is on the page with title 'Find an address' and URL is as expected
