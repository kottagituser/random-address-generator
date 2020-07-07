# Code Challenge Application
	*A REST HTTP Service  that can generate a random address for the following four countries:
		- US
		- Canada
		- Mexico
		- Netherlands
	*The address is NOT logically/shipping valid up to a country level. 
	 Instead is human readable country mailing format.
	 
## Java 8 + SpringBoot Solution
	*Response is in a human readable JSON/XML format.
	*Basic Authentication and unit tests included.
	
	```
	Swagger:
	http://localhost:8080/codechallenge/swagger-ui.html
	
	
	URL:
	GET http://localhost:8080/codechallenge/randomizer/address/
	
	Authorization header:
	Basic bWFzdGVyY2FyZDptYXN0ZXJjYXJk 

	Sample Response:
	
	{
	    "house": "7423",
	    "street": "Mesones",
	    "postalCode": "78759",
	    "city": "Zacatecas",
	    "county": "Col. Xalapa",
	    "state": "Chiapas",
	    "stateCode": "CS",
	    "country": "México",
	    "countryCode": "MEX",
	    "addressTxt": "Mesones 7423, Col. Xalapa, Zacatecas Chiapas CP: 78759 México"
	}
	
	(addressTxt json field in the response give a one line address in the country specific format)
	```
	
## Test Data Generation (see RandomGeneratorService.java)
	The states, stateCodes for each country along with the corresponding capital cities were included as lists.
	The most common street names/street types in each country were included as lists.
