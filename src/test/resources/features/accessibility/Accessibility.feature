@wip
  Feature: Accessibility
    As a user
  I want to use a site that is accessible
  So that I may use it even if I have disabilities

    Scenario: Test PTA for accessibility issues
      Given 'Jane Tidy' is logged in to PTA
      When Page is: 'Your account'
      Then Accessibility Tests are executed for the page
      And 'Jane Tidy' clicks on 'Personal details' link
      And Page is: 'Your personal details'
      And Accessibility Tests are executed for the page