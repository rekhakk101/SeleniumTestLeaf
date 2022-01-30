Feature: Leaftaps Login functionality 

Scenario: TC001_Login to application-Positive 

	Given Launch the browser 
	And Load the url 
	And Enter the user name as DemoSalesManager 
	And Enter the password as crmsfa 
	When Click on Login button 
	Then Home page should be displayed