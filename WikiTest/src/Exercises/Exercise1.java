package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise1 {							
						WebDriver driver;			
						String url = "http://www.shop.demoqa.com";		   
				public void browser () {
										try {
											System.getProperty("webdriver.chrome.driver", "C:\\\\Eclipse\\chromedriver_win32\\chromedriver.exe");
											driver = new ChromeDriver();
											driver.manage().window().maximize();	
											driver.get(url);
										} catch (Exception e) {											
											e.printStackTrace();
										}
								       }
				public void actions () {
										try {
											String title = driver.getTitle();
											Integer title_lenght = driver.getTitle().length();
											System.out.println("The site title is: " + title);
											System.out.println("The site title lenght is: " + title_lenght);
											String currentURL = driver.getCurrentUrl();
											if (currentURL.equals(url)) {
												System.out.println("The URL is correct! " + currentURL);
											}
											else  {
												System.out.println("The URL is not correct! " + url);
											}
											System.out.println("Actual URL is : " + currentURL); 
											System.out.println("Expected URL is : " + url);
											String pageSource = driver.getPageSource();
											Integer pageSourceLenght = driver.getPageSource().length();
											System.out.println("The lenght of the page source is: " + pageSourceLenght);
											driver.close();
										} catch (Exception e) {
											e.printStackTrace();
										}
								        		
							           }
			
			
			
			
			
									
			
	public static void main(String[] args) {
											Exercise1 exec = new Exercise1();
											exec.browser();
											exec.actions();
										 	}
					  
						}
