package ReadExcelData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import lib.ExcelDataConfig;

import org.testng.annotations.*;

public class ObjectDataDrivenFromExcel {
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
	  driver.get("https://www.facebook.com/");
	 
  }
  

  
  @Test(dataProvider="datatest")
  public void test (String name, String family, String email, String pass) {
	    
	    try {
			driver.findElement(By.xpath("//*[@id=\"u_0_f\"]")).sendKeys(name);
			driver.findElement(By.xpath("//*[@id=\"u_0_h\"]")).sendKeys(family);
			driver.findElement(By.xpath("//*[@id=\"u_0_k\"]")).sendKeys(email);
			driver.findElement(By.xpath("//*[@id=\"u_0_n\"]")).sendKeys(email);
			driver.findElement(By.xpath("//*[@id=\"u_0_p\"]")).sendKeys(pass);
			driver.findElement(By.xpath("//*[@id=\"u_0_a\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"u_0_w\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"facebook\"]/body/div[3]/div[2]/div/div/div/div[3]/button")).click();
		} catch (Exception e) {
			
			System.out.println(e);
		}
	
  }
  
  @DataProvider(name="datatest")
  public Object[][] passData() 
  {
	  ExcelDataConfig config = new ExcelDataConfig("C:\\Eclipse\\db.xlsx");
	  
	  int rows = config.getRowCount(0);
	  
	  Object [][] data = new Object [rows][4];

	  for (int i=1; i<rows; i++)
	  {
		  data[i][0] = config.getData(0, i, 0);
		  data[i][1] = config.getData(0, i, 1);
		  data[i][2] = config.getData(0, i, 2);
		  data[i][3] = config.getData(0, i, 3);
		  
	  }
	  return data;
	  
	  
  }
  
  @AfterTest
  public void exit ()
  {
	  driver.quit();
  }
}
