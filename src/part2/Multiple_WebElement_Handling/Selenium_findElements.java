package part2.Multiple_WebElement_Handling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium_findElements 
{
     WebDriver driver;
     
	public static void main(String[] args) throws InterruptedException
	{
		Selenium_findElements s=new Selenium_findElements();
		s.launchBrowser();
		s.openApp();
		s.printWebElements();
		s.closeBrowser();	
	}
	
	public void launchBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	public void openApp() throws InterruptedException
	{
		driver.get("https://www.selenium.dev/");
		Thread.sleep(2000);	
	}
	
	public void printWebElements()
	{
	 List<WebElement> allwe=driver.findElements(By.xpath("//*"));//Use "findElements" - To Return Multiple WebElements
	 
	 //To Print Multiple WebElements Use "for-each" loop
		 for(WebElement we:allwe)
		 {
			 System.out.println(we.getText());//Remember to use "getText()" 
		 }
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
}
