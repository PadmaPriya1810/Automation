package part3.TestNG;

import org.testng.annotations.Test;

public class _02_Test_dependsOnMethods 
{
	@Test(priority=3)
	public void createproduct()
	{
		System.out.println("Product Created");
	}
	
	@Test(dependsOnMethods="createproduct")//Dependency Between Methods
	public void updateproduct()
	{
		System.out.println("Product Updated");
	}
	
	@Test(priority=0,dependsOnMethods="updateproduct")//dependsOnMethods has HIGH Prority
	public void deleteproduct()
	{
		System.out.println("Product Deleted");
	}


}

//Product Created
//Product Updated
//Product Deleted