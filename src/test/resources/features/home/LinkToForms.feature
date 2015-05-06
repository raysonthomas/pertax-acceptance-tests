@wip
Feature: Useful forms section is visible on the home page
  As a user
  I want easy navigation to useful forms
  So I spend less time finding them

  JIRA story history: none yet

  Scenario: Useful Forms section with a hyperlink is visible on the home page
    Given 'Jim Ferguson' is logged in to PTA
    And Page address path is: '/pertax'
    Then Useful Forms heading is: 'Useful forms'
    And Useful Forms content is: 'Depending on your circumstances you may need to use one of these forms.'
    And Useful Forms hyperlink that leads to hmrc-forms name is: 'HM Revenue and Customs forms'
    And Useful Forms hyperlink that leads to hmrc-forms destination is: 'gov.uk/government/collections/hmrc-forms'