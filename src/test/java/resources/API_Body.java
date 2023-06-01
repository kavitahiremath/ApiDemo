package resources;

public class API_Body {

	public String LoginBody()
	{
//commenting the body part
		return "{\r\n"
				+ "\"userEmail\":\"k@gmail.com\",\r\n"
				+ "\"userPassword\":\"Abc@1234\"\r\n"
				+ "}";
	}
	public  String PlaceOrder(String pID)
	{
		return "{\r\n"
				+ "    \"productId\": \""+pID+"\",\r\n"
				+ "    \"message\": \"Product Added Successfully\"\r\n"
				+ "}";
	}
	
	public String CreateOrderBody(String orderId)
	{
		return "{\r\n"
				+ "    \"orders\": [\r\n"
				+ "        \"64673716568c3e9fb1705099\"\r\n"
				+ "    ],\r\n"
				+ "    \"productOrderId\": [\r\n"
				+ "        \""+orderId+"\"\r\n"
				+ "    ],\r\n"
				+ "    \"message\": \"Order Placed Successfully\"\r\n"
				+ "}";
	}
}
