package part3.TestNG;

import org.testng.annotations.Test;

public class _02_Test_enabled 
{
	@Test(priority=1)
	public void createproduct()
	{
		System.out.println("Product Created");
	}
	
	@Test(priority=0) //Default value priority attribute is 0
	public void updateproduct()
	{
		System.out.println("Product Updated");
	}
	
	@Test(priority=-1,enabled=false)//Won't Execute -enabled has HIGH priority
	public void deleteproduct()
	{
		System.out.println("Product Deleted");
	}

}

//Product Updated
//Product Created