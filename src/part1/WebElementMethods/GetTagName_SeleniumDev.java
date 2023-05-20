package part1.WebElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class GetTagName_SeleniumDev
 {
   EdgeDriver driver;
	
   public static void main(String[] args) throws InterruptedException 
   {
	
	   GetTagName_SeleniumDev tn=new GetTagName_SeleniumDev();
	   tn.launchBrowser();
	   tn.openApp();
	   tn.getSize_getLocation();
	   tn.getTagname();
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
	
	public void getSize_getLocation()
	{
		
		WebElement about=driver.findElement(By.linkText("About"));
		Point location=about.getLocation();
		System.out.println("X & Y Co-Ordinates : "+location);
		Dimension size=about.getSize();
    	System.out.println("Width & Height : "+size);
   
     }
	public void getTagname()
	{
		driver.findElement(By.linkText("About")).click();
		WebElement history=driver.findElement(By.linkText("History"));
		String tagname=history.getTagName();
		System.out.println("Tagname Of History is : "+tagname);
	}
}