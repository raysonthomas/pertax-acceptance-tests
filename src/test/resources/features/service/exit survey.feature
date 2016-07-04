@suite @smoke
Feature: Test the exit survey
  As a user
  I want to be able to give my feedback to PTA
  So that PTA can iterate the service to meet my needs

  JIRA story history: MTA-2051

  Scenario: Navigate to the Sign out page and log back in
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    When  user signs out
    Then  user is on the page with title 'Signed out' and URL is as expected
    And   user sees text 'You can' on the Exit page
    And   user sees text 'if you need to.' on the Exit page
    Then  user sees 'sign in to your account again' link on the page and its href is as expected

  Scenario: Navigate to the Sign out page and complete survey
    Given User with a PAYE account and SA account is logged into the service using gg
    And user completes 2FA Journey
    And user completes IV Uplift Journey
    And user Continues the journey to PTA
    When  user signs out
    Then  user sees text 'Before you go, please answer some questions to help us improve your experience' on the Exit page

#  //Q1
    And  user sees text 'Before using your personal tax account, were you going to phone or write to HMRC about your query?' on the Exit page
    And  user sees radio button 'Yes' under Before using your tax account
    And  user sees radio button 'No' under Before using your tax account

#  //Q2a
    When user selects yes radio button on 'before using your tax account' question
    And  user sees text 'After using your personal tax account, do you still need to phone or write to HMRC?' on the Exit page
    And  user sees radio button 'Yes' under still need to phone or write to HMRC
    And  user sees radio button 'No' under still need to phone or write to HMRC
    And  user sees radio button 'Don't know' under still need to phone or write to HMRC

#  //Q2b
    When user selects no radio button on 'before using your tax account' question
    And  user sees text 'After using your personal tax account, do you now need to phone or write to HMRC?' on the Exit page
    And  user sees radio button 'Yes' under now need to phone or write to HMRC
    And  user sees radio button 'No' under now need to phone or write to HMRC
    And  user sees radio button 'Don't know' under now need to phone or write to HMRC

#   Deselect buttons based on selection
    When  user selects yes radio button on 'before using your tax account' question
    And   user selects radio button 'Yes' under still need to phone or write to HMRC
    And   user selects no radio button on 'before using your tax account' question
    And   The selection Yes for still need to phone section is removed

#  //Q3
    And user sees text 'Based on what you have done today, do you need to do anything else? You can tick more than one box.' on the Exit page
    And user sees checkbox 'Don't need to do anything else'
    And user sees checkbox 'Find out more online'
    And user sees checkbox 'Speak to your employer'
    And user sees checkbox 'Ask a friend or family member for advice'
    And user sees checkbox 'Ask an agent or accountant for advice'
    And user sees checkbox 'Don't know'
    And user sees checkbox 'Other'
    And user selects other checkbox
    And user now sees the 'tellUsWhatYouNeedToDo' text box
    And user is able to select multiple checkboxes

#   //Q4
    And   user sees text 'How likely are you to recommend your personal tax account to your friends or family?' on the Exit page
    And   user sees the radio button 'Very likely'
    And   user sees the radio button 'Likely'
    And   user sees the radio button 'Not likely or unlikely'
    And   user sees the radio button 'Unlikely'
    And   user sees the radio button 'Very unlikely'

#    //Q5

    And   user sees text 'Overall, how do you feel about your experience using your personal tax account today?' on the Exit page
    And   user sees the radio button 'Very satisfied'
    And   user sees the radio button 'Satisfied'
    And   user sees the radio button 'Neither satisfied nor dissatisfied'
    And   user sees the radio button 'Dissatisfied'
    And   user sees the radio button 'Very dissatisfied'

#    //text box

    And   user sees text 'Tell us how we can improve your experience' on the Exit page
    And   user sees text '1200' on the Exit page
    And   user enters the 10 characters: '1234567891' into the free text box
    Then  user sees text '1190' on the Exit page

##  //Button

    And  user clicks on the Send feedback button on Exit survey page
    Then user is on the page with title 'Thanks for your feedback' and URL is as expected

