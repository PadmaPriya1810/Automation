package part2.Multiple_WebElement_Handling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class findElements_Flipkart 
{
	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		findElements_Flipkart f=new findElements_Flipkart();
		f.launchBrowser();
		f.openApp();
		f.getAllLinks();
		//f.closeBrowser();
	}
	
	public void launchBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	public void openApp() throws InterruptedException
	{
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		Thread.sleep(4000);
	}
	
	public void getAllLinks() throws InterruptedException
	{
		List<WebElement> allLinks=driver.findElements(By.xpath("//a"));
		
		for(WebElement link:allLinks)//"for-each" loop to Print Each Element
		{
			System.out.println(link.getText());
		}
		Thread.sleep(4000);
		
		System.out.println("Size is :"+allLinks.size());
	}
	public void closeBrowser()
	{
		driver.close();
	}

}
