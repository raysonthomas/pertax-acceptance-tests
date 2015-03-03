@wip
Feature:
  As an HMRC Customer with multiple incomes
  I should be notified about inefficient use of my Personal Allowance
  So that I can use it effectively

  JIRA story history: MTA-325

  Scenario Outline: Total Income is less than Personal Allowance
    Given '<user>' Personal Allowance equals '<personalAllowance>'
    And '<user>' works for First Employer <firstEmployerRef>','<firstPayrollID>', earning <firstAnnualEarnings> annually
    And First Employer has assigned a tax code of '<firstEmployerTaxCode>'
    And '<user>' works for Second Employer <secondEmployerRef>','<secondPayrollID>' earning <secondAnnualEarnings> annually
    And Second Employer has assigned a tax code of '<secondEmployerTaxCode>'
    And '<user>' works for Third Employer <thirdEmployerRef>','<thirdPayrollID>' earning <thirdAnnualEarnings> annually
    And Third Employer has assigned a tax code of '<thirdEmployerTaxCode>'
    When '<user>' is logged in to PTA
    Then PTA informs that tax is being paid on '<taxPaidOnValueCurrently>' but should be paying tax on '<taxPaidOnValueRecommended>'
  Examples:
    | user            | personalAllowance | firstEmployerRef | firstPayrollID | firstAnnualEarnings | firstEmployerTaxCode | secondEmployerRef | secondPayrollID | secondAnnualEarnings | secondEmployerTaxCode | thirdEmployerRef | thirdPayrollID | thirdAnnualEarnings | thirdEmployerTaxCode | taxPaidOnValueCurrently | taxPaidOnValueRecommended |
    | John Densmore   | 10000             | ???              | ???            | 5000                | 1000L                | ???               | ???             | 3000                 |                       | ???              | ???            | 1000                |                      | 4000                    | 0                         |
    | John Bucksworth | 10000             | ???              | ???            | 5000                | 500L                 | ???               | ???             | 3000                 | 500L                  | ???              | ???            | 1000                |                      | 1000                    | 0                         |

  Scenario Outline: Total Income is more than Personal Allowance
    Given '<user>' Personal Allowance equals '<personalAllowance>'
    And '<user>' works for First Employer <firstEmployerRef>','<firstPayrollID>', earning <firstAnnualEarnings> annually
    And First Employer has assigned a tax code of '<firstEmployerTaxCode>'
    And '<user>' works for Second Employer <secondEmployerRef>','<secondPayrollID>' earning <secondAnnualEarnings> annually
    And Second Employer has assigned a tax code of '<secondEmployerTaxCode>'
    And '<user>' works for Third Employer <thirdEmployerRef>','<thirdPayrollID>' earning <thirdAnnualEarnings> annually
    And Third Employer has assigned a tax code of '<thirdEmployerTaxCode>'
    When '<user>' is logged in to PTA
    Then PTA informs that tax is being paid on '<taxPaidOnValueCurrently>' but should be paying tax on '<taxPaidOnValueRecommended>'
  Examples:
    | user       | personalAllowance | firstEmployerRef | firstPayrollID | firstAnnualEarnings | firstEmployerTaxCode | secondEmployerRef | secondPayrollID | secondAnnualEarnings | secondEmployerTaxCode | thirdEmployerRef | thirdPayrollID | thirdAnnualEarnings | thirdEmployerTaxCode | taxPaidOnValueCurrently | taxPaidOnValueRecommended |
    | John Check | 10000             | ???              | ???            | 5000                | 1000L                | ???               | ???             | 5000                 |                       | ???              | ???            | 5000                |                      | 10000                   | 5000                      |

  Scenario Outline: Possible wrong tax code
    Given '<user>' Personal Allowance equals '<personalAllowance>'
    And '<user>' works for First Employer <firstEmployerRef>','<firstPayrollID>', earning <firstAnnualEarnings> annually
    And First Employer has assigned a tax code of '<firstEmployerTaxCode>'
    And '<user>' works for Second Employer <secondEmployerRef>','<secondPayrollID>' earning <secondAnnualEarnings> annually
    And Second Employer has assigned a tax code of '<secondEmployerTaxCode>'
    And '<user>' works for Third Employer <thirdEmployerRef>','<thirdPayrollID>' earning <thirdAnnualEarnings> annually
    And Third Employer has assigned a tax code of '<thirdEmployerTaxCode>'
    When '<user>' is logged in to PTA
    Then PTA informs that tax is being paid on '<taxPaidOnValueCurrently>' but should be paying tax on '<taxPaidOnValueRecommended>'
  Examples:
    | user       | personalAllowance | firstEmployerRef | firstPayrollID | firstAnnualEarnings | firstEmployerTaxCode | secondEmployerRef | secondPayrollID | secondAnnualEarnings | secondEmployerTaxCode | thirdEmployerRef | thirdPayrollID | thirdAnnualEarnings | thirdEmployerTaxCode | taxPaidOnValueCurrently | taxPaidOnValueRecommended |
    | John Check | 10000             | ???              | ???            | 416.66              | 1000L                | ???               | ???             | 250                  |                       | ???              | ???            | 83.33               |                      | 10000                   | 5000                      |




