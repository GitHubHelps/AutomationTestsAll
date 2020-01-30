package DataDriven;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import Utility.XLUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class DataDrivenTest3 {
@Test(dataProvider="dt")
	public void addNewEmployees (String name, String salary, String age) {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification employeesURL = RestAssured.given();
		
		//data for the request
		JSONObject requestParam = new JSONObject();
		
		requestParam.put("name", name);
		requestParam.put("salary", salary);
		requestParam.put("age", age);
		
		//Add header for the JSON request
		employeesURL.header("Content-Type","application/json");
		
		//Add JSON to the body
		employeesURL.body(requestParam.toJSONString());
		
		//Post request send
		Response response = employeesURL.request(Method.POST,"/create");
		
		//Capture response body
		String responseBody = response.getBody().asString();
		
		System.out.println(responseBody);
		
		Assert.assertEquals(responseBody.contains(name),true);
		Assert.assertEquals(responseBody.contains(salary),true);
		Assert.assertEquals(responseBody.contains(age),true);
	
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);			
		
	}
// Read from XLUtils file!
	@DataProvider(name="dt")
	String [][] exdata () throws Exception 
	{

		String path = "C:\\Users\\Alexander Rachev\\eclipse-workspace\\RestAssuredAPITest\\src\\test\\java\\Utility\\db3.xlsx";
	//	String path = System.getProperty("user.dir")+"\\src\\test\\java\\Utility\\db3.xlsx";

		int rowsNum = XLUtils.getRowCount(path, "Sheet1");
		int columnNum = XLUtils.getCellCount(path, "Sheet1", 1);
		System.out.println(rowsNum);
		System.out.println(columnNum);
		String excelData [][] = new String[rowsNum][columnNum];
		
		  for ( int i = 0; i < rowsNum; i++)
		    {	  
			  for ( int j = 0; j < columnNum; j++)
		      {    
		    	  excelData[i][j] = XLUtils.getCellData(path, "Sheet1", i, j);
		    	 // System.out.println("result:" + excelData[i][j]);	    	 	    	  
		      }
		    }
		
		
//		String getData [][] = {{"AlexR","20010","21"},{"IvanN","21555","32"},{"PeterK","22156","22"}};
		return excelData;
	}
	
	
}
