Feature: Cancel Transfer Functionality
   In order to stop a transfer process if needed
   As a Branch User
   I want to cancel the transfer using a cancel button

Background:
   Given the branch user is logged into the system
   And the branch user has initiated a transfer

Scenario: Successful Transfer Cancellation
   When the branch user navigates to the transfer details page
   And the branch user clicks on the cancel button
   Then the system should display a confirmation prompt
   And the branch user confirms the cancellation
   Then the transfer should be successfully cancelled
   And the system should display a cancellation confirmation message

Scenario: Cancel Button Visibility
   When the branch user navigates to the transfer details page
   Then the cancel button should be visible and enabled

Scenario: Cancel Transfer Without Confirmation
   When the branch user navigates to the transfer details page
   And the branch user clicks on the cancel button
   But the branch user dismisses the confirmation prompt
   Then the transfer should not be cancelled
   And the system should display the transfer details page

Scenario: Cancel Transfer After Transfer Completion
   When the branch user navigates to the transfer details page of a completed transfer
   Then the cancel button should not be visible
   And the system should display a message "Transfer already completed, cancellation not possible"