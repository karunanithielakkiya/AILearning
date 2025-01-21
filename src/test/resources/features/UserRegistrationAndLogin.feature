Feature: User Registration and Login Functionality
   In order to access the platform
   As a new or existing user
   I want to register with a unique email and password and log in securely

Background:
   Given the user is on the registration page

Scenario: Registration with Unique Email and Password
   When the user enters a unique email address "unique@example.com" in the email field
   And the user enters a valid password "StrongPass123!" in the password field
   And the user clicks on the "Register" button
   Then the user should be successfully registered
   And a confirmation message should be displayed

Scenario: Password Strength Check
   When the user enters a unique email address "unique@example.com" in the email field
   And the user enters a weak password "12345" in the password field
   And the user clicks on the "Register" button
   Then the system should display a message indicating that the password is too weak
   And suggest using a stronger password

Scenario: Confirmation Email
   Given the user has successfully registered with a unique email and strong password
   When the user checks the email inbox for the confirmation email
   Then a confirmation email should be received
   And it should contain a link to verify the email address

Scenario: Login Attempt Limitation
   Given the user has an existing account
   When the user enters the correct email address "existing@example.com" in the login field
   And the user enters an incorrect password "WrongPass"
   And the user repeats entering an incorrect password 5 times
   Then the system should lock the account after a specified number of failed attempts
   And display a lockout message