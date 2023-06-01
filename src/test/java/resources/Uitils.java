package resources;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Uitils {
	
	static RequestSpecification req,req1;
	public static RequestSpecification reqSpecification() throws IOException
	{
		if(req==null)
		{
		 PrintStream stream=new PrintStream(new File("Logger.txt"));
		 
		 req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").
				addFilter(RequestLoggingFilter.logRequestTo(stream)).
				addFilter(ResponseLoggingFilter.logResponseTo(stream))
				.addHeader("Content-Type","application/json")
				.build();
		}
		return req;
	}
	
	public static RequestSpecification reqSpecCreateProduct(String userId) throws IOException
	{
		//RequestSpecification addProd=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").build();
		
		 req1=given().spec(reqSpecification()).header("Content-Type","multipart/form-data")
				.param("productName", "Car").param("productAddedBy", userId)
				.param("productCategory", "Vehicle").param("productSubCategory", "4Wheeler")
				.param("productPrice", "11000").param("productDescription", "Car")
				.param("productFor", "Vehicle").
				multiPart("productImage",new File("C:\\Users\\SPURGE\\Downloads\\car.jpg"));
		return req1;
	}
	public ResponseSpecification resSpecification()
	{
		ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).build();
		return res;
		
	}

}
