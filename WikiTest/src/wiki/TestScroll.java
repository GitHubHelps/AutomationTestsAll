package wiki;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestScroll {

	WebDriver driver;
	JavascriptExecutor jse;
	
	public void browser () {
	try {
		System.setProperty("webdrriver.chrome.driver", "C:\\\\Eclipse\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");
		test1();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	//*[@id="gh-ac"]
	public void test1 () {
			driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("laptops");
			driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
			jse = (JavascriptExecutor) driver; //this is casting: convert a value form one data type to another.
			jse.executeScript("scroll(0, 1200)");
			driver.findElement(By.xpath("//*[@id=\"w3-w0-w3-0-0[0]\"]")).sendKeys("800");
			driver.findElement(By.xpath("//*[@id=\"w3-w0-w3-0-1[0]\"]")).sendKeys("1000");
			driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul/div/li[3]/ul/li[4]/div[2]/div/button")).click();
	}
	
	public static void main(String[] args) {
		TestScroll myObj = new TestScroll();
		myObj.browser();
		
	}

}
