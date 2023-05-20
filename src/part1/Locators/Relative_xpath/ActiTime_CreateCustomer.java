package part1.Locators.Relative_xpath;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

//ASSIGNMENT : Using Generic Methods
/*SCENARIO:
 * Goto ActiTime
 * Perform Login Action
 * Click on Task
 * Click on Add New
 * Provide the Customer Name
 * Provide the Description
 * Click on Create Customer
 * Fetch the Customer Name
 */

public class ActiTime_CreateCustomer 
{	
	EdgeDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		ActiTime_CreateCustomer at=new ActiTime_CreateCustomer();
		at.launchBrowser();
		at.loginApp();
		
		String cName="Priya";//Initializing cname
		
		Random r=new Random();//Present in java.util package
		int num=r.nextInt(1000);//Prints Random number
		
		cName=cName+num;//Reinitializing cname to get Unique name everytime
		//i.e., Priya1234  Priya4562  Priya1268  Priya1810
		
		String expcName=at.createCustomer(cName);
		System.out.println(expcName);
		
		//To Check ExpectedCustomerName=ActualCustomerName
		if(expcName.equals(cName))
		{
			System.out.println("TestCase is Pass");
		}
			else
			{
				System.out.println("TestCase is Fail");
			}
		
		at.closeBrowser();
	}
	
	public void launchBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}

	public void loginApp() throws InterruptedException
	{
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("keepLoggedInCheckBox")).click();
		driver.findElement(By.id("loginButton")).click();
	}
	
	public String createCustomer(String cName) throws InterruptedException
	{
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.cssSelector(".title.ellipsis")).click();
		driver.findElement(By.className("createNewCustomer")).click();
		driver.findElement(By.cssSelector(".inputFieldWithPlaceholder.newNameField.inputNameField")).sendKeys(cName);
		driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys("Demo");
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
		
		//Use Forward Traversing to fetch text from particular CustName Field i.e omit other buttons
		String expcName=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title")).getText();
		return expcName;
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
}
