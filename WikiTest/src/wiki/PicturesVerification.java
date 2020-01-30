package wiki;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern; // the path
import org.sikuli.script.Screen; // the screen

public class PicturesVerification {
	
	WebDriver driver;
	Screen myScreen;
	JavascriptExecutor jse;
	
	public void borwser() {
		try {
			System.getProperty("webdriver.chrome.driver", "C:\\\\Eclipse\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://www.ebay.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void picSearch () {
		try {
			Pattern electronics = new Pattern("C:\\Eclipse\\PicturesSikuli\\Electronics.png");
			Pattern VideoGames = new Pattern("C:\\Eclipse\\PicturesSikuli\\VideoGames.png");
			Pattern PCgames = new Pattern("C:\\Eclipse\\PicturesSikuli\\PCgames.png");
			myScreen = new Screen();
			myScreen.wait(electronics, 5); //specific wait for sikuli
			myScreen.click(electronics);
			myScreen.wait(VideoGames, 5);
			myScreen.click(VideoGames);
			myScreen.wait(PCgames, 5);
			myScreen.click(PCgames);
			jse = (JavascriptExecutor) driver;    // use JavaExec 
			jse.executeScript("scroll(0, 1200)"); // for scroll
//			Pattern user = new Pattern("C:\\Eclipse\\PicturesSikuli\\user.png");
//			Pattern pass = new Pattern("C:\\Eclipse\\PicturesSikuli\\pass.png");
//			Pattern login = new Pattern("C:\\Eclipse\\PicturesSikuli\\login.png");
//			myScreen = new Screen(); //!!!
//			myScreen.wait(user, 5); //specific wait for sikuli
//			myScreen.click(user);			
//			myScreen.type(user, "Username");
//			myScreen.click(pass);
//			myScreen.type(pass, "Password");

		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PicturesVerification exec = new PicturesVerification();
		exec.borwser();
		exec.picSearch();

	}

}