Feature: Creating a Product

	Scenario: Login in to the API
	Given user loads the API with the "loginpayload"
	When  user calls post http request method with "loginAPI"
	Then  user should see response code as 200
	
  Scenario: Adding a Product into a Page
    Given user loads the addproduct using "addproductpayload"
    When user calls post http request method with "addProductAPI"
    Then user should see response code as 201
    
  Scenario: Create the order
    Given user loads the API with the "orderpayload"
    When user calls post http request method with "createOrderAPI"
   Then user should see response code as 201