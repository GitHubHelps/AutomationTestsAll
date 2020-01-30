import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC05_GET_ValidateJSON {
	@Test
	public void JSONresponseBody() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification getRequest = RestAssured.given();
		
		Response response = getRequest.request(Method.GET,"/Varna");
		
		String getBody = response.getBody().asString();
		System.out.println("The response body is: " + getBody);
		
		Assert.assertEquals(getBody.contains("Varna"), true);
	
				
	}

}
//{
//    "City": "Sofia",
//    "Temperature": "6.81 Degree celsius",
//    "Humidity": "87 Percent",
//    "WeatherDescription": "overcast clouds",
//    "WindSpeed": "2.6 Km per hour",
//    "WindDirectionDegree": "140 Degree"
//}