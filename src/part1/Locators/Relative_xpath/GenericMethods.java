package part1.Locators.Relative_xpath;
/*
 * SCENARIO:
 * Goto Flipkart
 * Search for Toys
 * Fetch the Result
 */
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericMethods 
{
	ChromeDriver driver;
	static Scanner sc=new Scanner(System.in);
	
public static void main(String[] args) throws InterruptedException 
{
	System.out.println("Enter a Product to Search");
	String product=sc.nextLine();	
	GenericMethods gm=new GenericMethods();
	gm.launchBrowser();
	gm.loginApp();
	//For Getting Search Results
	String result=gm.searchToys(product);//returning "String"
	System.out.println(result);
	gm.closeBrowser();
	
	
}
	
	public void launchBrowser()
	{
		driver=new ChromeDriver();//ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();//To Maximize
	}
	
	public void loginApp()
	{
		//To Open the Application
		driver.get("https://www.flipkart.com/");
		
		//To Close Login Pop-Up
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
	}
	
	public String searchToys(String product) throws InterruptedException //Exception-Thread.sleep
	{
		//To Enter Toys in SearchBox
		driver.findElement(By.name("q")).sendKeys("Toys");
		
		//To Click Search Icon
		driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(3000);//Moves Next Page
		
		//To Fetch Search Results using getText()
		String result=driver.findElement(By.xpath("//span[contains(text(),'Showing')]")).getText();
		return result;
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	
}
