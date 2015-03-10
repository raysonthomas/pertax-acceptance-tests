@wip
Feature:
  As an HMRC Customer with multiple incomes
  I should be notified about inefficient use of my Personal Allowance
  So that I can use it effectively

  JIRA story history: MTA-325

  Scenario: PTA alerts about unused Personal Allowance (User with multiple incomes, one income uses up all Personal Allowance)
    Given 'Fred Smith' has a personal allowance of £'10000.00'
    And 'Fred Smith' works at 'Asda' (Employer Ref: 'ABC') on Payroll ID: '123' as a 'cleaner'
    And PTA forecasts yearly income as £'6000.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '123' stating cumulative 'monthly' earnings: April=£'500.00', May=£'1000.00', June=£'1500.00', July=£'2000.00'
    And FPS holds data stating that 'Asda' (Employer Ref: 'ABC') has assigned 'Fred Smith' a tax code of '1000L' on Payroll ID: '123'
    And 'Fred Smith' works at 'Asda' (Employer Ref: 'ABC') on Payroll ID: '456' as a 'shop floor worker'
    And PTA forecasts yearly income as £'3000.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '456' stating cumulative 'monthly' earnings: April=£'250.00', May=£'500.00', June=£'750.00', July=£'1000.00'
    And FPS holds data stating that 'Asda' (Employer Ref: 'ABC') has assigned 'Fred Smith' a tax code of 'BR' on Payroll ID: '456'
    And 'Fred Smith' works at 'Asda' (Employer Ref: 'ABC') on Payroll ID: '789' as a 'security guard'
    And PTA forecasts yearly income as £'1000.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '789' stating cumulative 'monthly' earnings: April=£'83.33', May=£'166.66', June=£'250.00', July=£'333.33'
    And FPS holds data stating that 'Asda' (Employer Ref: 'ABC') has assigned 'Fred Smith' a tax code of 'BR' on Payroll ID: '789'
    When 'Fred Smith' logs into PTA
    Then PTA Alerts the user about his unused Personal Allowance of £'4000.00'

  Scenario: PTA alerts about unused Personal Allowance (User with pension & multiple incomes, one income uses up all Personal Allowance)
    Given 'Fred Smith' has a personal allowance of £'10600.00'
    And 'Fred Smith' works at 'Asda' (Employer Ref: 'ABC') on Payroll ID: '222' as a 'cleaner'
    And PTA forecasts yearly income as £'6000.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '222' stating cumulative 'monthly' earnings: April=£'500.00', May=£'1000.00', June=£'1500.00', July=£'2000.00'
    And FPS holds data stating that 'Asda' (Employer Ref: 'ABC') has assigned 'Fred Smith' a tax code of '1060L' on Payroll ID: '222'
    And 'Fred Smith' works at 'Asda' (Employer Ref: 'ABC') on Payroll ID: '333' as a 'shop floor worker'
    And PTA forecasts yearly income as £'3000.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '333' stating cumulative 'monthly' earnings: April=£'250.00', May=£'500.00', June=£'750.00', July=£'1000.00'
    And FPS holds data stating that 'Asda' (Employer Ref: 'ABC') has assigned 'Fred Smith' a tax code of 'BR' on Payroll ID: '333'
    And 'Fred Smith' works at 'Asda' (Employer Ref: 'ABC') on Payroll ID: '444' as a 'security guard'
    And PTA forecasts yearly income as £'1800.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '444' stating cumulative 'monthly' earnings: April=£'150.00', May=£'300.00', June=£'450.00', July=£'600.00'
    And FPS holds data stating that 'Asda' (Employer Ref: 'ABC') has assigned 'Fred Smith' a tax code of 'BR' on Payroll ID: '444'
    When 'Fred Smith' logs into PTA
    Then PTA Alerts the user about his unused Personal Allowance of £'4600'

  Scenario: PTA does not display alerts about unused Personal Allowance (User has multiple incomes. The inconsistent income (can't forecast) uses up all Personal Allowance)
    Given 'Fred Smith' has a personal allowance of £'10000.00'
    And 'Fred Smith' works at 'Asda' (Employer Ref: 'ABC') on Payroll ID: '200' as a 'cleaner'
    And PTA is unable to forecast yearly income because FPS data for Employer Ref: 'ABC' / Payroll ID: '200' which states cumulative 'monthly' earnings as: April=£'500.00', May=£'720.00', June=£'1820.00', July=£'2132.00' is unstable
    And FPS holds data stating that 'Asda' (Employer Ref: 'ABC') has assigned 'Fred Smith' a tax code of '1000L' on Payroll ID: '200'
    And 'Fred Smith' works at 'Asda' (Employer Ref: 'ABC') on Payroll ID: '300' as a 'shop floor worker'
    And PTA forecasts yearly income as £'3000.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '300' states cumulative 'monthly' earnings as: April=£'250.00', May=£'500.00', June=£'750.00', July=£'1000.00'
    And FPS holds data stating that 'Asda' (Employer Ref: 'ABC') has assigned 'Fred Smith' a tax code of 'BR' on Payroll ID: '300'
    And 'Fred Smith' works at 'Asda' (Employer Ref: 'ABC') on Payroll ID: '400' as a 'security guard'
    And PTA forecasts yearly income as £'1000.00' because FPS data for Employer Ref: 'ABC' / Payroll ID: '400' stating cumulative 'monthly' earnings: April=£'83.33', May=£'166.67', June=£'250.00', July=£'333.33'
    And FPS holds data stating that 'Asda' (Employer Ref: 'ABC') has assigned 'Fred Smith' a tax code of 'BR' on Payroll ID: '400'
    When 'Fred Smith' logs into PTA
    Then PTA does not display alerts about unused Personal Allowance
