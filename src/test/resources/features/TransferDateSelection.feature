Feature: Transfer Date Selection
   In order to schedule transfers efficiently
   As a user
   I want to select valid transfer dates within the system

Background:
   Given the user is logged into the system

Scenario: Select a Valid Transfer Date
   When the user navigates to the transfer date selection screen
   And the user selects a date within the next 6 months
   Then the system allows the selection of the date

Scenario: Prevent Selection of Past Dates
   When the user navigates to the transfer date selection screen
   And the user attempts to select a past date
   Then the system does not allow the selection of past dates
   And displays an appropriate error message

Scenario: Prevent Selection of Weekends
   When the user navigates to the transfer date selection screen
   And the user attempts to select a weekend date
   Then the system does not allow the selection of weekend dates
   And displays an appropriate error message

Scenario: Prevent Selection of Holidays
   When the user navigates to the transfer date selection screen
   And the user attempts to select a holiday date
   Then the system does not allow the selection of holiday dates
   And displays an appropriate error message