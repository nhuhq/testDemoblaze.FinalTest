Feature: Verify Delete-from-cart function works properly
	Background:
		Given access the website
		
	Scenario: Verify user can delete items from cart that has mutiple items
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
		When remove products from cart
		|Samsung galaxy s6	|
		|Nokia lumia 1520		|
		|Nexus 6						|
		|Samsung galaxy s7	|
		|Iphone 6 32gb			|
		|Sony xperia z5			|
		|HTC One M9					|
		|Sony vaio i7				|
		Then confirm that that product is not in cart anymore
		|Samsung galaxy s6	|
		|Nokia lumia 1520		|
		|Nexus 6						|
		|Samsung galaxy s7	|
		|Iphone 6 32gb			|
		|Sony xperia z5			|
		|HTC One M9					|
		|Sony vaio i7				|
		And confirm total price is "<price>"
		Examples:
		|price|
		|790|
		
		
	Scenario: Verify user can delete one product from cart that has one product
		Given navigate to the next page
		And click the product <order>
		When click Add-to-cart button
		And confirm the message "<alert message>" from website
		And click Cart button
		And remove "<name>" from cart
		Then confirm that cart is empty
		And Total price is null
		Examples: 
		|order|name								|alert message|
		|1		|Apple monitor 24		|Product added|
		|2		|MacBook air				|Product added|
		|3		|Dell i7 8gb				|Product added|
		|4		|2017 Dell 15.6 Inch|Product added|
		|5		|ASUS Full HD				|Product added|
		|6		|MacBook Pro				|Product added|