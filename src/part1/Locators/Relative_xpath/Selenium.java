package part1.Locators.Relative_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium {
	EdgeDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		Selenium s=new Selenium();//Has Default No Arg() Cons
		//We have to use the NS-methods present in "Selenium" Class
		//So we need to Create an Object
		
		s.openBrowser();
		s.openApp();
		String title=s.fetchTitle();
		System.out.println("Title is : "+title);
		s.closeBrowser();
		
	}

	public void openBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	public void openApp() throws InterruptedException
	{
		driver.get("https://www.selenium.dev/");
		
		//To Click Documentation
		driver.findElement(By.linkText("Documentation")).click();
		Thread.sleep(3000);
		
		//To Click WebDriver
		driver.findElement(By.id("m-documentationwebdriver")).click();
		Thread.sleep(3000);
		
		//To Click Drivers
		driver.findElement(By.id("m-documentationwebdriverdrivers")).click();
		Thread.sleep(3000);
		
		//To Click Options
		driver.findElement(By.id("m-documentationwebdriverdriversoptions")).click();
		Thread.sleep(3000);
	}
	
	public String fetchTitle()
	{
		//To Fetch the Title
		String title=driver.getTitle();
		return title;
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
}
