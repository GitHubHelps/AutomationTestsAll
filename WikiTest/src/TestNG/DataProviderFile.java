package TestNG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import utility.dataExtract;

public class DataProviderFile {
	WebDriver driver;
	
 
@BeforeMethod
  public void Browser() {
	  System.getProperty("webdriver.chrome.driver", "C:\\Eclipse\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.get("http://www.ebay.com");
  }

//mnogo pogre6no! :D
  @DataProvider(name="getData")
	public Object[][] getData() {
		ArrayList<Object[]>  testData = dataExtract.getDataFromFile();
	  return getData();
	}

  @Test(dataProvider="getData")
  public void registration(String Name, String Family, String Email, String Pass) {
		driver.findElement(By.xpath("//*[@id=\"gh-Alerts-i\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ghn-err\"]/span/a/span")).click();
		driver.findElement(By.id("InLineCreateAnAccount")).click();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(Name);
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(Family);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Email);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(Pass);
		driver.findElement(By.xpath("//*[@id=\"ppaFormSbtBtn\"]")).submit();
		
		
		
  }
  
  @AfterMethod
  public void exit() {
	  driver.close();
  }
}