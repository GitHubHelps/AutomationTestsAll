package wiki;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class GetCommands {
	
	WebDriver driver;
	
	public void borwser () {
		try {
			System.getProperty("webdriver.chrome.driver","C:\\\\Eclipse\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // An explicit wait is a code you define to wait for a certain condition to occur before proceeding further in the code.
			getCommands ();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void getCommands () {
		try {
		driver.get("https://www.amazon.com");
		String TitleOfThePage = driver.getTitle();
		driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/div")).getText();
		String takeLastClose = driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/div")).getText();
		System.out.println(takeLastClose);
		System.out.println("Title of the page is:" + TitleOfThePage);
		driver.findElement(By.linkText("Today's Deals")).click();
		String CurrentURL = driver.getCurrentUrl();
		System.out.println("The current URL is:"+ CurrentURL);
		//System.out.println("The current page source is:" + driver.getPageSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		GetCommands exec = new GetCommands();
		exec.borwser();

	}

}
