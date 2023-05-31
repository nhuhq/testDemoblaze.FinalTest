Feature: Verify Add-to-cart function works properly
	Background:
		Given access the website
		
	Scenario: Verify user can add products to cart
		Given click the product, add to cart, get alert message then click Home button
		|1|
		|2|
		|3|
		|4|
		|5|
		|6|
		|7|
		|8|
		|9|
		
		And click Cart button
		Then confirm that products are added to cart with correct name and price
		|Samsung galaxy s6	|360|
		|Nokia lumia 1520		|820|
		|Nexus 6						|650|
		|Samsung galaxy s7	|800|
		|Iphone 6 32gb			|790|
		|Sony xperia z5			|320|
		|HTC One M9					|700|
		|Sony vaio i5				|790|
		|Sony vaio i7				|790|
		And confirm total price is "<price>"
		Examples:
		|price|
		|6020|
		
	Scenario: Verify user can add a product to cart
		Given navigate to the next page
		And click the product <order>
		When click Add-to-cart button
		And confirm the message "<alert message>" from website
		And click Cart button
		Then confirm that product is added to cart with correct name "<name>" and price "<price>"
		And confirm total price is "<price>"
		Examples: 
		|order|name								|alert message|price|
		|1		|Apple monitor 24		|Product added|400|
		|2		|MacBook air				|Product added|700|
		|3		|Dell i7 8gb				|Product added|700|
		|4		|2017 Dell 15.6 Inch|Product added|700|
		|5		|ASUS Full HD				|Product added|230|
		|6		|MacBook Pro				|Product added|1100|