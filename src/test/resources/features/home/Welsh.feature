@suite
Feature: Welsh Content in PTA

  As a HMRC Customer
  I need to be able to view the PTA content in welsh language
  and view welsh language warning banner on expected pages
  and language selection events are tracked in google analytics

  JIRA story history: MTA-2577, MTA-2592, MTA-2658

  Scenario: User is able to view the content in Welsh language
    Given A user with a Correspondence Address is logged into the service using verify
    When user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on language 'Cymraeg' link
    And an link-click language select event to 'Cymraeg' is sent to google analytics
    Then user sees text 'Cyfrif treth personol' on the page
    And user sees 'Diweddaru'ch cyfeiriad' link on the page and its href is as expected
    And user sees text 'Treth ac Yswiriant Gwladol' on the page
    And user clicks on language 'English' link
    And an link-click language select event to 'English' is sent to google analytics

  Scenario: User is able to view the Welsh language Warning message
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user clicks on 'National Insurance' link
    And user sees text 'Your National Insurance number is' on the NI page
    And user clicks on language 'Cymraeg' link
    And an link-click language select event to 'Cymraeg' is sent to google analytics
    Then user sees text 'Nid yw rhai o'r tudalennau hyn wedi'u cyfieithu i'r Gymraeg eto.' on the page
    And user clicks on 'Hafan y cyfrif' breadcrumb link
    And user clicks on 'Rheoli'ch gosodiadau e-bost' link
    Then user sees text 'Nid yw rhai o'r tudalennau hyn wedi'u cyfieithu i'r Gymraeg eto.' on the page
    And user clicks on 'Hafan y cyfrif' breadcrumb link
    And user clicks on 'Hunanasesiad' link
    Then user sees text 'Nid yw rhai o'r tudalennau hyn wedi'u cyfieithu i'r Gymraeg eto.' on the page
    And user clicks on 'Hafan y cyfrif' breadcrumb link
#    And user clicks on 'Credydau treth' link
#    Then user sees text 'Nid yw rhai o'r tudalennau hyn wedi'u cyfieithu i'r Gymraeg eto.' on the page
    And user clicks on language 'English' link
    And an link-click language select event to 'English' is sent to google analytics








