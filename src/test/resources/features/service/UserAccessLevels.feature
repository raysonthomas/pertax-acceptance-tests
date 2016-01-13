@wip
Feature: Users with various access levels view/access appropriate items on PTA
  As a user
  I want to view the appropriate items based on my access levels

  JIRA story history: MTA-1237,MTA-1188,MTA-1354,MTA-1355, MTA-1356, MTA_1357
  lowGG means CL50, highGG means CL100 or CL200 (dependant on watchlist - to which we do not pay attention here)

#  Scenario: Check that a Verify user(CL500) NOT IN SA regime sees the appropriate options on PTA
#    Given user 'Martin Hempton' is logged into the service
#    And user sees name 'Martin Hempton' on the page
#    And user sees nino 'AB 21 69 13 B' on the page
#    And user sees 'Benefits and tax credits' link on the page and its href is as expected
#    And user sees 'National Insurance' link on the page and its href is as expected
#    And user sees 'Pension' link on the page and its href is as expected
#    And user sees 'Income tax' link on the page and its href is as expected
#    And user sees 'Check if you can get Marriage Allowance' link on the page and its href is as expected
#    And user sees 'View your trusted helper contacts' link on the page and its href is as expected
#    And user sees 'Update your address' link on the page and its href is as expected
#    And user sees 'Track your forms' link on the page and its href is as expected
#    And user can not see 'Important deadlines' section
#    And user can not see 'Go to your messages' link
#    And user can not see 'Self Assessment' link
#    And user can not see 'Services for businesses' section
#    And user can not see 'Manage your paperless settings' link

#  Scenario: Check that a Verify user(CL500) IN SA regime sees the appropriate options on PTA
#    Given SA user 'Verify User1' is logged into the service
#    And user sees 'Benefits and tax credits' link on the page and its href is as expected
#    And user sees 'National Insurance' link on the page and its href is as expected
#    And user sees 'Pension' link on the page and its href is as expected
#    And user sees 'Track your forms' link on the page and its href is as expected
#    And user sees nino 'none' on the page
#    And user can not see 'Important deadlines' section
#    And user can not see 'Messages' link
#    And user can not see 'Self Assessment' link
#    And user can not see 'Income tax' link
#    And user can not see 'Check if you can get Marriage Allowance' link
#    And user can not see 'View your trusted helper contacts' link
#    And user can not see 'Update your address' link
#    And user can not see 'Important deadlines' section
#    And user can not see 'Go to your messages' link
#    And user can not see 'Self Assessment' link
#    And user can not see 'Services for businesses' section
#    And user can not see 'Manage your paperless settings' link

#  Scenario: Check that a High GG user(CL200) NOT IN SA regime sees the appropriate options on PTA
#    Given GG user 'Bob Jones' is logged into the service
#    And user goes through 2FA Journey
#    And user goes through IV Uplift Journey
#    And user Continues the journey to PTA
#    And user is on the page with title 'Your personal tax account' and URL is as expected
#    And user sees name 'Bob Jones' on the page
#    And user sees nino 'AA 00 00 03 B' on the page
#    And user sees 'Income tax' link on the page and its href is as expected
#    And user sees 'Benefits and tax credits' link on the page and its href is as expected
#    And user sees 'National Insurance' link on the page and its href is as expected
#    And user sees 'Pension' link on the page and its href is as expected
#    And user sees 'Update your address' link on the page and its href is as expected
#    And user sees 'Track your forms' link on the page and its href is as expected
#    And user can not see 'Important deadlines' section
#    And user can not see 'Go to your messages' link
#    And user can not see 'Self Assessment' link
#    And user can not see 'View your trusted helper contacts' link
#    And user can not see 'Services for businesses' section
#    And user can not see 'Manage your paperless settings' link

  Scenario: Check that a High GG user(CL200) IN SA regime sees the appropriate options on PTA
    Given SA GG user 'Bob Jones' is logged into the service
    And user goes through 2FA Journey
    And user goes through IV Uplift Journey
    And user Continues the journey to PTA
    And user is on the page with title 'Your personal tax account' and URL is as expected
