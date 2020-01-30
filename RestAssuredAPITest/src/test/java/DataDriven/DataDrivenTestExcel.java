package DataDriven;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelDataConfig;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class DataDrivenTestExcel {
	  @Test(dataProvider="datatest")
	public void addNewEmployees (String name, String family, String username, String email, String pass) {
			//Specify the URI
			RestAssured.baseURI="http://restapi.demoqa.com/customer";
			//Request object
			RequestSpecification postRequest = RestAssured.given();
					
			//Request values sending along with post request
			JSONObject requestParams = new JSONObject();
			
			requestParams.put("FirstName", name);
			requestParams.put("LastName", family);
			requestParams.put("UserName", username);
			requestParams.put("Email", email);
			requestParams.put("Password", pass);
			
			postRequest.header("Content-Type","application/json");
			
			//Attached data to the request
			postRequest.body(requestParams.toJSONString());
			
			//Response object
			Response response = postRequest.request(Method.POST,"/register");
			System.out.println("Request body: " +requestParams);
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
//Read from ExcelDataConfig
@DataProvider(name="datatest")
public Object[][] passData() 
{
	  ExcelDataConfig config = new ExcelDataConfig("C:\\Eclipse\\db2.xlsx");
	  
	  int rows = config.getRowCount(0);
	  int columnCount = config.getColumnCount("Sheet1");
	  
	  Object [][] data = new Object [rows][columnCount];
	  
	  for ( int i = 0; i < rows; i++)
	    {
	      for ( int j = 0; j < columnCount; j++)
	      {
	        data[i][j] = config.getData( 0, i, j );
	      }
	    }

//	  for (int i=1; i<rows; i++)
//	  {
//		  data[i][0] = config.getData(0, i, 0);
//		  data[i][1] = config.getData(0, i, 1);
//		  data[i][2] = config.getData(0, i, 2);
//		  data[i][3] = config.getData(0, i, 3);
//		  data[i][4] = config.getData(0, i, 4);
//		  
//	  }
	  return data;
	  
	  
}
	
}
