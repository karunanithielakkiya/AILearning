Feature: Account to Account (A2A) Transfers
   In order to facilitate seamless fund transfers between accounts
   As a user of the BAM system
   I want to ensure that the account details entered for A2A transfers are validated correctly

Background:
   Given the user is logged into the BAM system

Scenario: Successful Entry of FROM and TO Account Details
   When the user navigates to the A2A transfer section
   And the user enters a valid FROM account number
   And the user enters a valid TO account number
   And the user clicks on the "Submit" button
   Then the system accepts the account details and proceeds to the next step without errors

Scenario: Error Message for Invalid FROM Account
   When the user navigates to the A2A transfer section
   And the user enters an invalid FROM account number
   And the user enters a valid TO account number
   And the user clicks on the "Submit" button
   Then the system displays an error message indicating that the FROM account is invalid

Scenario: Error Message for Invalid TO Account
   When the user navigates to the A2A transfer section
   And the user enters a valid FROM account number
   And the user enters an invalid TO account number
   And the user clicks on the "Submit" button
   Then the system displays an error message indicating that the TO account is invalid

Scenario: Error Message for Both Invalid FROM and TO Accounts
   When the user navigates to the A2A transfer section
   And the user enters an invalid FROM account number
   And the user enters an invalid TO account number
   And the user clicks on the "Submit" button
   Then the system displays error messages indicating that both accounts are invalid