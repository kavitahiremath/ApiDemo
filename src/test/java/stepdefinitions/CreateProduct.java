package stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.API_Body;
import resources.API_Resource;
import resources.AddProductResponsePojo;
import resources.LoginPojo;
import resources.OrderResponsePojo;
import resources.Uitils;

public class CreateProduct extends Uitils{
	
	public static String token="";
	public static String userId="";
	public static String productId="";
	public static String ordertId="";
	API_Body apBody=new API_Body();
	
	static RequestSpecification req;
	Response response;
	public void getValues()
	{
		LoginPojo lp=response.as(LoginPojo.class);
		token=lp.getToken();
		System.out.println(token);
		userId=lp.getUserId();
		System.out.println(userId);
	}
	
	@Given("user loads the API with the {string}")
	public void user_loads_the_api_with_the(String string) throws IOException {
		
		if(string.equalsIgnoreCase("loginpayload"))
		{
			req=given().header("Content-Type","application/json").spec(reqSpecification()).body(apBody.LoginBody());
		}
		else if(string.equalsIgnoreCase("addproductpayload"))
		{
			req=given().header("Content-Type","application/json").spec(reqSpecification()).header("Authorization", token)
					.body(apBody.PlaceOrder(productId));
		}
		else if(string.equalsIgnoreCase("orderpayload"))
		{
			req=given().header("Content-Type","application/json").spec(reqSpecification()).header("Authorization", token)
					.body(apBody.CreateOrderBody(ordertId));
		}
	   
	}
	@Then("^user should see response code as (\\d+)$")
	public void user_should_see_response_code_as(long int1) throws Throwable {

		assertEquals(response.statusCode(), int1);
	}


@When("^user calls http request method$")
public void user_calls_http_request_method() throws Throwable {
	response=req.when().post("api/ecom/product/add-product").
	then().extract().response();
    
}
@Given("user loads the addproduct using {string}")
public void user_loads_the_addproduct_using(String string) throws IOException {
  
	req=reqSpecCreateProduct(userId).header("Authorization", token);
}
@When("user calls post http request method with {string}")
public void user_calls_http_request_method_with(String resource) {

	API_Resource resources=API_Resource.valueOf(resource);
	
	response=req.when().post(resources.getResource()).then().extract().response();
	if(resource.equals("loginAPI"))
	{
		//getValues();
		LoginPojo lp=response.as(LoginPojo.class);
		token=lp.getToken();
		//System.out.println(token);
		userId=lp.getUserId();
		//System.out.println(userId);

	}
	else if(resource.equals("addProductAPI"))
	{
		AddProductResponsePojo addprd=response.as(AddProductResponsePojo.class);
		productId=addprd.getProductId();
		System.out.println(productId);
	}
	
	else if(resource.equals("createOrderAPI"))
	{
		OrderResponsePojo order=response.as(OrderResponsePojo.class);
		System.out.println(order);
		ordertId=order.getProductOrderId().get(0);
		System.out.println(ordertId);
		
	}
}



}