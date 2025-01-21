Feature: Transfer Date Entry
   In order to ensure accurate scheduling of transfers
   As a system user
   I want to validate the transfer date entry to comply with business rules

Background:
   Given the user is logged into the system
   And the user navigates to the transfer date entry screen

Scenario: Validate Transfer Date Entry within 6 Months
   When the user enters a date within 6 months from the current date
   And the user submits the date
   Then the system accepts the date without any error messages

Scenario: Validate Rejection of Past Dates
   When the user enters a past date
   And the user submits the date
   Then the system displays an error message indicating that past dates are not allowed

Scenario: Validate Rejection of Weekend Dates
   When the user enters a date that falls on a weekend
   And the user submits the date
   Then the system displays an error message indicating that weekend dates are not allowed

Scenario: Validate Rejection of Holiday Dates
   When the user enters a date that is a recognized holiday
   And the user submits the date
   Then the system displays an error message indicating that holiday dates are not allowed