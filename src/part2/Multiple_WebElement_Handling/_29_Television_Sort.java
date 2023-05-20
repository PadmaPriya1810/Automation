package part2.Multiple_WebElement_Handling;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _29_Television_Sort
{
	WebDriver driver;
	
	 public static void main(String[] args) throws InterruptedException
	 {
		 _29_Television_Sort s=new _29_Television_Sort();
         s.launchBrowser();
         s.openApp();
         s.closeBrowser();
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
		 Thread.sleep(2000);
		 driver.findElement(By.name("q")).sendKeys("Television");
		 Thread.sleep(2000);
		 List<WebElement> allsugg=driver.findElements(By.xpath("//form//li"));
		 
		 ArrayList al=new ArrayList();
		 
		 //ADDING All SUGGESTIONS INTO ArrayList
		 for(int i=0;i<allsugg.size();i++)
         {
			 al.add(allsugg.get(i).getText());
         }
		 
		 //SORTING USING Collections.sort()
         Collections.sort(al); //sort() - Used to sort the list in Ascending Order
         
         //Printing Sorted ArrayList
         System.out.println(al);
         
        
	 }

	 public void closeBrowser()
	 {
		 driver.close();
	 }
}
