Feature: Verify sign up function works properly
	Background:
		Given access the website
		And click Sign up button
		
  Scenario: Verify sign up function works properly
		Given input "<username>", "<password>" to register
		Then confirm the message "<alert message>" from website
		Examples:
		|username	|password	|alert message|
		|a				|a				|This user already exist.|
		|					|					|Please fill out Username and Password.|
		|a				|					|Please fill out Username and Password.|
		|hqntest12|					|Please fill out Username and Password.|
		|a				|abc			|This user already exist.|
		|hqntest11|abcd			|Sign up successful.|
	
	Scenario: Verify user can be back to homepage when clicking Close button
		Given click Close button <number>
		Then confirm the url is "<url>"
		Examples:
		|number|url|
		|2|https://www.demoblaze.com/index.html|
	
	Scenario: Verify user can be back to homepage when clicking X button
		Given click X button <number>
		Then confirm the url is "<url>"
		Examples:
		|number|url|
		|2|https://www.demoblaze.com/index.html|