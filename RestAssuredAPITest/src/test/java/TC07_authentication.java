import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC07_authentication {
@Test	
	public void authenticationTest () {
	
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//Basic authentication
		PreemptiveBasicAuthScheme authUser = new PreemptiveBasicAuthScheme();
		authUser.setUserName("ToolsQA");
		authUser.setPassword("TestPassword");
		
		RestAssured.authentication=authUser;
		
		RequestSpecification authLink = RestAssured.given();
		
		Response response = authLink.request(Method.GET,"/");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode = response.statusCode();
		System.out.println("The status code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
		
	}

}
