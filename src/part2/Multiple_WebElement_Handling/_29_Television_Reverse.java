package part2.Multiple_WebElement_Handling;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _29_Television_Reverse 
{
	WebDriver driver;
	
	 public static void main(String[] args) throws InterruptedException, IOException
	 {
		_29_Television_Reverse tr=new _29_Television_Reverse();
        tr.launchBrowser();
        tr.openApp();
        tr.takeScreenshot();
        //tr.closeBrowser();
     }

	 public void launchBrowser()
	 {
		 ChromeOptions options=new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 driver=new ChromeDriver(options);
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
		 
		 //ADDING FIRST 3 Suggestions into ArrayList
        for(int i=0;i<allsugg.size();i++)
        {
			 if(i<=2)
			al.add(allsugg.get(i).getText()); 
        }
        
        //REVERSING ALL SUGGESTIONS
        Collections.reverse(allsugg);//Reversing the Suggestions
        
        //ADDING FIRST 6 SUGGESTIONS AGAIN into ArrayList
        for(int i=0;i<allsugg.size();i++)
        {
			 if(i<=5)
				 
			al.add(allsugg.get(i).getText()); 
        }
        
        //PRINTING ARRAY LIST
        System.out.println(al);
        
        //Using foreach
        for(int i=0;i<al.size();i++) 
        {
        	System.out.println(al.get(i));
        }
     }

	 public void takeScreenshot() throws IOException
		{
		 //To Take the Screenshot Of Entire WebPage
			TakesScreenshot ts=(TakesScreenshot)driver;
			
			//To Take Screenshot in Java Format
			File src=ts.getScreenshotAs(OutputType.FILE);
			
			//To Convert Java to Particular image "png" Format
			File trg=new File("./Screenshot/Television.png");
			
			//To Copy From Source to Destination
			FileUtils.copyFile(src,trg);
		}
	 
	 
	 public void closeBrowser()
	 {
		 driver.close();
	 }
}
