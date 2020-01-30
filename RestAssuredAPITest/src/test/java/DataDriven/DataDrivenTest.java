package DataDriven;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest {
@Test
	public void addNewEmployees () {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification employeesURL = RestAssured.given();
		
		//data for the request
		JSONObject requestParam = new JSONObject();
		
		requestParam.put("name", "Alex");
		requestParam.put("salary", "5000");
		requestParam.put("age", "35");
		
		//Add header for the JSON request
		employeesURL.header("Content-Type","application/json");
		
		//Add JSON to the body
		employeesURL.body(requestParam.toJSONString());
		
		//Post request send
		Response response = employeesURL.request(Method.POST,"/create");
		
		//Capture response body
		String responseBody = response.getBody().asString();
		
		Assert.assertEquals(responseBody.contains("Alex"),true);
		Assert.assertEquals(responseBody.contains("5000"),true);
		Assert.assertEquals(responseBody.contains("35"),true);
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);			
		
	}
	
}
