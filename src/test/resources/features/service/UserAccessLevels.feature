@suite
Feature: Users with various access levels view/access appropriate items on PTA
  As a user
  I want to view the appropriate items based on my access levels

  JIRA story history: MTA-1237,MTA-1188,MTA-1354,MTA-1355, MTA-1356, MTA_1357, MTA-1585, MTA-1734, MTA-1783
  lowGG means CL50, highGG means CL100 or CL200 (dependant on watchlist - to which we do not pay attention here)

  Scenario: Check that a Verify user(CL500) NOT IN SA regime sees the appropriate options on PTA
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    Then user waits for 'Personal tax account' page
    And user sees name 'Martin Hempton' on the page
    And user sees 'National Insurance' link on the page and its href is as expected
    And user sees 'State Pension forecast' link on the page and its href is as expected
    And user sees 'Pay As You Earn (PAYE)' link on the page and its href is as expected
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected
    And user sees 'View your trusted helper contacts' link on the page and its href is as expected
    And user sees 'Update your address' link on the page and its href is as expected
    And user sees 'Track your forms' link on the page and its href is as expected
    And user sees 'Manage your email settings' link on the page and its href is as expected
    And user can not see 'Go to your messages' link
    And user can not see 'Self Assessment' link
    And user can not see 'Services for businesses' section

  Scenario: Check that a Verify user (without PAYE record)(CL500) IN SA regime sees the appropriate options on PTA
    Given A user with No Active PAYE account, but SA account is logged into the service using verify
#    And user sees 'National Insurance' link on the page and its href is as expected
    And user sees 'State Pension forecast' link on the page and its href is as expected
    And user sees 'Track your forms' link on the page and its href is as expected
    And user sees 'Manage your email settings' link on the page and its href is as expected
    And user sees 'View your trusted helper contacts' link on the page and its href is as expected
    And user sees 'Update your address' link on the page and its href is as expected
#    And user can not see 'Messages' link
    And user can not see 'Self Assessment' link
    And user can not see 'Pay As You Earn (PAYE)' link
    And user can not see 'Go to your messages' link
    And user can not see 'Self Assessment' link
    And user can not see 'Services for businesses' section

  Scenario: Check that a High GG user(CL200) NOT IN SA regime sees the appropriate options on PTA
    Given User with a PAYE account, but no SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user sees name 'Martin Hempton' on the page
    And user sees 'Pay As You Earn (PAYE)' link on the page and its href is as expected
    And user sees 'National Insurance' link on the page and its href is as expected
    And user sees 'State Pension forecast' link on the page and its href is as expected
    And user sees 'Update your address' link on the page and its href is as expected
    And user sees 'Track your forms' link on the page and its href is as expected
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected
    And user sees 'Manage your email settings' link on the page and its href is as expected
    And user can not see 'Self Assessment' link
    And user can not see 'View your trusted helper contacts' link
    And user can not see 'Services for businesses' section

  Scenario: Check that a High GG user(CL200) IN SA regime sees the appropriate options on PTA
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Personal tax account' and URL is as expected
    And user sees name 'Bob Jones' on the page
    And user sees 'National Insurance' link on the page and its href is as expected
    And user sees 'State Pension forecast' link on the page and its href is as expected
    And user sees 'Update your address' link on the page and its href is as expected
#    And user sees 'Go to your messages' link on the page and its href is as expected
    And user sees 'Self Assessment' link on the page and its href is as expected
    And user sees 'your business tax account' link on the page and its href is as expected
    And user sees 'Manage your email settings' link on the page and its href is as expected
    And user sees 'Pay As You Earn (PAYE)' link on the page and its href is as expected
    And user sees 'Track your forms' link on the page and its href is as expected
    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected
    And user can not see 'View your trusted helper contacts' link

  Scenario: Check that a Low GG user(CL50) NOT IN SA regime sees the appropriate options on PTA
    Given User with a PAYE account, but no SA account is logged into the service using gg
    And user completes 2FA Journey
    And user Aborts the IV Uplift
    Then user waits for 'We're unable to confirm your identity' page
    And user is on the page with title 'We're unable to confirm your identity' with expected URL

  Scenario: Check that a Low GG user(CL50) IN SA regime sees the appropriate options on PTA
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user Aborts the IV Uplift
    Then user waits for 'We're unable to confirm your identity' page
    And user is on the page with title 'We're unable to confirm your identity' with expected URL

  Scenario: Check that a Verify user(CL500) NOT IN SA regime is able to access the appropriate options on PTA
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    Then user clicks on 'National Insurance' link
    Then user is on the page with title 'National Insurance summary' and URL is as expected
    And user navigates to personal tax account home page
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected

    Scenario: Check that a Verify user(CL500) IN SA regime is able to access the appropriate options on PTA
    Given  A user with a PAYE account and SA account is logged into the service using verify
    Then user clicks on 'National Insurance' link
    Then user is on the page with title 'National Insurance summary' and URL is as expected
    And user navigates to personal tax account home page

  Scenario: Check that a High GG user(CL200) NOT IN SA regime is able to access the appropriate options on PTA
    Given User with a PAYE account, but no SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user navigates to personal tax account home page
    Then user clicks on 'National Insurance' link
    Then user is on the page with title 'National Insurance summary' and URL is as expected
    And user navigates to personal tax account home page
    And user clicks on 'Update your address' link
    And user is on the page with title 'Your address' and URL is as expected

  Scenario: Check that a High GG user(CL200) IN SA regime is able to access the appropriate options on PTA
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    And user clicks on 'Self Assessment' link
    Then user is on the page with title 'Self Assessment summary' and URL is as expected
    And user navigates to personal tax account home page
    Then user clicks on 'National Insurance' link
    Then user is on the page with title 'National Insurance summary' and URL is as expected
    And user navigates to personal tax account home page
    And user clicks on 'Manage your email settings' link
    And user is on the page with title 'Manage your email settings' and URL is as expected
    And user navigates to personal tax account home page
#    And user clicks on 'Go to your messages' link
#    Then user is on the page with title 'List of messages' and URL is as expected

  Scenario: Check that a Low GG user(CL50) NOT IN SA regime is able to access the appropriate options on PTA
    Given User with a PAYE account, but no SA account is logged into the service using gg
    And user completes 2FA Journey
    And user Aborts the IV Uplift
    Then user waits for 'We're unable to confirm your identity' page
    And user is on the page with title 'We're unable to confirm your identity' with expected URL





