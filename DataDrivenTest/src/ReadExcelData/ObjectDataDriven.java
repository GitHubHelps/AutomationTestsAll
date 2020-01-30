package ReadExcelData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

public class ObjectDataDriven {
	WebDriver driver;
	
  @BeforeMethod
  public void browser ()
  {
	  System.getProperty("webdriver.chrome.driver", "C:\\Eclipse\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.get("http://www.ebay.com");
	 
  }
  

  
  @Test(dataProvider="datatest")
  public void test (String username, String password) {
	    
	    driver.findElement(By.xpath("//*[@id=\"gh-ug\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"userid\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"sgnBt\"]")).submit();
		driver.quit();
  }
  
  @DataProvider(name="datatest")
  public Object[][] passData() 
  {
	  
	  Object [][] data = new Object [3][2];
	  data [0][0]= "admin";
	  data [0][1]= "pass";
	  data [1][0]= "admin1";
	  data [1][1]= "pass1";
	  data [2][0]= "admin2";
	  data [2][1]= "pass2";
	  
	  return data;
	  
	  
  }
}
