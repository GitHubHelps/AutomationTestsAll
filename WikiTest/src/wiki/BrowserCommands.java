package wiki;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {

	WebDriver driver;

	public void borwser() {
		try {
			System.getProperty("webdriver.chrome.driver", "C:\\\\Eclipse\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //An implicit wait tells WebDriver An implicit wait tells WebDriver to poll the DOM 
			 //for a certain amount of time when trying to find any element (or elements) 
			 //not immediately available the DOM for a certain amount of time when trying to find any element (or elements) not immediately available
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // An explicit wait is a code you define to wait for a certain condition to occur before proceeding further in the code.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeBrowser() {
		// driver.close();
		driver.quit();
	}

	public static void main(String[] args) {
		BrowserCommands exec = new BrowserCommands();
		exec.borwser();
		exec.closeBrowser();

	}

}
