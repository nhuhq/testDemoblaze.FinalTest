Feature: Verify when clicking "Cart" redirects to the correct URL
	Background:
		Given access the website
		And click Cart button
		
  Scenario: Verify when clicking "Cart" redirects to the correct URL
		Then confirm the url "<url>" is correct
		Examples:
		|url	|
		|https://www.demoblaze.com/cart.html|