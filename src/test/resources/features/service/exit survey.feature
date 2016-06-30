@suite @smoke
Feature: Test the exit survey
  As a user
  I want to be able to give my feedback to PTA
  So that PTA can iterate the service to meet my needs

  JIRA story history: MTA-2051

  Scenario: Navigate to the Sign out page and log back in
    Given User with a PAYE account and SA account is logged into the service using gg
    When  user signs out
    Then  user is on the page with title 'Signed out' and URL is as expected
    And   user sees text 'You Can' on the Exit page
    And   user sees text 'if you need to.' on the Exit page
    Then  user clicks on 'sign in to your account again' link
    Then  user is on the page with title 'Sign in - Government Gateway' and URL is as expected

  Scenario: Navigate to the Sign out page and complete survey
    Given User with a PAYE account and SA account is logged into the service using gg
    When  user signs out
    Then  user sees text 'Before you go, please answer some questions to help us improve your experience' on the Exit page

#    //Q1
    And  user sees text 'Before using your tax account, were you going to phone or write to HMRC about your query?' on the Exit page
    And  user sees radio button 'Yes' with ID 'beforeUsingYourTaxAccount-1'
    And  user sees radio button 'No' with ID 'beforeUsingYourTaxAccount-0'

#  //Q2a
    When user selects yes radio button on 'before using your tax account' question
    And  user sees text 'After using your tax account, do you still need to phone or write to HMRC?' on the Exit page
    And  user now sees the 'do you still need to phone or write' question
    And  user sees radio button 'Yes' with ID 'beforeUsingYourTaxAccount-1'
    And  user sees radio button 'No' with ID 'stillReduceHMRCPhoneCalls-1'
    And  user sees radio button 'Don't Know' with ID 'stillReduceHMRCPhoneCalls-0'

#    //Q2b
    When user selects no radio button on 'before using your tax account' question
    And  user sees text 'After using your tax account, do you now need to phone or write to HMRC?' on the Exit page
    And  user now sees the 'do you now need to phone or write' question
    And  user sees radio button 'Yes' with ID 'nowReduceHMRCPhoneCalls-2'
    And  user sees radio button 'No' with ID 'nowReduceHMRCPhoneCalls-1'
    And  user sees radio button 'Don't Know' with ID 'nowReduceHMRCPhoneCalls-0'

#    Dont know how to test yet
#    When  User selects 'Yes' on Q1
#    And   User selects 'Yes' on Q2a and amends selection on Q1 to No
#    Then  The selction for Q2a should be removed

#    //Q3
    And user sees text 'Based on what you have done today, do you need to do anything else? You can tick more than one box.' on the Exit page
    And user sees checkbox 'Don't need to do anything else'
    And user sees checkbox 'Find out more online'
    And user sees checkbox 'Speak to your employer'
    And user sees checkbox 'Ask a friend or family member for advice'
    And user sees checkbox 'Ask an agent or accountant for advice'
    And user sees checkbox 'Don't know'
    And user sees checkbox 'Other'
    And user selects other checkbox
    And user now sees the 'Please state' text box

#    And   User is able to select multiple checkboxes

#    When  User selects the option 'Other'
#    Then  User sees the text 'please state:'
#    And   User sees a freetext box where they can enter text

#    //Q4
    And   user sees text 'How likely are you to recommend your tax account to your friends or family?' on the Exit page
    And   user sees the radio button 'Very likely'
    And   user sees the radio button 'Likely'
    And   user sees the radio button 'Not likely or unlikely'
    And   user sees the radio button 'Unlikely'
    And   user sees the radio button 'Very unlikely'

#    //Q5

    And   user sees text 'Overall, how do you feel about your experience using your tax account today?' on the Exit page
    And   user sees the radio button 'Very satisfied'
    And   user sees the radio button 'Satisfied'
    And   user sees the radio button 'Neither satisfied or dissatisfied'
    And   user sees the radio button 'Dissatisfied'
    And   user sees the radio button 'Very dissatisfied'

#    //text box

    And   user sees text 'Tell us how we can improve your experience' on the Exit page
    And   user sees text '1200 characters remaining' on the Exit page
    And   user enters the 10 characters: '1234567891' into the free text box
    Then  user sees text '1190' on the Exit page

#    //Button

    And  user clicks on the 'button' button
    Then user is on the page with title 'Thank you for your feedback'and URL is as expected








    
