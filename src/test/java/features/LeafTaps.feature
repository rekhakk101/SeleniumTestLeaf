Feature: LeafTaps Functionalities 

Scenario: TC001_Create Lead 

	Given Navigate to Leads tab 
	And Click on Create Lead button 
	And Enter Company name as 'Bank Of Baroda' 
	And Enter First name as 'Judy' 
	And Enter Last name as 'Jerry' 
	When Click on Submit button 
	Then View Lead page should be displayed 
	
Scenario: TC002_Delete Lead

	Given Navigate to Leads tab 
	And Click on Find Leads button 
	And Click on Phone tab and Enter Phone number as '8' 
	And Click on Find Leads
	And Click on fisrt appeared Lead from the list
	When Click on Delete button 
	Then My Leads page should be displayed 
	
Scenario: TC003-Duplicate Lead
	Given Navigate to Leads tab 
	And Click on Find Leads button 
	And Click on Email tab and Enter Email ID as 'babu@testleaf.com'
	And Click on Find Leads
	And Click on fisrt appeared Lead from the list
	And Click on Duplicate Lead button
	When Click on Create Lead 
	Then View Lead page should be displayed 

Scenario: TC004_Edit Lead
	Given Navigate to Leads tab 
	And Click on Find Leads button
	And Enter First name as 'b'
	And Click on fisrt appeared Lead from the list
	And Click on Edit button
	And Clear Company name and Enter a new Company name
	When Click on Update
	Then View Lead page should be displayed 