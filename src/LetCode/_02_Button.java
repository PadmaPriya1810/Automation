package LetCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class _02_Button 
{
 public static void main(String[] args)
 {
	 ChromeOptions options=new ChromeOptions();
	 options.addArguments("--remote-allow-origins=*");
	 WebDriver driver=new ChromeDriver(options);
	 driver.manage().window().maximize();
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	 driver.get("https://letcode.in/buttons");
	 
	 driver.findElement(By.id("home")).click();
	 System.out.println(driver.getTitle());//LetCode with Koushik
	 
	 driver.navigate().back();
	 System.out.println(driver.getTitle());//Interact with Button fields
	 
	 WebElement loc=driver.findElement(By.id("position"));
	 System.out.println(loc.getLocation());//(79, 338)
	 
	WebElement color= driver.findElement(By.id("color"));
	System.out.println(color.getCssValue("color"));//rgba(255, 255, 255, 1)
	
	WebElement size=driver.findElement(By.id("property"));
	System.out.println(size.getSize());//(176, 40)
	
	WebElement disablebutton=driver.findElement(By.id("isDisabled"));
	if(disablebutton.isEnabled())
	{
		System.out.println("Enabled");
	}
	else
		System.out.println("Disabled");//Disabled
	
	WebElement clickandhold=driver.findElement(By.xpath("//h2[text()='Button Hold!']"));
	
	Actions act=new Actions(driver);
	act.clickAndHold(clickandhold);//??
	
	
 }
}
