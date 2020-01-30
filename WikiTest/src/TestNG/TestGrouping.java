package TestNG;

import org.testng.annotations.Test;

public class TestGrouping {
	
  @Test(groups= {"B"})
  public void a1() {
  }
  
  @Test(groups= {"D"})
  public void a2() {
  }
  
  @Test(groups= {"D"})
  public void a3() {
  }
  
  @Test(groups= {"D"})
  public void a4() {
  }
  
  
}
