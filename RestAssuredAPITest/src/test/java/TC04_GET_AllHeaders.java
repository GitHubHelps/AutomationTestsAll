import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC04_GET_AllHeaders {
	
	@Test
	public void googleMAP() {
		//Specify the URI
		RestAssured.baseURI="https://www.google.com/maps";
		
		//Requested object
		RequestSpecification getRequest = RestAssured.given();
		
		//Response object
		Response response =  getRequest.request(Method.GET,"/place/Up2+Technology/@42.6731498,23.3546811,15z/data=!4m5!3m4!1s0x0:0x4d5ca859aaae86b8!8m2!3d42.6697479!4d23.3540288");
				
		Headers allHeaders = response.headers(); //get all the headers form respond
		//System.out.println(allHeaders);
		for (Header header:allHeaders)
		{
			System.out.println(header.getName()+ " = "+header.getValue());
		}

	}
}