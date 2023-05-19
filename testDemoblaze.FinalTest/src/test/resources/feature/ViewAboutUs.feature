
Feature: Verify about us function works properly
	Background:
		Given access the website
		And click About us button
		
  Scenario: Verify website displays About-us box when clicking About us button
		Then confirm About us box is displayed
	
	
	Scenario: Verify user can be back to homepage when clicking Close button
		Given click Close button <number>
		Then confirm the url is "<url>"
		Examples:
		|number|url|
		|4|https://www.demoblaze.com/index.html|
	
	Scenario: Verify user can be back to homepage when clicking X button
		Given click X button <number>
		Then confirm the url is "<url>"
		Examples:
		|number|url|
		|4|https://www.demoblaze.com/index.html|