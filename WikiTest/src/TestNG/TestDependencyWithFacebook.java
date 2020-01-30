package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*; // for all annotation not only @Test

public class TestDependencyWithFacebook {

	WebDriver driver;

	@Test
	public void openBrowser() {
		try {
			System.getProperty("webdriver.chrome.driver", "C:\\\\Eclipse\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(); // launch chrome
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //An implicit wait tells WebDriver An implicit wait tells WebDriver to poll the DOM 
																			 //for a certain amount of time when trying to find any element (or elements) 
																			 //not immediately available the DOM for a certain amount of time when trying to find any element (or elements) not immediately available			
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// An explicit wait is a code you define to wait for a certain condition to occur before proceeding further in the code.
			driver.get("http://www.facebook.com");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test (dependsOnMethods = { "openBrowser" })
	public void loginFb() {

		driver.findElement(By.id("email")).sendKeys("Name");
		driver.findElement(By.id("pass")).sendKeys("Password");
		driver.findElement(By.id("loginbutton")).click();

	}
	@AfterTest
	public void exit() {
		driver.close();
	}
}
