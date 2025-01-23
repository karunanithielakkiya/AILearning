Feature: Submit Transfer
   In order to process a transfer
   As a Branch User
   I want to submit the transfer after entering all required details

Background:
   Given the branch user is logged into the system
   And the branch user is on the transfer submission page

Scenario: Successful Transfer Submission
   When the branch user enters all required transfer details correctly
   And the branch user clicks on the submit button
   Then the transfer should be submitted successfully
   And the transfer should be visible on the Transfer Details screen

Scenario Outline: Transfer Submission with Missing Details
   When the branch user enters "<missing_detail>" incorrectly or leaves it blank
   And the branch user clicks on the submit button
   Then the transfer should not be submitted
   But the user should receive an error message "<error_message>"

Examples:
   | missing_detail | error_message                      |
   | account number | "Account number is required"       |
   | amount         | "Transfer amount is required"      |
   | recipient name | "Recipient name is required"       |

Scenario: Transfer Details Visibility
   When the branch user submits a transfer successfully
   Then the transfer should be visible on the Transfer Details screen
   And the transfer details should match the submitted information