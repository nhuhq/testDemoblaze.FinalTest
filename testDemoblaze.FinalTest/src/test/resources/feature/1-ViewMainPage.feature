Feature: Verify product information is displayed correctly on main page
	Scenario: Verify product infomation is displayed correctly on first page of main page
		Given access the website
		Then The website displays product <order> information correct with "<name>","<price>","<description>"
	Examples: 
		|order|name								|price|description|
		|1		|Samsung galaxy s6	|$360|The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage cannot be expanded.|
		|2		|Nokia lumia 1520		|$820|The Nokia Lumia 1520 is powered by 2.2GHz quad-core Qualcomm Snapdragon 800 processor and it comes with 2GB of RAM.|
		|3		|Nexus 6						|$650|The Motorola Google Nexus 6 is powered by 2.7GHz quad-core Qualcomm Snapdragon 805 processor and it comes with 3GB of RAM.|
		|4		|Samsung galaxy s7	|$800|The Samsung Galaxy S7 is powered by 1.6GHz octa-core it comes with 4GB of RAM. The phone packs 32GB of internal storage that can be expanded up to 200GB via a microSD card.|
		|5		|Iphone 6 32gb			|$790|It comes with 1GB of RAM. The phone packs 16GB of internal storage cannot be expanded. As far as the cameras are concerned, the Apple iPhone 6 packs a 8-megapixel primary camera on the rear and a 1.2-megapixel front shooter for selfies.|
		|6		|Sony xperia z5			|$320|Sony Xperia Z5 Dual smartphone was launched in September 2015. The phone comes with a 5.20-inch touchscreen display with a resolution of 1080 pixels by 1920 pixels at a PPI of 424 pixels per inch.|
		|7		|HTC One M9					|$700|The HTC One M9 is powered by 1.5GHz octa-core Qualcomm Snapdragon 810 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage that can be expanded up to 128GB via a microSD card.|
		|8		|Sony vaio i5				|$790|Sony is so confident that the VAIO S is a superior ultraportable laptop that the company proudly compares the notebook to Apple's 13-inch MacBook Pro. And in a lot of ways this notebook is better, thanks to a lighter weight.|
		|9		|Sony vaio i7				|$790|REVIEW Sony is so confident that the VAIO S is a superior ultraportable laptop that the company proudly compares the notebook to Apple's 13-inch MacBook Pro. And in a lot of ways this notebook is better, thanks to a lighter weight, higher-resolution display, more storage space, and a Blu-ray drive.|
		
		Scenario: Verify product infomation is displayed correctly on second page of main page
		Given access the website
		When navigate to the next page
		Then The website displays product <order> information correct with "<name>","<price>","<description>"
		Examples: 
		|order|name								|price|description|
		|1		|Apple monitor 24		|$400	|LED Cinema Display features a 27-inch glossy LED-backlit TFT active-matrix LCD display with IPS technology and an optimum resolution of 2560x1440. It has a 178 degree horizontal and vertical viewing angle, a \\"typical\\" brightness of 375 cd/m2, contrast ratio of 1000:1, and a 12 ms response time.|
		|2		|MacBook air				|$700	|1.6GHz dual-core Intel Core i5 (Turbo Boost up to 2.7GHz) with 3MB shared L3 cache Configurable to 2.2GHz dual-core Intel Core i7 (Turbo Boost up to 3.2GHz) with 4MB shared L3 cache.|
		|3		|Dell i7 8gb				|$700	|6th Generation Intel Core i7-6500U Dual-Core Processor 2.5 GHz (max boost speed up to 3.1GHz) 4MB L3 Cache, 8GB DDR4 1600 MHz, 1TB 5400 RPM HDD15.6 in Full HD LED-backlit touchscreen with Truelife (1920 x 1080), 10-finger multi-touch support, Intel HD Graphics 520 with shared graphics memory|
		|4		|2017 Dell 15.6 Inch|$700	|7th Gen Intel Core i7-7500U mobile processor 2.70 GHz with Turbo Boost Technology up to 3.50 GHz, Intel HD Graphics 62015.6 inch Full HD IPS TrueLife LED-backlit touchscreen (1920 x 1080), 10-finger multi-touch support, 360° flip-and-fold design,8GB DDR4 2400 MHz Memory, 1TB 5400 RPM HDD, No optical drive, 3 in 1 card reader (SD SDHC SDXC)|
		|5		|ASUS Full HD				|$230	|ASUS VS247H-P 23.6- Inch Full HD|
		|6		|MacBook Pro				|$1100|Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.|
		