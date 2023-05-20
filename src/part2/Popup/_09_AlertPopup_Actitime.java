package part2.Popup;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _09_AlertPopup_Actitime
{
	public static void main(String[] args)
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		
		//Login
		driver.findElement(By.id("username")).sendKeys("admin",Keys.TAB,"manager",Keys.TAB,Keys.SPACE,Keys.TAB,Keys.ENTER);
	
		//Settings
		driver.findElement(By.cssSelector(".popup_menu_button.popup_menu_button_settings ")).click();
		
		//Types Of Work
		driver.findElement(By.linkText("Types of Work")).click();
		
		//Create Type Of Work
		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		
		//Enter Name & Cancel
		driver.findElement(By.name("name")).sendKeys("Priya Ranjith");
		driver.findElement(By.xpath("//input[@onclick='handleCancel();']")).click();
		
		//Switch To Alert
		Alert alt=driver.switchTo().alert();
		
		//Fetch Message From Alert
		System.out.println("Alert Message : "+alt.getText());
		
		//Cancel
		alt.dismiss();
	}

}
