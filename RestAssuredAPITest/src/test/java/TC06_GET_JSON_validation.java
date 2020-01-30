import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC06_GET_JSON_validation {
	
	@Test
	public void JSONresponseBody() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification getRequest = RestAssured.given();
		
		Response response = getRequest.request(Method.GET,"/Varna");
		
		JsonPath jsonFile = response.jsonPath();
		System.out.println(jsonFile.get("City"));
		System.out.println(jsonFile.get("Temperature"));
		System.out.println(jsonFile.get("Humidity"));
		System.out.println(jsonFile.get("WeatherDescription"));
		System.out.println(jsonFile.get("WindSpeed"));
		System.out.println(jsonFile.get("WindDirectionDegree"));
		
		Assert.assertEquals(jsonFile.get("Temperature"), "7.96 Degree celsius");
				
	}

}
