Feature: Enter Transfer Amount
   In order to complete the transfer process accurately
   As a Branch User
   I want to enter both cash and securities amounts for a transfer

Background:
   Given the branch user is logged into the transfer system
   And the user is on the transfer entry page

Scenario: Enter Valid Cash and Securities Amounts
   When the user enters a valid cash amount of "1000"
   And the user enters a valid securities amount of "500"
   And the user submits the transfer details
   Then the system should accept the cash and securities amounts
   And the transfer should be processed successfully

Scenario Outline: Enter Invalid Cash or Securities Amounts
   When the user enters a cash amount of "<cash_amount>"
   And the user enters a securities amount of "<securities_amount>"
   And the user submits the transfer details
   Then the system should display an error message "<error_message>"
   But the transfer should not be processed

Examples:
   | cash_amount | securities_amount | error_message                     |
   | -100        | 500               | "Invalid cash amount"             |
   | 1000        | -50               | "Invalid securities amount"       |
   | -100        | -50               | "Invalid cash and securities amounts" |

Scenario: System Compatibility for Transfer Entry
   When the user tests the transfer entry functionality on different browsers and devices
   Then the transfer entry functionality should work consistently across platforms