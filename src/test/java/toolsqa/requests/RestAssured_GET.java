package toolsqa.requests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_GET {
	@Test
	public void GetBooksDetails() { 

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books"; 

 
		RequestSpecification httpRequest = RestAssured.given(); 

		//Response response = httpRequest.request(Method.GET, "");
		Response response = httpRequest.when().get();

		System.out.println("Status received => " + response.getStatusLine()); 
		System.out.println("Response=>" + response.prettyPrint());
		Assert.assertEquals(response.getStatusCode(),200);
	     
	   }
}
