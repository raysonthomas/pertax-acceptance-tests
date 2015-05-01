@suite
  Feature: Accessibility
    As a user
  I want to use a site that is accessible
  So that I may use it even if I have disabilities

    Scenario: Test PTA for accessibility issues
      Given 'Jim Ferguson' is logged in to PTA
      When Page is: '/pertax'
      Then Accessibility Tests are executed for the page
      And 'Jim Ferguson' clicks on 'Personal details' link
      And Page is: '/pertax/personalDetails'
      And Accessibility Tests are executed for the page