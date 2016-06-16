@suite

Feature: Ability to create a printable NiNO confirmation letter
  As a user
  I want to be able to print confirmation of my Nino

  JIRA story history: MTA-1985


  Scenario: User checks National Insurance record
    Given User is logged into the service
    When  User click on the link 'National Insurance' on the PTA homepage
    Then  user sees the page heading 'National Insurance' and is on the correct URL
    And   user sees the content 'Your National Insurance number is'
    And   user sees their Nino
    And   user sees the subheading 'Check your National Insurance contributions'
    And   user sees the content 'See a record of the National Insurance contributions which count towards your State Pension and check for any gaps.'
    And   user sees the subheading 'Print proof of your National Insurance number'
    And   user sees the content 'If you start a new job your employer will ask for your National Insurance number. You may also need your National Insurance number at other times, for example if you apply for a student loan or for certain benefits.'

    When  User clicks the link 'Check your National Insurance contributions'
    Then  User is on page with heading 'Your National Insurance record' and the URL is as expected

  Scenario: User checks National Insurance record
    Given User is logged into the service
    When  User click on the link 'National Insurance' on the PTA homepage
    Then  User sees the page heading 'National Insurance' and is on the correct URL

    When  User clicks the link 'Print proof of your National Insurance number'
    Then  User is on page with content 'This number is unique to you and will not change. Please keep this number safe.' and the URL is as expected

    And   User sees their Nino
    And   User sees their residential address
    And   User sees their name and title
    And   User sees the date the form was created

    And   User will see the content 'XXXXXXXXXXXXXXXXXXXXX'


    When the user clicks print
    Then they will be in the browsers print function

    When the user clicks the back link
    Then Then  user sees the page heading 'National Insurance' and is on the correct URL






