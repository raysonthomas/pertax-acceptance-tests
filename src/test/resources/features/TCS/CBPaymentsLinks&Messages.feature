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
    And text 'If your child’s circumstances change' is visible on Child Benefit Page
    Then user sees text 'Child Benefit stops on 31 August on or after your child’s 16th birthday if they leave approved education or training.' is visible on Child Benefit Page
    Then user sees text 'Tell us if your child:' is visible on Child Benefit Page
    Then user sees text 'Apply for an extension' is visible on Child Benefit Page
    Then user sees text 'You could get Child Benefit for 20 weeks (called an ‘extension’) if your child leaves approved education or training and either:' is visible on Child Benefit Page
    Then user sees text 'registers with their local careers service, Connexions (or a similar organisation in Northern Ireland, the EU, Norway, Iceland or Liechtenstein)' is visible on Child Benefit Page
    Then user sees text 'signs up to join the armed forces' is visible on Child Benefit Page
    Then user sees text 'Other changes to your Child Benefit claim' is visible on Child Benefit Page
    Then user sees text 'Tell us if you need to:' is visible on Child Benefit Page
    Then user sees text 'to your circumstances' is visible on Child Benefit Page
    Then user sees text 'to act on your behalf for High Income Child Benefit Charge issues' is visible on Child Benefit Page
    Then user sees text 'if you or your partner are affected by the High Income Child Benefit Charge' is visible on Child Benefit Page
    Then user sees text 'If you don’t currently claim Child Benefit' is visible on Child Benefit Page
    Then user sees text If you don’t claim Child Benefit you normally qualify for it if you’re responsible for a child under 16 (or under 20 if they stay in approved education or training) and you live in the UK

    And   user sees 'stays in education or training'  link on the page and its href is as expected

    And   user sees 'later leaves education or training'  link on the page and the href is as expected
    And   user sees 'has any other change in their circumstances'  link on the page and the href is as expected
    And   user sees 'Apply for an extension'  link on the page and the href is as expected
    And   user sees 'report a change'  link on the page and the href is as expected
    And   user sees 'authorise a tax adviser or accountant '  link on the page and the href is as expected
    And   user sees 'stop or re-start your Child Benefit payments'  link on the page and the href is as expected
    And   user sees 'stays in education or training'  link on the page and the href is as expected
    And   user sees ' Check if you can claim Child Benefit (opens in new window)'  link on the page and the href is as expected

    And text 'Child Benefit forms' is visible on Child Benefit Page
    And text 'If you currently claim Child Benefit you may need to use one of these forms to tell us about changes.' is visible on Child Benefit Page
    And text 'Check if you can claim Child Benefit' is visible on Child Benefit Page
    And text 'If you don’t claim Child Benefit you normally qualify for it if you’re responsible for a child under 16 (or under 20 if they stay in approved education or training) and you live in the UK.' is visible on Child Benefit Page
    And user sees 'Check if you can claim Child Benefit (opens in new window)' link on the page and its href is as expected