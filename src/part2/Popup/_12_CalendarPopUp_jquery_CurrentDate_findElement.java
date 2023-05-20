package part2.Popup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _12_CalendarPopUp_jquery_CurrentDate_findElement
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
		//To Click the Current Date
		driver.findElement(By.className("ui-state-highlight")).click();
		
		//To Fetch The Current Date
		System.out.println(driver.findElement(By.className("ui-state-highlight")).getText());//13
		
		
		
		
	}
}
