Feature: Verify log in function works properly
	Background:
		Given access the website
		And click Log in button
	Scenario: Verify that user can log out after logging in
		Given input "<username>", "<password>" to log in
		And click Log out button
		Then confirm that the user was logged out successfully with welcome status is "<status>"
		Examples:
		|username	|password	|status|
		|a				|a				|display: none;|