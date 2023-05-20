package part2.Multiple_WebElement_Handling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Ebay_PrintPathOfImg 
{
	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		Ebay_PrintPathOfImg img=new Ebay_PrintPathOfImg();
		img.launchBrowser();
		img.openApp();
		img.printImagePath();
	}
	public void launchBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	public void openApp() throws InterruptedException
	{
		driver.get("https://www.ebay.com/");
		Thread.sleep(2000);	
	}
	
	public void printImagePath()
	{
		List<WebElement> allimg=driver.findElements(By.xpath("//img"));
	 
	 //To Print Multiple WebElements Use "for-each" loop
	 for(WebElement we:allimg)
	 {
		 System.out.println(we.getAttribute("src"));                             //Remember to use "getAttribute()" 
	 }
	 
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
}
