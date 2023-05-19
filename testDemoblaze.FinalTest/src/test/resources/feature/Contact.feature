Feature: Verify contact function works properly
	Background:
		Given access the website
		And click contact button
		
	Scenario: Verify user can send message successfully
		Given input "<email>", "<name>", "<message>" and send message
		Then confirm the message "<alert message>" from website
		Examples: 
		|email			|name	|message|alert message|
		|						|			|				|Thanks for the message!!|
		|a@gmail.com|aa		|aa			|Thanks for the message!!|
	
	Scenario: Verify user can be back to homepage when clicking Close button
		Given click Close button <number>
		Then confirm the url is "<url>"
		Examples:
		|number|url|
		|1|https://www.demoblaze.com/index.html|
	
	Scenario: Verify user can be back to homepage when clicking X button
		Given click X button <number>
		Then confirm the url is "<url>"
		Examples:
		|number|url|
		|1|https://www.demoblaze.com/index.html|