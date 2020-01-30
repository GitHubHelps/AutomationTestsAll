package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGAssertionAndParameters {
	
	// DA SE RUN-VA PREZ CONFIGTEST FILE-a ILI NQMA DA MINE ! :)
	WebDriver driver;
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void Browser(String url, String browser) {
		try {
			if (browser.equals("chrome")) {
				System.getProperty("webdriver.chrome.driver", "C:\\\\Eclipse\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver(); //launch chrome
			} else if (browser.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver","C:\\\\Eclipse\\Firefox - geckodriver-v0.24.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equals("Edge")) {
				System.setProperty("webdriver.edge.driver", "C:\\\\Eclipse\\Edge server\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();	
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //An implicit wait tells WebDriver to poll the DOM 
																			 //for a certain amount of time when trying to find any element (or elements) 
			 																 //not immediately available the DOM for a certain amount of time when trying to find any element (or elements) not immediately available
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);// An explicit wait is a code you define to wait for a certain condition to occur before proceeding further in the code.
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@Parameters({"mailid" ,"pwd"})
	@Test	
	public void login(String mailid, String pwd) {
		try {
			driver.findElement(By.xpath("//*[@id=\"gb_70\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(mailid);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(pwd);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test //(invocationCount=5) //how many time to execute the method
	public void getTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google", "Title is different"); //the 3th part is what msg to display if there is mismatch, but still fail test, just add to the expection the msg
		System.out.println(title);

	}

//	@Test(expectedExceptions=NumberFormatException.class) //if fail is expected as exception and will mark as fail, but will be expected 
//	public void mail() {
//	driver.findElement(By.linkText("Gmail1")).isDisplayed();		
//	}
//	
//	@Test
//	public void image( ) {
//		boolean cirk = driver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();	
//		Assert.assertTrue(cirk);
//		System.out.println("Logo is displayed");
//	}
//	
//	@Test
//	public void getTitle1() {
//		String title = driver.getTitle();
//		Assert.assertEquals(title, "Google");
//		System.out.println(title);
//
//	}
	
	@AfterMethod
	public void exit() {
		driver.close();
	}
}
