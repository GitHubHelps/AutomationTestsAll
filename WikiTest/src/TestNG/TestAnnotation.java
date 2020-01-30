package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.*; //add all annotation

public class TestAnnotation {
  @Test
  public void f1() {
	  System.out.println("Inside f1");
  } 
  
  @BeforeSuite
  public void BeforeSuite () {
	  System.out.println("Before Suite");
  }
  
  @AfterSuite
  public void AfterSuite () {
	  System.out.println("After Suite");
  }
  
  @Test
  public void f2() {	
	  System.out.println("Inside f2");
  }
	  
  @BeforeTest
  public void beforeAnyTest() {
	  System.out.println("Before any test");
  }
  
  @AfterTest
  public void afterAllTests() {
	  System.out.println("After any test");
  }
  
  @BeforeMethod //run before every test method (@Test)
  public void beforeAnyMethod() {
	  System.out.println("Before every test method");
  }
  
  @AfterMethod //run after every test method (@Test)
  public void afterAnyMethod() {
	  System.out.println("After every test method");
  }
  
  @BeforeClass
  public void beforeAnyClass() {
	  System.out.println("Before any class");
  }
  
  @AfterClass
  public void afterAnyClass() {
	  System.out.println("After any class");
  }
}
