package resources;

public enum API_Resource {
	
	loginAPI("api/ecom/auth/login"),
	addProductAPI("api/ecom/product/add-product"),
	createOrderAPI("api/ecom/order/create-order"),
	getAllOrderAPI("api/ecom/product/get-all-products");

	private String resource;
	API_Resource(String resource) {
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
