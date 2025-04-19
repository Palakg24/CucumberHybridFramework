Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And user clicks on Login button
Then user should get successfully logged in
Examples:
|username                |password|
|guptapalak1411@gmail.com|12345   |
|palak.g@gmail.com       |12345   |
|gupta.p@gmail.com       |12345   |


Scenario: Login with invalid credentials
Given User navigates to login page
When user enters invalid email address into email field
And user enters invalid password "1234567890" into password field
And user clicks on Login button
Then user should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "guptapalak1411@gmail.com" into email field
And user enters invalid password "1234567890" into password field
And user clicks on Login button
Then user should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When user enters invalid email address into email field
And User enters valid password "12345" into password field
And user clicks on Login button
Then user should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When user dont enter any email address into email field
And user dont enter password into password field
And user clicks on Login button
Then user should get a proper warning message about credentials mismatch
