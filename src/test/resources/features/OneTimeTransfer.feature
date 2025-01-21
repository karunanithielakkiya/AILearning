Feature: One-Time Transfer Functionality
   In order to manage my finances efficiently
   As a bank account holder
   I want to perform one-time transfers with ease and accuracy

Background:
   Given the user is logged in
   And the user is on the transfer page

Scenario: Perform One-Time Transfer with Valid Details
   When the user selects 'One-Time Transfer' option
   And enters valid 'FROM' account details
   And enters valid 'TO' account details
   And enters a valid transfer amount
   And selects a valid transfer date
   And clicks on the "Submit" button
   Then the transfer should be successfully submitted
   And a confirmation message should be displayed

Scenario: Perform One-Time Transfer with Invalid Amount
   When the user selects 'One-Time Transfer' option
   And enters valid 'FROM' account details
   And enters valid 'TO' account details
   And enters an invalid transfer amount
   And selects a valid transfer date
   And clicks on the "Submit" button
   Then an error message should be displayed indicating the invalid amount
   But the transfer should not be submitted

Scenario: Perform One-Time Transfer with Past Date
   When the user selects 'One-Time Transfer' option
   And enters valid 'FROM' account details
   And enters valid 'TO' account details
   And enters a valid transfer amount
   And selects a past transfer date
   And clicks on the "Submit" button
   Then an error message should be displayed indicating the invalid date selection
   But the transfer should not be submitted

Scenario: Cancel One-Time Transfer
   Given the user has initiated a one-time transfer
   When the user navigates to the transfer details page
   And clicks on the "Cancel Transfer" button
   Then the transfer should be successfully canceled
   And a confirmation message should be displayed