Feature: LeafTaps CreateLead Functionality

Background: 
Given Launch the browser
And Login to the LeafTaps application

Scenario: TC001_Create a Lead in the application - Positive

Given Click on CRM/SFA link
And Navigate to Leads tab
And Click on Create Lead button
And Enter Company name as 'Bank Of Baroda'
And Enter First name as 'Judy'
And Enter Last name as 'Jerry'
When Click on Submit button
Then View Lead page should be displayed