@suite @smoke
Feature: Test the exit survey
  As a user
  I want to be able to give my feedback to PTA
  So that PTA can iterate the service to meet my needs

  JIRA story history: MTA-1119, 1848

  Scenario: Navigate to the Sign out page and log back in
    Given User navigates to the PTA homepage
    When  clicks on the Sign out link
    Then  user is on the page with title 'You have signed out'and URL is as expected
    And   User sees content 'You can'
    And   User sees content 'if you need to.'
    When  User clicks the link 'sign in to your account again'
    Then  user is on the page with title 'Sign in'and URL is as expected


  Scenario: Navigate to the Sign out page and complete survey
    Given User navigates to the PTA homepage
    When  clicks on the Sign out link
    And   User sees sub heading 'Before you go, please answer some questions to help us improve your experience'
    //Q1
    And   User sees content 'Based on what you have done today, what do you need to do next? You can tick more than one box.'
    And   User sees checkbox with content 'Contact HMRC'
    And   User sees checkbox with content 'Find out more about tax online'
    And   User sees checkbox with content 'Speak to your employer'
    And   User sees checkbox with content 'Ask a friend or family member for advice'
    And   User sees checkbox with content 'Ask an agent or accountant for advice'
    And   User sees checkbox with content 'Nothing'
    And   User sees checkbox with content 'Don't know'
    And   User sees checkbox with content 'Other'
    And   User is able to select multiple checkboxes

    When  User selects the option 'Nothing' as well as any other checkbox
    Then  User sees the content 'XXXXXXXXXXXXXXXX'

    When  User selects the option 'Other'
    Then  User sees the text 'please state:'
    And   User sees a freetext box where they can enter text

    //Q2
    And   User sees the content 'How likely are you to recommend your tax account to your friends or family?'
    And   User sees radio button with the content 'Very likely'
    And   User sees radio button with the content 'Likely'
    And   User sees radio button with the content 'Not likely or unlikely'
    And   User sees radio button with the content 'Unlikely'
    And   User sees radio button with the content 'Very unlikely'


    //Q3
    And   User sees the content 'Overall, how do you feel about your experience using your tax account today?'
    And   User sees radio button with the content 'Very satisfied'
    And   User sees radio button with the content 'Satisfied'
    And   User sees radio button with the content 'Neither satisfied or dissatisfied'
    And   User sees radio button with the content 'Dissatisfied'
    And   User sees radio button with the content 'Very dissatisfied'

    //text box

    And   User sees the content 'Tell us how we can improve your experience'
    And   User sees the content 'Please do not include any personal or financial information, for example your National Insurance or credit card numbers.'
    And   User sees the content '1200 characters remaining'

    When  User enters 10 characters into the free text box
    Then  User will see the content '1190 characters remaining'
    When  User enters 1200 characters into the free text box
    Then  User will see the content '0 characters remaining'
    When  User enters 1201 characters into the free text box
    Then  User will see the content '-1 character remaining'








    
