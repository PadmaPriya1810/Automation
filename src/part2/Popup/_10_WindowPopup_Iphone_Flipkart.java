package part2.Popup;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class _10_WindowPopup_Iphone_Flipkart {
	public static void main(String[] args) 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("Iphonex");
		driver.findElement(By.cssSelector("[type='submit']")).click();
		driver.findElement(By.xpath("//div[text()='APPLE iPhone X (Silver, 256 GB)']")).click();
		
		String mainid=driver.getWindowHandle();
		
		Set<String> allids=driver.getWindowHandles();
		
		for(String id:allids)
		{
			if(!(id.equals(mainid)))
			{
				driver.switchTo().window(id);				
			}
		}
		
		//TO GET SESSION ID OF NEW WINDOW
		
		//String newid=driver.getWindowHandle();
		//System.out.println(id);
		
		String title=driver.getTitle();
		System.out.println(title);//APPLE iPhone X ( 256 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com
		
		//Price of the Product
		String price=driver.findElement(By.xpath("//div[@class='CEmiEU']")).getText();
		System.out.println(price);//?1,06,900
		
		//Close
		driver.close(); //Closes New Tab
		
		//Check Whether driver focusing back to Main Page Automatically? No
		//Fetch Title
		System.out.println(driver.getTitle()); //NoSuchWindowException
		
}
}