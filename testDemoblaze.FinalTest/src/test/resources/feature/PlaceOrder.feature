Feature: Verify Place order function works properly
	Background:
		Given access the website
		
	Scenario: Verify user can place order with mutiple products in cart
		Given navigate to the next page
		And click the product, add to cart, get alert message then click Home button
		|1|
		|2|
		|3|
		And click Cart button
		When click Place order button
		And confirm total price before order
		|Total: 1830|
		And input name, credit card to PO
		|abc|123|
		And submit order
		Then confirm the order information correct with "<message>", "<amount>", "<card>", "<name>"
		Examples:
		|message											|amount					|card							|name			|
		|Thank you for your purchase!	|Amount: 1830 USD|Card Number: 123	|Name: abc|
		
		
	Scenario: Verify user can place order with one product in cart
		Given click the product <order>
		And click Add-to-cart button
		And confirm the message "<alert message>" from website
		And click Cart button
		When click Place order button
		And input name, credit card to PO
		|abc|123|
		And submit order
		Then confirm the order information correct with "<message>", "<amount>", "<card>", "<name>"
		Examples: 
		|order|alert message|message											|amount					|card							|name			|
		|1		|Product added|Thank you for your purchase!	|Amount: 360 USD|Card Number: 123	|Name: abc|
		|7		|Product added|Thank you for your purchase!	|Amount: 700 USD|Card Number: 123	|Name: abc|
		
	Scenario: Verify user receives alert message when leaving compulsory fields blank
	Given click the product <order>
		And click Add-to-cart button
		And confirm the message "<alert message>" from website
		And click Cart button
		When click Place order button
		And input "<name>", "<country>", "<city>", "<card>", "<month>", "<year>" to PO
		And submit order
		Then confirm the message "<message>" from website
		Examples: 
		|order|alert message|message															|country|card	|name	|city	|month|year|
		|9		|Product added|Please fill out Name and Creditcard.	|abc		|			|abc	|			|10		|hai muoi|
		|2		|Product added|Please fill out Name and Creditcard.	|				|ab		|			|hcm	|ba		|		|
		|5		|Product added|Please fill out Name and Creditcard.	|				|			|			|			|			|		|
		