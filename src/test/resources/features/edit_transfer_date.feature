Feature: Edit Transfer Date Functionality
   In order to make necessary adjustments to transfer details
   As a Branch User
   I want to edit the transfer date after submission

Background:
   Given the branch user is logged into the system
   And the user has submitted a transfer request

Scenario: Edit Transfer Date Successfully
   When the user navigates to the submitted transfer request
   And the user selects the option to edit the transfer date
   And the user enters a new valid transfer date
   And the user confirms the changes
   Then the system should update the transfer date successfully
   And display a confirmation message "Transfer date updated successfully"

Scenario: Edit Transfer Date with Invalid Date
   When the user navigates to the submitted transfer request
   And the user selects the option to edit the transfer date
   And the user enters an invalid transfer date
   And the user attempts to confirm the changes
   Then the system should display an error message "Invalid transfer date"
   But the transfer date should not be updated

Scenario: Edit Transfer Date with Past Date
   When the user navigates to the submitted transfer request
   And the user selects the option to edit the transfer date
   And the user enters a past date
   And the user attempts to confirm the changes
   Then the system should display an error message "Transfer date cannot be in the past"
   But the transfer date should not be updated

Scenario: Cancel Edit Transfer Date
   When the user navigates to the submitted transfer request
   And the user selects the option to edit the transfer date
   And the user decides to cancel the changes
   Then the system should retain the original transfer date
   And no changes should be made to the transfer request