# need to discuss the below mentioned scenarios (monthly income ?)
  _____________________________________________________________________


  Scenario: three jobs same employer, month 1
    Given Fred Smith [NI number - in header] [tax year - in header] has a personal allowance of £10000
    And he works at Asda as a cleaner [payroll ID] earning £416.66 [taxable pay to date] [taxable pay in period] [benefits taxed via payroll] [tax week] [tax month]
    And he works at Asda as a shop floor worker [payroll ID] earning £250 [taxable pay to date] [taxable pay in period] [benefits taxed via payroll][tax week] [tax month]
    And he works at Asda as a security guard [payroll ID] earning £83.33 [taxable pay to date] [taxable pay in period] [benefits taxed via payroll][tax week] [tax month]
    And Asda have given him a tax code of 1000L [tax code - the tax code being applied for this employment] [tax code basis]
    When he logs into PTA
    Then PTA should tell him that he may be on the wrong tax code.

  Scenario: three jobs same employer, month 7
    Given Fred Smith [NI number - in header] [tax year - in header] has a personal allowance of £10000
    And he works at Asda as a cleaner [payroll ID] earning £2916.62 [taxable pay to date] [taxable pay in period] [benefits taxed via payroll] [tax week] [tax month]
    And he works at Asda as a shop floor worker [payroll ID] earning £1750 [taxable pay to date] [taxable pay in period] [benefits taxed via payroll][tax week] [tax month]
    And he works at Asda as a security guard [payroll ID] earning £583.33 [taxable pay to date] [taxable pay in period] [benefits taxed via payroll][tax week] [tax month]
    And Asda have given him a tax code of 1000L [tax code - the tax code being applied for this employment] [tax code basis]
    When he logs into PTA
    Then PTA should tell him that he may be on the wrong tax code.

  Scenario: three jobs different employers, month 1
    Given Fred Smith [NI number - in header] [tax year - in header] has a personal allowance of £10000
    And he works at Asda as a cleaner [payroll ID] earning £416.66 [taxable pay to date] [taxable pay in period] [benefits taxed via payroll] [tax week] [tax month]
    And he works at Tesco as a shop floor worker [payroll ID] earning £250 [taxable pay to date] [taxable pay in period] [benefits taxed via payroll][tax week] [tax month]
    And he works at Weatherspoons as a security guard [payroll ID] earning £83.33 [taxable pay to date] [taxable pay in period] [benefits taxed via payroll][tax week] [tax month]
    And Asda have given him a tax code of 1000L [tax code - the tax code being applied for this employment] [tax code basis]
    And Tesco have given him a tax code BR [tax code - the tax code being applied for this employment] [tax code basis]
    And Weatherspoons have given him a tax code BR [tax code - the tax code being applied for this employment] [tax code basis]
    When he logs into PTA
    Then PTA should tell him that he may be on the wrong tax code.

  Scenario: three jobs three employers, month 7
    Given Fred Smith [NI number - in header] [tax year - in header] has a personal allowance of £10000
    And he works at Asda as a cleaner [payroll ID] earning £2916.62 [taxable pay to date] [taxable pay in period] [benefits taxed via payroll] [tax week] [tax month]
    And Asda has given him a tax code of 1000L [tax code - the tax code being applied for this employment] [tax code basis]
    And he works at Tesco as a shop floor worker [payroll ID] earning £1750 [taxable pay to date] [taxable pay in period] [benefits taxed via payroll][tax week] [tax month]
    And Tesco Has given him a tax code of BR [tax code - the tax code being applied for this employment] [tax code basis]
    And he works at Weatherspoons as a security guard [payroll ID] earning £583.33 [taxable pay to date] [taxable pay in period] [benefits taxed via payroll][tax week] [tax month]
    And Weatherspoons have given him a tax code of BR [tax code - the tax code being applied for this employment] [tax code basis]
    When he logs into PTA
    Then PTA should tell him that he may be on the wrong tax code.