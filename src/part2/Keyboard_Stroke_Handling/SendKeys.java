package part2.Keyboard_Stroke_Handling;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SendKeys 
{
	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		SendKeys sk=new SendKeys();
		sk.launchBrowser();
		sk.openApp();
	}
	public void launchBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	public void openApp() throws InterruptedException, AWTException
	{
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("admin");
		
		//Import Robot Class to use keyPress(),keyRelease()
		Robot r=new Robot();
		
		//
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		//r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		//r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		//r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
	}
}
