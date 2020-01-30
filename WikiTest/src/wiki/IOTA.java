package wiki;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IOTA {
	
	WebDriver driver;
	//JavascriptExecutor jse;

	public void browser() {
		try {
			System.getProperty("webdriver.chrome.driver", "C:\\\\Eclipse\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //An implicit wait tells WebDriver An implicit wait tells WebDriver to poll the DOM 
			 //for a certain amount of time when trying to find any element (or elements) 
			 //not immediately available the DOM for a certain amount of time when trying to find any element (or elements) not immediately available
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // An explicit wait is a code you define to wait for a certain condition to occur before proceeding further in the code.
			driver.get("https://prorail-dev.up2.nl/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void lastBarrierClose() {
		try {
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/label[1]/input")).sendKeys("iota");
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/label[2]/input")).sendKeys("iota2017!$");
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div/input")).submit();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/section/div/ul/li[1]/a")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/section/div[2]/div[5]/div/div[2]/div")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"widget-popup\"]/div/div[2]/div[1]/input"))
					.sendKeys("0059AC0000151333");
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"widget-popup\"]/div/div[2]/div[2]/ul/li")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"widget-popup\"]/div/div[3]/div[2]/div[1]/table/tbody/tr[2]/td[2]"))
			.click();
	//		driver.findElement(By.xpath("//*[@id=\"widget-popup\"]/div/div[3]/div[3]/div")).click();
	//		jse = (JavascriptExecutor) driver; //this is casting: convert a value form one data type to another.		
	//		jse.executeScript("scroll(0, 1200)");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void calculation() {
		try {
			driver.findElement(
					By.xpath("//*[@id=\"widget-popup\"]/div/div[3]/div[3]/div/div/ul/li/ul/li/ul/li[13]/ul/li[2]/span"))
					.getText();
			String takeLastClose = driver
					.findElement(By.xpath(
							"//*[@id=\"widget-popup\"]/div/div[3]/div[3]/div/div/ul/li/ul/li/ul/li[13]/ul/li[2]/span"))
					.getText();
			System.out.println(takeLastClose);
			double last = Double.valueOf(takeLastClose);
			if (last >= 7) {
				System.out.println("OK: The last barrier close slow enough!");	
			} else if (last < 7) {
				System.out.println("Warning: The last barrier close too fast!");				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeBrowser() {
		driver.close();
	}

	public static void main(String[] args) {
		IOTA exec = new IOTA();
		exec.browser();
		exec.lastBarrierClose();
		exec.calculation();
		exec.closeBrowser();

	}

}
