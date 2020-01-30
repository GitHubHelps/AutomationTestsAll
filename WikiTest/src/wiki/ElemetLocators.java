package wiki;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElemetLocators {

	WebDriver driver;

	public void borwser(String url) {
		try {
			System.getProperty("webdriver.chrome.driver", "C:\\\\Eclipse\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //An implicit wait tells WebDriver An implicit wait tells WebDriver to poll the DOM 
			 //for a certain amount of time when trying to find any element (or elements) 
			 //not immediately available the DOM for a certain amount of time when trying to find any element (or elements) not immediately available
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // An explicit wait is a code you define to wait for a certain condition to occur before proceeding further in the code.
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ElLocatorsWiki() {
		try {	
			borwser("http://www.wikipedia.org");
			driver.findElement(By.linkText("Wikimedia Foundation")).click();
			driver.navigate().back();
			driver.findElement(By.id("searchInput")).sendKeys("Selenium");
			driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button/i")).click();
			driver.navigate().back();
			driver.findElement(By.partialLinkText("View full")).click();
			Thread.sleep(2000);
			
			
// 		    borwser("https://www.esky.bg/");	
//			driver.findElement(By.xpath("//*[@id=\"departureDateRoundtrip0\"]")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
//			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
//			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a")).click();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void EllocatorsFace() {
		try {
			borwser("http://www.facebook.com");
			// driver.findElement(By.name("firstname")).sendKeys("Sasho");
			// driver.findElement(By.tagName("input[name='firstname']")).sendKeys("Sa60");
			// driver.findElement(By.cssSelector("input#email")).sendKeys("abv.mail.bg");
			// //"input.inputtext"
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Sa60");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void closeBrow() {
		driver.quit();
	}

	public static void main(String[] args) {
		ElemetLocators exec = new ElemetLocators();
		exec.ElLocatorsWiki();
		// exec.EllocatorsFace();
		exec.closeBrow();

	}

}
