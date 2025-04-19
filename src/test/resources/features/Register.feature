Feature: Registration Functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to register account page
When user enters the details into below fields
|firstname|Palak										   |
|lastname |Gupta										   |
|telephone|1234567890									 |
|password	|12345										   |
And user selects privacy policy 
And user clicks on continue button
Then  user account should be created successfully

Scenario: User creates an account with all fields
Given User navigates to register account page
When user enters the details into below fields
|firstname|Palak										   |
|lastname |Gupta										   |
|telephone|1234567890									 |
|password	|12345											 |
And user selects yes for newsletter 								   
And user selects privacy policy 
And user clicks on continue button
Then  user account should be created successfully

Scenario: User creates a duplicate account 
Given User navigates to register account page
When user enters the details into below fields with duplicate email
|firstname|Palak										   |
|lastname |Gupta										   |
|email    |guptapalak1411@gmail.com    |
|telephone|1234567890									 |
|password	|12345											 |
And user selects yes for newsletter 								   
And user selects privacy policy 
And user clicks on continue button
Then  user should get a proper warning about duplicate email

Scenario: User creates an account without filling any details
Given User navigates to register account page
When user dont enter any details into the fields
And user clicks on continue button
Then user should get a proper warning messages for  every mandatory fields




