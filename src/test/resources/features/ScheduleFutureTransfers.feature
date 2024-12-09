Feature: Schedule Future Transfers
   In order to schedule future transfers without errors
   As a branch or home office user
   I want to enter a transfer date up to 6 months from the current date

Background:
   Given the user is logged into the system
   And the user is on the transfer scheduling page

Scenario: Valid Transfer Date Selection
   When the user selects a transfer date within 6 months from the current date
   And the selected date is a weekday and not a holiday
   Then the transfer date should be accepted
   And the user should see a confirmation message "Transfer date scheduled successfully"

Scenario Outline: Invalid Transfer Date Selection
   When the user selects a transfer date "<transfer_date>"
   Then the system should display an error message "<error_message>"
   But the transfer date should not be accepted

Examples:
   | transfer_date | error_message                              |
   | 2023-01-01    | "Transfer date cannot be in the past"      |
   | 2023-12-25    | "Transfer date cannot be a holiday"        |
   | 2023-11-18    | "Transfer date cannot be on a weekend"     |
   | 2024-07-01    | "Transfer date cannot be more than 6 months from today" |

Scenario: Transfer Date Selection on Different Devices
   When the user tests the transfer date selection functionality on different devices
   Then the transfer date selection should work consistently across all devices