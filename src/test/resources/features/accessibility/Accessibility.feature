@axs
  Feature: Accessibility
    As a user
  I want to use a site that is accessible
  So that I may use it even if I have disabilities

    Scenario: Test PTA for accessibility issues
      Given user 'Jim Ferguson' is logged into the service
      Then Accessibility Tests are executed for the page
      And 'Jim Ferguson' clicks on 'Personal details' link
      And Accessibility Tests are executed for the page