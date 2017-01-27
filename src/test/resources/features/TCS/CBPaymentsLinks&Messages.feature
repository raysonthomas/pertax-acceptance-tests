@suite
Feature:
  As a parent
  I need to tell HMRC if i am still eligible for child benefit payments
  So that I continue to receive my benefit

  JIRA story history : MTA-2498

  Scenario: when a gg user has navigates to the child benefit page they should see the correct links and content
    Given A user with a PAYE account, but no SA account is logged into the service using verify
    When user is on the page with title 'Personal tax account' and URL is as expected
    Then user clicks on 'Child Benefit' link
    Then user is on the page with title 'Report changes that affect your Child Benefit' and URL is as expected
    And Breadcrumb is: 'Account home'
    And text 'Report changes that affect your Child Benefit' is visible on Child Benefit Page
    And user sees text 'If your child's circumstances change' on the CB page
    Then user sees text 'Child Benefit stops on 31 August on or after your child's 16th birthday if they leave approved education or training.' on the CB page
    Then user sees text 'Tell us if your child:' on the CB page
    Then user sees text 'Apply for an extension' on the CB page
    Then user sees text 'You could get Child Benefit for 20 weeks (called an 'extension') if your child leaves approved education or training and either:' on the CB page
    Then user sees text 'registers with their local careers service, Connexions (or a similar organisation in Northern Ireland, the EU, Norway, Iceland or Liechtenstein)' on the CB page
    Then user sees text 'signs up to join the armed forces' on the CB page
    Then user sees text 'Other changes to your Child Benefit claim' on the CB page
    Then user sees text 'Tell us if you need to:' on the CB page
    Then user sees text 'to your circumstances' on the CB page
    Then user sees text 'to act on your behalf for High Income Child Benefit Charge issues' on the CB page
    Then user sees text 'if you or your partner are affected by the High Income Child Benefit Charge' on the CB page
    Then user sees text 'If you don't currently claim Child Benefit' on the CB page
    And user sees text 'stays in education or training' on the CB page
    And user sees 'stays in education or training' link on the page and its href is as expected
    And user sees text 'later leaves education or training' on the CB page
    And user sees 'later leaves education or training' link on the page and its href is as expected
    And user sees text 'has any other change in their circumstances' on the CB page
    And user sees 'has any other change in their circumstances' link on the page and its href is as expected
    And user sees text 'Apply for an extension' on the CB page
    And user sees 'Apply for an extension' link on the page and its href is as expected
    And user sees text 'report a change' on the CB page
    And user sees 'report a change' link on the page and its href is as expected
    And user sees text 'authorise a tax adviser or accountant' on the CB page
    And user sees text 'stop or re-start your Child Benefit payments' on the CB page
    And user sees 'stop or re-start your Child Benefit payments' link on the page and its href is as expected
    And user sees text 'If you don't currently claim Child Benefit' on the CB page
    And user sees text 'If you don't claim Child Benefit you normally qualify for it if you're responsible for a child under 16 (or under 20 if they stay in approved education or training) and you live in the UK.' on the CB page
    And user sees text 'Check if you can claim Child Benefit (opens in new window)' on the CB page
    And user sees 'Check if you can claim Child Benefit (opens in new window)' link on the page and its href is as expected