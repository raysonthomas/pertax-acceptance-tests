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




# need to discuss other scenarios (monthly income ?)