Feature: Verify the login fuctionality
@smoke

Scenario: verify login success
 
Given Open the Browser
And Navigate to the url
Then Enter the valid username and password
And Click on Login
Then Verify login success

@smoke

Scenario: verify login unsuccess
 
Given Open the Browser
And Navigate to the url
Then Enter the invalid username and password
And Click on Login
Then Verify login unsuccess