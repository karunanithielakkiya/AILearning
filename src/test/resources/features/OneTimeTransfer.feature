Feature: One-Time Transfer Functionality
   In order to manage my finances efficiently
   As a bank account holder
   I want to perform one-time transfers through the banking system

Background:
   Given the user is logged into the system

Scenario: Verify One-Time Transfer Option is Available
   When the user navigates to the transfer section
   Then the one-time transfer option should be visible and selectable

Scenario: Verify Recurring Transfer Option is Not Available
   When the user navigates to the transfer section
   Then the recurring transfer option should not be visible or selectable

Scenario: Perform a One-Time Transfer
   When the user navigates to the transfer section
   And selects the one-time transfer option
   And enters the transfer details
   | Field          | Value          |
   | Amount         | 100            |
   | Recipient      | John Doe       |
   | Account Number | 123456789      |
   And confirms the transfer
   Then the transfer should be completed successfully
   And a confirmation message should be displayed

Scenario: Attempt to Set Up a Recurring Transfer
   When the user navigates to the transfer section
   And attempts to find and select a recurring transfer option
   Then the system should not allow the setup of recurring transfers
   And an appropriate message should be displayed if attempted