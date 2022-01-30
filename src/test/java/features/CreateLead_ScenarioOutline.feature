Feature: LeafTaps CreateLead Functionality

Scenario Outline: TC001_Create a Lead in the application - Positive

Given Launch the browser
And Login to the LeafTaps application
And Click on CRM/SFA link
And Navigate to Leads tab
And Click on Create Lead button
And Enter Company name as <companyName>
And Enter First name as <firstName>
And Enter Last name as <lastName>
When Click on Submit button
Then View Lead page should be displayed

Examples: 
|companyName|firstName|lastName     |
|Google     |Rekha    |Krishnankutty|
|TestLeaf   |Mayukh   |Karnan       |
|Amazon     |Deepthi  |Sathi        |


Scenario: TC002_Create a Lead in the application - Positive

Given Launch the browser
And Login to the LeafTaps application
And Click on CRM/SFA link
And Navigate to Leads tab
And Click on Create Lead button
And Enter Company name as 'Bank Of Baroda'
And Enter First name as 'Judy'
And Enter Last name as 'Jerry'
When Click on Submit button
Then View Lead page should be displayed