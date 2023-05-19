Feature: Verify log in function works properly
	Background:
		Given access the website
		And click Log in button

  Scenario: Verify that user will get the correct message from website with an unsuccessful login
		Given input "<username>", "<password>" to log in
		Then confirm the message "<alert message>" from website
		Examples:
		|username			|password	|alert message|
		|							|					|Please fill out Username and Password.|
		|a						|					|Please fill out Username and Password.|
		|hqntest1234	|					|Please fill out Username and Password.|
		|a						|abc			|Wrong password.|
		|A						|a				|Wrong password.|
		|hqntest1234	|a				|User does not exist.|
	
	Scenario: Verify that user logs in successfully with valid user and password
		Given input "<username>", "<password>" to log in
		Then confirm that the user was logged in with welcome status is "<status>"
		Examples:
		|username	|password	|status|
		|a				|a				|display: block;|
	
	Scenario: Verify user can be back to homepage when clicking Close button
		Given click Close button <number>
		Then confirm the url is "<url>"
		Examples:
		|number|url|
		|3|hhttps://www.demoblaze.com/index.html|
	
	Scenario: Verify user can be back to homepage when clicking X button
		Given click X button <number>
		Then confirm the url is "<url>"
		Examples:
		|number|url|
		|3|https://www.demoblaze.com/index.html|