package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.*; //add all annotation

public class TestTestNGAttributesPriorityDependency {
	//default priority by alphabetic first!
	//if no priority - start this first
  @Test(priority=0)
  public void f() {
  }  
  @Test(priority=4)
  public void a() {
  }
  @Test(dependsOnMethods= {"m"}) 
  public void o() {
  }
  @Test(priority=3)
  public void h() {
  }
  @Test(priority=1)
  public void m() {
  }
  @Test(enabled=false)
  public void d() {
  }
  
  
  
}
