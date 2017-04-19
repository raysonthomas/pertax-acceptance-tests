@suite @smoke
Feature: Test the exit survey


  # // New Exit Survey - All Only to test 'Give Feedback' Landing page. All other tests commented out.
    Scenario: Navigate to the Sign out page and complete survey
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    When user signs out
    Then user sees text 'Give feedback' on the page


#  As a user
#  I want to be able to give my feedback to PTA
#  So that PTA can iterate the service to meet my needs
#  JIRA story history: MTA-2051, MTA-2253, MTA-2625
#
#  Scenario: Navigate to the Sign out page and log back in
#    Given User with a PAYE account and SA account is logged into the service using gg
#    And user completes 2FA Journey
#    And user completes IV Uplift Journey
#    And user Continues the journey to PTA
#    When  user signs out
#    Then  user is on the page with title 'Signed out' and URL is as expected
#    And   user sees text 'You can' on the Exit page
#    And   user sees text 'if you need to.' on the Exit page
#    Then  user sees 'sign in to your account again' link on the page and its href is as expected
#
#  Scenario: Navigate to the Sign out page and complete survey
#    Given User with a PAYE account and SA account is logged into the service using gg
#    And user completes 2FA Journey
#    And user completes IV Uplift Journey
#    And user Continues the journey to PTA
#    When  user signs out
#    Then  user sees text 'Before you go, please answer some questions to help us improve your experience' on the Exit page
##    Satisfaction question
#
#    And   user sees text 'how do you feel about your experience' on the Exit page
#    And   user sees the radio button 'Very satisfied'
#    And   user sees the radio button 'Satisfied'
#    And   user sees the radio button 'Neither satisfied nor dissatisfied'
#    And   user sees the radio button 'Dissatisfied'
#    And   user sees the radio button 'Very dissatisfied'
#
##  Get help question
#    And user sees text 'Did you get help going online from any of the following today?' on the Exit page
#    And user sees checkbox 'Friend or family member'
#    And user sees checkbox 'Someone at HMRC'
#    And user sees checkbox 'Citizens Advice'
#    And user sees checkbox 'A charity'
#    And user sees checkbox 'Other'
#    And user sees checkbox 'I didn't get help'
#    And user sees checkbox 'Other'
#    And user clicks checkbox 'other'
#    And user now sees the 'tellUsWhatYouNeedToDo' text box
#    And user is able to select multiple checkboxes
#    When  user clicks checkbox 'friendOrFamily'
#    And  user clicks checkbox 'didntNeedHelp'
#    Then Friend or Family is unselected
#
##  //This functionality should apply to all the first 5 checkboxes.
##  //phone or write question
#    And  user sees text 'Before using your personal tax account, were you going to phone or write to HM Revenue and Customs (HMRC) about your query?' on the Exit page
#    And  user sees radio button 'Yes' under Before using your tax account
#    And  user sees radio button 'No' under Before using your personal tax account
#
##  //Still need to phone question
#
#    When user selects yes radio button on 'before using your tax account' question
#    And  user sees text 'After using your personal tax account, do you still need to phone or write to HMRC?' on the Exit page
#    And  user sees radio button 'Yes' under still need to phone or write to HMRC
#    And  user sees radio button 'No' under still need to phone or write to HMRC
#    And  user sees radio button 'Don't know' under still need to phone or write to HMRC
#
##  //Now need to phone question
#
#    When user selects no radio button on 'before using your tax account' question
#    And  user sees text 'After using your personal tax account, do you now need to phone or write to HMRC?' on the Exit page
#    And  user sees radio button 'Yes' under now need to phone or write to HMRC
#    And  user sees radio button 'No' under now need to phone or write to HMRC
#    And  user sees radio button 'Don't know' under now need to phone or write to HMRC
#
##  //Deselect buttons based on selection
#
#    When  user selects yes radio button on 'before using your tax account' question
#    And   user selects radio button 'Yes' under still need to phone or write to HMRC
#    And   user selects no radio button on 'before using your tax account' question
#    And   The selection Yes for still need to phone section is removed
#
##   //text box
#
#    And   user sees text 'Tell us how we can improve your experience' on the Exit page
#    And   user sees text '1200' on the Exit page
#    And   user enters the 10 characters: '1234567891' into the free text box
#    Then  user sees text '1190' on the Exit page
#
##  //Button
#
#    And  user clicks on the Send feedback button on Exit survey page
#    Then user is on the page with title 'Thanks for your feedback' and URL is as expected
#
#
#

