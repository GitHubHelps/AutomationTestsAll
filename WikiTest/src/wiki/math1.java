package wiki;

public class math1 {

	public  void math2 () {												
													for(int i=1; i<=5; i++)
													 {
														for (int j=1; j<=5; j++)
															{
																if((i>=2 && j>=5) || (i>=3 && j>=4) || (i>=4 && j>=3) || (i>=5 && j>=2) )
																	{
																		System.out.print("*");			
																	}
																else
																 	{
																		System.out.print(" ");
															 		}																	
															}
														System.out.println("*");
											      		}												
											}
public void math3 ()  {
													for(int i=1; i<=4; i++)
													 {
														for (int j=1; j<=5; j++)
															{
																if((i==1 && j>=3) || (i==2 && j>=4) || (i==3 && j>=5))
																	{
																		System.out.print("*");			
																	}
																else
																 	{
																		System.out.print(" ");
															 		}																	
															}
														System.out.println("*");
												 		}
}
public static void main(String[] args) {
	math1 startRUN = new math1();
	startRUN.math2();
	startRUN.math3();
}
				  }
