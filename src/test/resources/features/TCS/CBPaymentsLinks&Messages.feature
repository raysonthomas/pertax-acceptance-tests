#@suite
Feature:
  As a parent
  I need to tell HMRC if i am still eligible for child benefit payments
  So that I continue to receive my benefit


  Scenario: when a gg user has navigates to the child benefit page they should see the correct links and content
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    When user is on the page with title 'Personal tax account' and URL is as expected
    Then Breadcrumb is: ''
    And user sees 'Child Benefit forms' link on the page and its href is as expected
    And user sees text 'Tell us about changes that may affect your Child Benefit.' on the home page


    Then user clicks on 'Child Benefit forms' link
    Then user is on the page with title 'Report changes that affect your Child Benefit' and URL is as expected
    And Breadcrumb is: 'Account home'
    And text 'Child Benefit forms' is visible on Child Benefit Page
    And text 'If you currently claim Child Benefit you may need to use one of these forms to tell us about changes.' is visible on Child Benefit Page
    And text 'Check if you can claim Child Benefit' is visible on Child Benefit Page
    And text 'If you don’t claim Child Benefit you normally qualify for it if you’re responsible for a child under 16 (or under 20 if they stay in approved education or training) and you live in the UK.' is visible on Child Benefit Page
    And user sees 'Check if you can claim Child Benefit (opens in new window)' link on the page and its href is as expected