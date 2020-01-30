import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_POST_UserCreation {
	@Test
	public void userCreation () {
		//Specify the URI
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		//Request object
		RequestSpecification postRequest = RestAssured.given();
				
		//Request values sending along with post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Ime3");
		requestParams.put("LastName", "Family3");
		requestParams.put("UserName", "duck3");
		requestParams.put("Password", "parola3");
		requestParams.put("Email", "I23me@rrr.ff");
		
		postRequest.header("Content-Type","application/json");
		
		//Attached data to the request
		postRequest.body(requestParams.toJSONString());
		
		//Response object
		Response response = postRequest.request(Method.POST,"/register");
		
		//Print the response body
		String responseBody =  response.getBody().asString();
		System.out.println("Response body is: " + responseBody);
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Response body status code is: " + statusCode);
		Assert.assertEquals(statusCode, 201);
		//Response JSON suucessCode
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode,"OPERATION_SUCCESS");
		//Response JSON message
		String message = response.jsonPath().get("Message");
		Assert.assertEquals(message, "Operation completed successfully");
		}
}
