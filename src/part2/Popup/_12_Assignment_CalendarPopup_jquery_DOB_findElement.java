package part2.Popup;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _12_Assignment_CalendarPopup_jquery_DOB_findElement
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
		
		driver.findElement(By.id("datepicker")).click();
		

		String expdate="18";
		String expmonth="October";
		String expyear="1988";

		
		String currentmonth=driver.findElement(By.className("ui-datepicker-month")).getText();
		String currentyear=driver.findElement(By.className("ui-datepicker-year")).getText();
		
		while(!(currentmonth.equalsIgnoreCase(expmonth)&&(currentyear.equals(expyear))))
				
				{
					//Locate Previous Button
					WebElement previous=driver.findElement(By.xpath("//span[text()='Prev']"));
					previous.click();
					//Re-Initializing
					currentmonth=driver.findElement(By.className("ui-datepicker-month")).getText();
					currentyear=driver.findElement(By.className("ui-datepicker-year")).getText();
				}
		
		driver.findElement(By.linkText("31")).click();//Pass Date Directly
		
		//OR
//		
//		List<WebElement> alldates=driver.findElements(By.xpath("//a[@class='ui-state-default']"));
//		
//		for(WebElement date:alldates)
//		{
//			if(date.getText().equals(expdate))
//			{
//				date.click();
//				break;
//			}
			
		}
}
