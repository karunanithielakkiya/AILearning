Feature: Transfer Date Selection
   In order to schedule a transfer
   As a user
   I want to select a valid transfer date within the allowed range

Background:
   Given the user is on the transfer date selection page

Scenario: Select a transfer date up to 6 months from the current date
   When the user attempts to select a transfer date
   And the user selects a date within 6 months from the current date
   Then the date should be accepted as a valid transfer date

Scenario: Attempt to select a past date
   When the user attempts to select a transfer date
   And the user selects a past date
   Then the system should display an error message "Date cannot be in the past"
   But the date should not be accepted as a valid transfer date

Scenario: Attempt to select a weekend
   When the user attempts to select a transfer date
   And the user selects a weekend date
   Then the system should display an error message "Weekends are not allowed"
   But the date should not be accepted as a valid transfer date

Scenario: Attempt to select a holiday
   When the user attempts to select a transfer date
   And the user selects a holiday
   Then the system should display an error message "Holidays are not allowed"
   But the date should not be accepted as a valid transfer date

Scenario: Select a valid weekday within the allowed range
   When the user attempts to select a transfer date
   And the user selects a valid weekday within 6 months from the current date
   Then the date should be accepted as a valid transfer date