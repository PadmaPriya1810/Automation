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

public class _13_TomorrowDate_Using_Java_Jquery 
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
		
		//Time Zone
		Calendar cal=Calendar.getInstance();
		
		//To Get CurrentDate
		//Date currentdate=cal.getTime();
		
		//Tomorrow's Date
		cal.add(cal.DAY_OF_YEAR,1);
		
		//Yesterday's date
		//cal.add(cal.DAY_OF_YEAR,1);
		
		Date tomdate=cal.getTime();
		
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/YYYY");
		String modifieddate=sdf.format(tomdate);
		
		driver.findElement(By.id("datepicker")).sendKeys(modifieddate,Keys.ESCAPE);
	}	
}
