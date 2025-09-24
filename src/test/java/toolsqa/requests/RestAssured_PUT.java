package toolsqa.requests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RestAssured_PUT {
	
     @Test
     public void UpdateBook() {
    	 
    	 String baseUrl="https://demoqa.com";
         String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlNheWFuIiwicGFzc3dvcmQiOiJTYXlhbkAxMjMiLCJpYXQiOjE3NDc5Mjg0Mjl9.r6lNN2QiS8s74S6SeXpDkbDobiQxmV65JFbne27coyY";
         
         String isbn ="9781449337711";
         String userId= "f93d9bc0-3bc7-4a4e-b975-2eed807236b9";
         
	  RestAssured.baseURI = baseUrl;
	  RequestSpecification httpRequest = RestAssured.given()
			   .header("Authorization","Bearer "+token)
	           .header("Content-Type", "application/json");
 
	   String requestBody = "{\r\n" + 
	   		"  \"userId\": \""+userId+"\",\r\n" + 
	   		"  \"isbn\": \""+isbn+"\"\r\n" + 
	   		"}";
	   httpRequest.body(requestBody);
	  Response response =  httpRequest.when()
			  .put("/BookStore/v1/Books/9781449325862");
	 
	  System.out.println("The response code - " +response.getStatusCode());
         Assert.assertEquals(response.getStatusCode(),200);
	     
	  }
}
