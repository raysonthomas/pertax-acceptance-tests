@suite
Feature: MCI User
  As a user
  I want to see Technical Difficulties page as expected

  JIRA story history: MTA-2125, MTA-2211, MTA-2436, MTA-2436Part2, MTA-2560, MTA-2696

  Scenario: Check that the home page has proper segmentation
    Given A user with MCI Indicator set as true is logged into the service using verify
    Then MCI user sees text 'You can't access your account right now' on the page
    And MCI user sees text 'We need to talk to you about an MCI error before you can sign in.' on the page
    And MCI user sees text 'How to contact us' on the page
    And MCI user sees text 'Telephone: 0300 200 3300' on the page
    And MCI user sees text 'Textphone: 0300 200 3319' on the page
    And MCI user sees text 'Outside UK: +44 135 535 9022' on the page
    And MCI user sees text 'Phone lines are open:' on the page
    And MCI user sees text '8am to 8pm, Monday to Friday' on the page
    And MCI user sees text '8am to 4pm Saturdays' on the page
    And MCI user sees text '9am to 5pm Sundays' on the page
    And MCI user sees text 'Closed bank holidays.' on the page
    And user sees 'Find out about call charges (opens in a new window)' link on the page and its href is as expected

  Scenario: Check that the home page has proper segmentation for Welsh language
    Given A user with MCI Indicator set as true is logged into the service using verify
    Then MCI user sees text 'You can't access your account right now' on the page
    And user clicks on language 'Cymraeg' link
    And an link-click language select event to 'Cymraeg' is sent to google analytics
    Then user sees text 'Ni allwch gyrchu'ch cyfrif ar hyn o bryd' on the page
    Then user sees text 'Sut i gysylltu â ni' on the page
    Then user sees text 'Ffôn: 0300 200 3300' on the page
    Then user sees text '8am i 8pm, Dydd Llun i Dydd Gwener' on the page
    Then user sees text 'Ar gau ar wyliau'r banc.' on the page
    And user sees 'Dod i wybod am yr hyn a godir am alwadau (yn agor ffenestr newydd)' link on the page and its href is as expected
    And user clicks on language 'English' link
    And an link-click language select event to 'English' is sent to google analytics
    And user sees 'Find out about call charges (opens in a new window)' link on the page and its href is as expected












