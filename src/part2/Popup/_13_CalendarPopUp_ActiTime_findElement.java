package part2.Popup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _13_CalendarPopUp_ActiTime_findElement
{
	public static void main(String[] args)
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.name("username")).sendKeys("admin",Keys.TAB,"manager",Keys.ENTER);
		
		//Locate To Click/Display Calendar
		driver.findElement(By.className("x-btn-text")).click();
		
		String Expmonthyear="August 2023";
		String Date="15";//Storing Date as String 
		
		//Locating MonthYear
		String currentmonthyear=driver.findElement(By.xpath("//div[@class='x-date-picker x-unselectable atap-base-date-picker atap-week-picker']//button")).getText();
		
		//Validating Current Vs Expected
		while(!(currentmonthyear.contains(Expmonthyear)))
		{
			driver.findElement(By.className("x-date-right")).click();
			currentmonthyear=driver.findElement(By.xpath("//div[@class='x-date-picker x-unselectable atap-base-date-picker atap-week-picker']//button")).getText();	
		}
		
		//Locating Date
		driver.findElement(By.xpath("//span[text()="+Date+"]")).click();//Passing "Date" as String
		//We Can't Pass the Variable Name Directly inside Xpath Use Concatenation+
	}
}

