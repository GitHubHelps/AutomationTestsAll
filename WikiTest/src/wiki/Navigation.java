package wiki;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	WebDriver driver;

	public void borwser() {
		try {
			System.getProperty("webdriver.chrome.driver", "C:\\\\Eclipse\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			navigate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigate() {
		try {
			driver.navigate().to("http://www.wikipedia.org");
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/a/strong")).click();
			driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[4]/div/div[1]/ul/li[1]/a")).click();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			driver.navigate().forward();
			driver.navigate().refresh();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Navigation exec = new Navigation();
		exec.borwser();
	}

}
