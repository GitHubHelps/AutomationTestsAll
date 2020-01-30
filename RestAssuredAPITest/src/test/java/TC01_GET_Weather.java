

import org.junit.Assert;
import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC01_GET_Weather {
	
@Test
	 public void getWeatherDetails () {
		//Specify base UR:
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		//Request Object
		RequestSpecification weatherURL = RestAssured.given();
		//Response Object - contain StatusCode, StatusLine, ResponseTime, Header, Response body
		Response responseWeather = weatherURL.request(Method.GET,"/Sofia");
		//Print the response body - Response body
		String responseBody =  responseWeather.getBody().asString();
		System.out.println("Response body is: " + responseBody);
		//Status code validation
		int statusCode = responseWeather.getStatusCode();
		System.out.println("Response body status code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		//Status line
		String statusLine = responseWeather.getStatusLine();
		System.out.println("Response body status line is: "+ statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		}
}