#    And user sees name 'Christopher Grantham' on the page
#    And user sees nino 'CE 12 34 57 D' on the page
    And user sees 'Benefits and tax credits' link on the page and its href is as expected
    And user sees 'National Insurance' link on the page and its href is as expected
    And user sees 'Pension' link on the page and its href is as expected
    And user sees 'Important deadlines' section
    And user sees 'Update your address' link on the page and its href is as expected
    And user sees 'Go to your messages' link on the page and its href is as expected
    And user sees 'Self Assessment' link on the page and its href is as expected
    And user sees 'your business tax account.' link on the page and its href is as expected
    And user sees 'Manage your paperless settings' link on the page and its href is as expected
    And user sees 'Income tax' link on the page and its href is as expected
    And user sees 'Track your forms' link on the page and its href is as expected
    And user can not see 'Check if you can get Marriage Allowance' link
    And user can not see 'View your trusted helper contacts' link
    

#  Scenario: Check that a Low GG user(CL50) NOT IN SA regime sees the appropriate options on PTA
#    Given GG user 'M Andrew' is logged into the service
#    And user goes through 2FA Journey
#    And user does not go through IV Uplift Journey
#    And user Continues the journey to PTA
#    And user is on the page with title 'Your personal tax account' and URL is as expected
#    And user sees name 'mandrew' on the page
#    And user sees nino 'none' on the page
#    And user sees 'Benefits and tax credits' link on the page and its href is as expected
#    And user sees 'National Insurance' link on the page and its href is as expected
#    And user sees 'Pension' link on the page and its href is as expected
#    And user sees 'Income tax' link on the page and its href is as expected
#    And user sees 'Update your address' link on the page and its href is as expected
#    And user sees 'Track your forms' link on the page and its href is as expected
#    And user can not see 'Go to your messages' link
#    And user can not see 'Self Assessment' link
#    And user can not see 'Services for businesses' section
#    And user can not see 'Check if you can get Marriage Allowance' link
#    And user can not see 'View your trusted helper contacts' link
#    And user can not see 'Manage your paperless settings' link

