package wiki;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class wikiClass {
	
	WebDriver driver;
	static JavascriptExecutor jseScroll;
	
	public void calculation () {
			try {
				//WebElement takeLastClose;
				driver.findElement(By.xpath("//*[@id=\"widget-popup\"]/div/div[3]/div[3]/div/div/ul/li/ul/li/ul/li[13]/ul/li[2]/span")).getText();
				String takeLastClose = driver.findElement(By.xpath("//*[@id=\"widget-popup\"]/div/div[3]/div[3]/div/div/ul/li/ul/li/ul/li[13]/ul/li[2]/span")).getText();
				System.out.println(takeLastClose);//*[@id="widget-popup"]/div/div[3]/div[3]/div
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		
		
		
		
	}


	public static void main(String[] args)  {
		try {
			// System.setProperty("webdriver.gecko.driver","C:\\\\Eclipse\\Firefox -
			// geckodriver-v0.24.0-win64\\geckodriver.exe");
			// WebDriver driver = new FirefoxDriver();
			// System.setProperty("webdriver.ie.driver","C:\\\\Eclipse\\IE
			// server\\IEDriverServer.exe");
			// WebDriver driver = new InternetExplorerDriver();
			// System.setProperty("webdriver.edge.driver", "C:\\\\Eclipse\\Edge
			// server\\MicrosoftWebDriver.exe");
			// WebDriver driver = new EdgeDriver();
			System.setProperty("webdriver.chrome.driver", "C:\\\\Eclipse\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://prorail-dev.up2.nl/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			// WebElement link;
			// link= driver.findElement(By.id("js-link-box-en"));
			// link= driver.findElement(By.linkText("English"));
			// link= driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]"));
			// link= driver.findElement(By.cssSelector("div[class='central-featured-lang
			// lang1'][dir='ltr']"));
			// link=
			// driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/label[1]/input"));
			// link.click();
			// driver.manage().timeouts().wait(2000);
			// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/label[1]/input")).sendKeys("iota");
			WebElement loginform;
			// loginform =
			// driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/label[1]/input"));
			// loginform.sendKeys("iota");
			Thread.sleep(2000);
			loginform = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/label[2]/input"));
			loginform.sendKeys("iota2017!$");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div/input")).submit();
			// driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div/input")).click();
			// loginform =
			// driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div/input"));
			// loginform.click();
			// loginform.submit();
			Thread.sleep(2000);
			WebElement BarrierDashboard;
			BarrierDashboard = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/section/div/ul/li[1]/a"));
			BarrierDashboard.click();
			Thread.sleep(2000);
			WebElement ProrailCrossing;
			ProrailCrossing = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/section/div[2]/div[5]/div/div[2]/div"));
			ProrailCrossing.click();
			Thread.sleep(2000);
			WebElement search;
			search = driver.findElement(By.xpath("//*[@id=\"widget-popup\"]/div/div[2]/div[1]/input"));
			search.sendKeys("0059AC0000151333");
			WebElement BarrierID;
			BarrierID = driver.findElement(By.xpath("//*[@id=\"widget-popup\"]/div/div[2]/div[2]/ul/li"));
			BarrierID.click();
			WebElement BarrierOpenClose;
			// driver.getTitle();
			BarrierOpenClose = driver
					.findElement(By.xpath("//*[@id=\"widget-popup\"]/div/div[3]/div[2]/div[1]/table/tbody/tr[2]/td[1]"));
			BarrierOpenClose.click();
			WebElement Scroll;
			Scroll = driver
					.findElement(By.xpath("//*[@id=\"widget-popup\"]/div/div[3]/div[3]/div"));
			Thread.sleep(5000);			
			Scroll.click();
			driver.switchTo().frame("//*[@id=\\\"widget-popup\\\"]/div/div[3]/div[3]/div");
			jseScroll = (JavascriptExecutor) driver; //this is casting: convert a value form one data type to another.
			jseScroll.executeScript("scroll(0, 1500)");
			//driver.quit();

			// *[@id=\"widget-popup\"]/div/div[3]/div[3]/div/div/ul/li/ul/li/ul
			// *[@id=\"widget-popup\"]/div/div[3]/div[3]/div/div/ul/li/ul/li/ul

			// Thread.sleep(5000);
			// searchbox = driver.findElement(By.id("searchInput"));
			// searchbox.clear();
			// searchbox.sendKeys("Loko Sofia");
			// searchbox.submit();
			// Thread.sleep(5000);
			// driver.quit();
			wikiClass check = new wikiClass();
			check.calculation();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}