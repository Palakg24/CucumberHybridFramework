Feature: Search functionality

Scenario: User searches for a valid product
Given user opens the application
When user enters valid product "HP" into search box field
And user clicks on search button
Then user should get valid product displayed in search results

Scenario: User searches for an invalid product
Given user opens the application
When user enters invalid product "Honda" into search box field
And user clicks on search button
Then user should get a message about no product matching

Scenario: User searches without any product
Given user opens the application
When user dont enters any product name into search box field
And user clicks on search button
Then user should get a message about no product matching