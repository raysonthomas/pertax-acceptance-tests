@wip
Feature:
  As an HMRC Customer with multiple incomes
  I should be notified about inefficient use of my Personal Allowance
  So that I can use it effectively

  JIRA story history: MTA-325

  Scenario: Three jobs with the same employer
    Given 'Fred Smith' has a Personal Allowance of '£10000'
    And 'Fred Smith' works at L&M (ref: 'LM50') on payroll ID: '150' earning an estimated '£5000.00' per year
    And 'Fred Smith' works at L&M (ref: 'LM50') on payroll ID: '235' earning an estimated '£3000.00' per year
    And 'Fred Smith' works at L&M (ref: 'LM50') on payroll ID: '460' earning an estimated '£1000.00' per year
    And The Employer has given him a tax code of '1000L' on his payroll ID: '150'
    When 'Fred Smith' is logged in to PTA
    Then PTA informs that tax is being paid on '£4000.00' but should be paying tax on '£0.00'

  Scenario: Three jobs with different employers
    Given 'Jack Daniel' has a Personal Allowance of '£10000'
    And 'Jack Daniel' works at MSI (ref: 'MSI20') on payroll ID: '222' earning an estimated '£5000.00' per year
    And 'Jack Daniel' works at KLM (ref: 'KLM40') on payroll ID: '333' earning an estimated '£3000.00' per year
    And 'Jack Daniel' works at ACN (ref: 'ACN60') on payroll ID: '444' earning an estimated '£1000.00' per year
    And The Employer has given him a tax code of '1000L' on his payroll ID: '222'
    When 'Jack Daniel' is logged in to PTA
    Then PTA informs that tax is being paid on '£4000.00' but should be paying tax on '£0.00'

  Scenario: Unused personal Allowance - TMAC
    Given Fred Smith has a personal allowance of £10000
    And he works at Tesco (ref ABC) on payroll ID 123 as a cleaner earning an estimated £3k per year
    And he works at Molly Maid (ref DEF) on payroll ID 123 as a shop floor worker earning an estimated £3k per year
    And he works at Spar (ref GHI) on payroll ID 123 as a security guard earning an estimated £3k per year
    Then PTA should tell him that he may have unused personal allowance - Do you wish to transfer to your spouse?

  Scenario: Earnings over £10000 - excess Personal Allowance
    Given Fred Smith has a personal allowance of £10000
    And he works at Tesco (ref ABC) on payroll ID 123 as a cleaner earning an estimated £4k per year
    And he works at Molly Maid (ref DEF) on payroll ID 123 as a shop floor worker earning an estimated £4k per year
    And he works at Spar (ref GHI) on payroll ID 123 as a security guard earning an estimated £3k per year
    Then PTA should tell him that he may have over his personal allowance (underpaid tax?)