#  Scenario: Check that a Low GG user(CL50) IN SA regime sees the appropriate options on PTA
#    Given GG user 'Christopher Grantham' is logged into the service
#    And user does not go through IV Uplift Journey
#    And user Continues the journey to PTA
#    And user is on the page with title 'Your personal tax account' and URL is as expected
#    And user sees name 'Scott The Booth' on the page
#    And user sees nino 'none' on the page
#    And user sees 'Important deadlines' section
#    And user sees 'Go to your messages' link on the page and its href is as expected
#    And user sees 'Self Assessment' link on the page and its href is as expected
#    And user sees 'Benefits and tax credits' link on the page and its href is as expected
#    And user sees 'National Insurance' link on the page and its href is as expected
#    And user sees 'Pension' link on the page and its href is as expected
#    And user sees 'your business tax account.' link on the page and its href is as expected
#    And user sees 'Manage your paperless settings' link on the page and its href is as expected
#    And user can not see 'Income tax' link
#    And user can not see 'Check if you can get Marriage Allowance' link
#    And user can not see 'View your trusted helper contacts' link
#    And user can not see 'Update your address' link
#    And user can not see 'Track your forms' link
#
#  Scenario: Check that a Verify user(CL500) NOT IN SA regime is able to access the appropriate options on PTA
#    Given user 'Martin Hempton' is logged into the service
#    And user clicks on 'Benefits and tax credits' link
#    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
#    And user navigates to personal tax account
#    Then user clicks on 'National Insurance' link
#    Then user is on the page with title 'National Insurance summary' and URL is as expected
#    And user navigates to personal tax account
#    Then user clicks on 'Pension' link
#    Then user is on the page with title 'Pensions summary' and URL is as expected
#    And user navigates to personal tax account
#    Then user clicks on 'Income tax' link
#    And user is on the page with title 'Check your Income Tax' and URL is as expected
#    And user navigates to personal tax account
#    And user clicks on 'Update your address' link
#    And user is on the page with title 'Your address' and URL is as expected
#
#  Scenario: Check that a High GG user(CL200) NOT IN SA regime is able to access the appropriate options on PTA
#    Given GG user 'Bob Jones' is logged into the service
#    And user goes through 2FA Journey
#    And user goes through IV Uplift Journey
#    And user Continues the journey to PTA
#    Then user clicks on 'Income tax' link
#    And user is on the page with title 'Check your Income Tax' and URL is as expected
#    And user navigates to personal tax account
#    And user clicks on 'Benefits and tax credits' link
#    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
#    And user navigates to personal tax account
#    Then user clicks on 'National Insurance' link
#    Then user is on the page with title 'National Insurance summary' and URL is as expected
#    And user navigates to personal tax account
#    Then user clicks on 'Pension' link
#    Then user is on the page with title 'Pensions summary' and URL is as expected
#    And user navigates to personal tax account
#    And user clicks on 'Update your address' link
#    And user is on the page with title 'Your address' and URL is as expected
#
#
#  Scenario: Check that a High GG user(CL200) IN SA regime is able to access the appropriate options on PTA
#    Given GG user 'Christopher Grantham' is logged into the service
#    And user goes through IV Uplift Journey
#    And user Continues the journey to PTA
#    And user clicks on 'View your Self Assessment' link
#    Then user is on the page with title 'Self Assessment summary' and URL is as expected
#    And user navigates to personal tax account
#    And user clicks on 'Go to your messages' link
#    Then user is on the page with title 'List of messages' and URL is as expected
#    And user navigates to personal tax account
#    And user clicks on 'Self Assessment' link
#    Then user is on the page with title 'Self Assessment summary' and URL is as expected
#    And user navigates to personal tax account
#    And user clicks on 'Benefits and tax credits' link
#    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
#    And user navigates to personal tax account
#    Then user clicks on 'National Insurance' link
#    Then user is on the page with title 'National Insurance summary' and URL is as expected
#    And user navigates to personal tax account
#    Then user clicks on 'Pension' link
#    Then user is on the page with title 'Pensions summary' and URL is as expected
#    And user navigates to personal tax account
#    And user clicks on 'Manage your paperless settings' link
#    And user is on the page with title 'Manage your paperless settings' and URL is as expected
#    Then user clicks on 'Income tax' link
#    And user is on the page with title 'Check your Income Tax' and URL is as expected
#    Then user clicks on 'your business tax account.' link
#    And user is on the page with title 'your business tax account' and URL is as expected
#
#
#
#  Scenario: Check that a Low GG user(CL50) NOT IN SA regime is able to access the appropriate options on PTA
#    Given GG user 'M Andrew' is logged into the service
#    And user goes through 2FA Journey
#    And user does not go through IV Uplift Journey
#    And user Continues the journey to PTA
#    And user clicks on 'Benefits and tax credits' link
#    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
#    And user navigates to personal tax account
#    Then user clicks on 'National Insurance' link
#    Then user is on the page with title 'National Insurance summary' and URL is as expected
#    And user navigates to personal tax account
#    Then user clicks on 'Pension' link
#    Then user is on the page with title 'Pensions summary' and URL is as expected
#    And user navigates to personal tax account
#    And user clicks on 'Update your address' link
#    And user is on the page with title 'Your address' and URL is as expected
#    Enter content of page
#    And user navigates to personal tax account
#    Then user clicks on 'Income tax' link
#    And user is on the page with title 'Check your Income Tax' and URL is as expected
#
#
#
#
#  Scenario: Check that a Low GG user(CL50) IN SA regime is able to access the appropriate options on PTA
#    Given GG user 'Christopher Grantham' is logged into the service
#    And user does not go through IV Uplift Journey
#    And user Continues the journey to PTA
#    And user clicks on 'View your Self Assessment' link
#    Then user is on the page with title 'Self Assessment summary' and URL is as expected
#    And user navigates to personal tax account
#    And user clicks on 'Go to your messages' link
#    Then user is on the page with title 'List of messages' and URL is as expected
#    And user navigates to personal tax account
#    And user clicks on 'Self Assessment' link
#    Then user is on the page with title 'Self Assessment summary' and URL is as expected
#    And user navigates to personal tax account
#    And user clicks on 'Benefits and tax credits' link
#    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
#    And user navigates to personal tax account
#    Then user clicks on 'National Insurance' link
#    Then user is on the page with title 'National Insurance summary' and URL is as expected
#    And user navigates to personal tax account
#    Then user clicks on 'Pension' link
#    Then user is on the page with title 'Pensions summary' and URL is as expected
#    And user navigates to personal tax account
#    And user clicks on 'Manage your paperless settings' link
#    And user is on the page with title 'Manage your paperless settings' and URL is as expected
#    Then user clicks on 'your business tax account.' link
#    And user is on the page with title 'your business tax account' and URL is as expected
#

#  Scenario: Check that a Verify user(CL500) IN SA regime is able to access the appropriate options on PTA
#    Given SA user 'Verify User1' is logged into the service
#    And user clicks on 'Benefits and tax credits' link
#    Then user is on the page with title 'Benefits and tax credits summary' and URL is as expected
#    And user navigates to personal tax account
#    Then user clicks on 'National Insurance' link
#    Then user is on the page with title 'National Insurance summary' and URL is as expected
#    And user navigates to personal tax account
#    Then user clicks on 'Pension' link
#    Then user is on the page with title 'Pensions summary' and URL is as expected
