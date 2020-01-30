package DataDriven;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utility.Xls_Reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataDrivenTest {

	public static void main(String[] args) {
		
		 Xls_Reader reader = new Xls_Reader("C:\\Users\\Alexander Rachev\\eclipse-workspace\\WikiTest\\src\\dataProvider\\db.xlsx");
		 String Firstname = reader.getCellData("Sheet1", "Name", 2);
		 String Familyname = reader.getCellData("Sheet1", "Family", 2);
		 String Emailadr = reader.getCellData("Sheet1", "Email", 2);
		 String Password = reader.getCellData("Sheet1", "Pass", 2);
			
		 System.getProperty("webdriver.chrome.driver", "C:\\Eclipse\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://www.ebay.com");
		// driver.findElement(By.xpath("//*[@id=\"gh-Alerts-i\"]")).click();
		// driver.findElement(By.xpath("//*[@id=\"ghn-err\"]/span/a/span")).click();
		// driver.findElement(By.id("InLineCreateAnAccount")).click();
		// driver.findElement(By.xpath("//*[@id=\"gh-Alerts-i\"]")).click();
		// driver.findElement(By.xpath("//*[@id=\"ghn-err\"]/span/a/span")).click();
	   //  driver.findElement(By.id("InLineCreateAnAccount")).click();
		 driver.findElement(By.xpath("//*[@id=\"gh-ug-flex\"]/a")).click();
		 driver.findElement(By.xpath("//*[@id=\"firstname\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(Firstname);
		 driver.findElement(By.xpath("//*[@id=\"lastname\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(Familyname);
		 driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Emailadr);
		 driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(Password);
		 driver.findElement(By.xpath("//*[@id=\"ppaFormSbtBtn\"]")).submit();
	

		 // if there is drop-down with values: 
		 // Select select = new Select(driver.findElement(By.xpath("pytqt na elementa (dropdauna)")));
		 // select.selectByVisibleText("doro-down text ili stoinost ot excel");
		 
	}

}
