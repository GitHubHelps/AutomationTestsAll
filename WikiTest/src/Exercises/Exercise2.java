package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise2 {
							
	public static void main(String[] args) {
												WebDriver driver = new ChromeDriver();
												driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
												driver.findElement(By.id("button1")).click();
												driver.close();
										   }

}