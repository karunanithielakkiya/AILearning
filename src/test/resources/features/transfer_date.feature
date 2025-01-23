Feature: Enter Transfer Date
   In order to schedule future transfers without errors
   As a Branch User
   I want to enter a transfer date up to 6 months from the current date

Background:
   Given the user is logged into the system
   And the user is on the transfer date entry page

Scenario: Enter a valid transfer date within 6 months
   When the user enters a transfer date that is within 6 months from today
   And the date is a weekday and not a holiday
   Then the system should accept the transfer date
   And display a confirmation message "Transfer date accepted"

Scenario Outline: Enter an invalid transfer date
   When the user enters a transfer date "<transfer_date>"
   Then the system should display an error message "<error_message>"
   But the transfer date should not be accepted

Examples:
   | transfer_date | error_message                          |
   | 2023-01-01    | "Transfer date cannot be in the past"  |
   | 2023-12-25    | "Transfer date cannot be a holiday"    |
   | 2023-11-18    | "Transfer date cannot be a weekend"    |
   | 2024-05-01    | "Transfer date exceeds 6 months limit" |

Scenario: Verify system behavior on weekends and holidays
   When the user attempts to enter a transfer date on a weekend or holiday
   Then the system should prevent the entry
   And display a message "Please select a valid weekday that is not a holiday"

Scenario: Verify system behavior for past dates
   When the user attempts to enter a past transfer date
   Then the system should prevent the entry
   And display a message "Transfer date cannot be in the past"