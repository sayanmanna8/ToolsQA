package toolsqa.requests;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RestAssured_POST {
	
	@Test
	public void postRequestBooksAPI() 
	{ 
		RestAssured.baseURI = "https://demoqa.com"; 
		String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlNheWFuIiwicGFzc3dvcmQiOiJTYXlhbkAxMjMiLCJpYXQiOjE3NDc5Mjg0Mjl9.r6lNN2QiS8s74S6SeXpDkbDobiQxmV65JFbne27coyY";
		   
		
		String isbn ="9781449325862";
        String userId= "f93d9bc0-3bc7-4a4e-b975-2eed807236b9";
		
	   
	   RequestSpecification httpRequest = RestAssured.given()
			   .header("Authorization","Bearer "+token)
			   .header("Content-Type", "application/json");
	          
	   String reqestBody = "{\r\n" + 
	   		"  \"userId\": \""+userId+"\",\r\n" + 
	   		"  \"collectionOfIsbns\": [\r\n" + 
	   		"    {\r\n" + 
	   		"      \"isbn\": \""+isbn+"\"\r\n" + 
	   		"    }\r\n" + 
	   		"  ]\r\n" + 
	   		"}";
	   
	   httpRequest.body(reqestBody);
	   
	   Response response = httpRequest.when()
			   .post("/BookStore/V1/Books"); 
	   
	   
	   System.out.println("The status received: " + response.statusLine());
	   Assert.assertEquals(response.getStatusCode(),201);
	}
}
