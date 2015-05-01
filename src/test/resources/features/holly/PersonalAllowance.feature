@suite
Feature: Personal Allowance Alerts
  As an HMRC Customer with multiple incomes
  I should be notified about inefficient use of my Personal Allowance
  So that I can use it effectively

  JIRA story history: MTA-325

  Scenario: PTA alerts the user about underpaid tax (User with multiple incomes, one income uses up all Personal Allowance)
    Given 'Jim Ferguson' has a personal allowance of £'10000.00'
    And 'Jim Ferguson' works at 'Asda' Employer Ref: 'ABC' / Payroll ID: '123' as a 'cleaner'
    And PTA forecasts yearly income as £'6000.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '123' states cumulative 'monthly' earnings: April=£'500.00', May=£'1000.00', June=£'1500.00', July=£'2000.00'
    And FPS holds data stating that 'Asda' Employer Ref: 'ABC' has assigned 'Jim Ferguson' a tax code of '1000L' on Payroll ID: '123'
    And 'Jim Ferguson' works at 'Asda' Employer Ref: 'ABC' / Payroll ID: '456' as a 'shop floor worker'
    And PTA forecasts yearly income as £'3000.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '456' states cumulative 'monthly' earnings: April=£'250.00', May=£'500.00', June=£'750.00', July=£'1000.00'
    And FPS holds data stating that 'Asda' Employer Ref: 'ABC' has assigned 'Jim Ferguson' a tax code of 'BR' on Payroll ID: '456'
    And 'Jim Ferguson' works at 'Asda' Employer Ref: 'ABC' / Payroll ID: '789' as a 'security guard'
    And PTA forecasts yearly income as £'1000.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '789' states cumulative 'monthly' earnings: April=£'83.33', May=£'166.66', June=£'250.00', July=£'333.33'
    And FPS holds data stating that 'Asda' Employer Ref: 'ABC' has assigned 'Jim Ferguson' a tax code of 'BR' on Payroll ID: '789'
    When 'Jim Ferguson' is logged in to PTA
    Then PTA Alerts the user: 'You may be paying too little tax on your Asda income'

  Scenario: PTA alerts the user about underpaid tax (User with pension & multiple incomes, one income uses up all Personal Allowance)
    Given 'Jane Tidy' has a personal allowance of £'10600.00'
    And 'Jane Tidy' works at 'Asda' Employer Ref: 'ABC' / Payroll ID: '222' as a 'cleaner'
    And PTA forecasts yearly income as £'6000.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '222' states cumulative 'monthly' earnings: April=£'500.00', May=£'1000.00', June=£'1500.00', July=£'2000.00'
    And FPS holds data stating that 'Asda' Employer Ref: 'ABC' has assigned 'Jane Tidy' a tax code of '1060L' on Payroll ID: '222'
    And 'Jane Tidy' works at 'Asda' Employer Ref: 'ABC' / Payroll ID: '333' as a 'shop floor worker'
    And PTA forecasts yearly income as £'3000.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '333' states cumulative 'monthly' earnings: April=£'250.00', May=£'500.00', June=£'750.00', July=£'1000.00'
    And FPS holds data stating that 'Asda' Employer Ref: 'ABC' has assigned 'Jane Tidy' a tax code of 'BR' on Payroll ID: '333'
    And 'Jane Tidy' works at 'Asda' Employer Ref: 'ABC' / Payroll ID: '444' as a 'security guard'
    And PTA forecasts yearly income as £'1800.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '444' states cumulative 'monthly' earnings: April=£'150.00', May=£'300.00', June=£'450.00', July=£'600.00'
    And FPS holds data stating that 'Asda' Employer Ref: 'ABC' has assigned 'Jane Tidy' a tax code of 'BR' on Payroll ID: '444'
    When 'Jane Tidy' is logged in to PTA
    Then PTA Alerts the user: 'You may be paying too little tax on your Asda income'
