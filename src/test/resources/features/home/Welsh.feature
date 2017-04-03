@suite
Feature: Welsh Content in PTA

  As a HMRC Customer
  I need to be able to view the PTA content in welsh language
  and view welsh language warning banner on expected pages.

  JIRA story history: MTA-2577, MTA-2592

  Scenario: User is able to view the content in Welsh language
    Given A user with a Correspondence Address is logged into the service using verify
    When user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on language 'Cymraeg' link
    Then user sees text 'Cyfrif treth personol' on the page
    And user sees 'Diweddaru'ch cyfeiriad' link on the page and its href is as expected
    And user sees text 'Treth ac Yswiriant Gwladol' on the page
    And user clicks on language 'English' link

  Scenario: User is able to view the Welsh language Warning message
    Given A user with a Correspondence Address is logged into the service using verify
    When user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'National Insurance' link
    And user sees text 'Your National Insurance number is' on the NI page
    And user clicks on language 'Cymraeg' link
    Then user sees text 'Nid yw rhai o'r tudalennau hyn wedi'u cyfieithu i'r Gymraeg eto.' on the page
    And user clicks on language 'English' link








