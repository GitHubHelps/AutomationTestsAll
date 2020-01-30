import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC03_ValidatingGETHeaders {
	@Test
	public void googleMAP() {
		//Specify the URI
		RestAssured.baseURI="https://www.google.com/maps";
		
		//Requested object
		RequestSpecification getRequest = RestAssured.given();
		
		//Response object
		Response response =  getRequest.request(Method.GET,"/place/Up2+Technology/@42.6731498,23.3546811,15z/data=!4m5!3m4!1s0x0:0x4d5ca859aaae86b8!8m2!3d42.6697479!4d23.3540288");
		
		//Print response
		String responseBpdy = response.getBody().asString();
	    System.out.println(responseBpdy);
		
		//Header validating
		String contentType = response.header("Content-Type"); //Capture the headers details for Content-Type
		System.out.println(contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
		
		//Header validating
		String contentCoding = response.header("Content-Encoding"); //Capture the headers content encoding
		System.out.println(contentCoding);
		Assert.assertEquals(contentCoding, "gzip");		
		
	}

}
