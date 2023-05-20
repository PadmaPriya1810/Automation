package part2.Popup;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _13_CurrentDate_Using_Java_jquery 
{
	public static void main(String[] args) 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		
		//Locate Frame & Switch To Frame
		WebElement frame=driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		//OR
		//driver.switchTo().frame(0);//Has Only 1 Frame Index-0
		
		//Current TimeZone
		Calendar cal=Calendar.getInstance();
		
		//Current Date & Time 
		//Date <C> - java.util package
		Date currentdate=cal.getTime();
		System.out.println(currentdate);//Thu Apr 13 19:15:41 IST 2023
		
		//Covert Date into Required Time Format
		//SimpleDateFormat <C> -java.text package
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/YYYY");
		
		String modifieddate=sdf.format(currentdate);
		System.out.println(modifieddate);//04/13/2023

		
		driver.findElement(By.id("datepicker")).sendKeys(modifieddate,Keys.ESCAPE);
		
	}
}
