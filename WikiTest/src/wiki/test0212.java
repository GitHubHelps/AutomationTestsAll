package wiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class test0212 {

	@Test
	void test() {
		try {
			System.setProperty("webdriver.gecko.driver","C:\\\\Eclipse\\Firefox - geckodriver-v0.24.0-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("http://www.wikipedia.org");
			WebElement link;
			link= driver.findElement(By.id("js-link-box-en"));
			link.click();
			WebElement searchbox;
			searchbox = driver.findElement(By.id("searchInput"));
			searchbox.sendKeys("Software");
			searchbox.submit();
			WebElement header = driver.findElement(By.id("firstHeading"));   
			//assertTrue(header.isDisplayed());
			System.out.print(header);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
