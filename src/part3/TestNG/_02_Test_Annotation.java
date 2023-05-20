package part3.TestNG;

import org.testng.annotations.Test;

public class _02_Test_Annotation 
{
	@Test
	public void createproduct()
	{
		System.out.println("Product Created");
	}
	
	@Test
	public void updateproduct()
	{
		System.out.println("Product Updated");
	}
	
	@Test
	public void deleteproduct()
	{
		System.out.println("Product Deleted");
	}

}

//Executed in Alphabetical Order
//Product Created
//Product Deleted
//Product Updated