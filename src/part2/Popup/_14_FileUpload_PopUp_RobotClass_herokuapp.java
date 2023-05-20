package part2.Popup;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class _14_FileUpload_PopUp_RobotClass_herokuapp 
{
	public static void main(String[] args) throws AWTException 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/upload");
		
		//If we don't have type="file" have to go with Robot Class
		
		//To Locate Upload/Drag&Drop Box
		driver.findElement(By.id("drag-drop-upload")).click();
		
		//To Select File Path use StringSelection <C> -java.awt.datatransfer 
		StringSelection path=new StringSelection("C:\\Users\\Priya\\Documents\\Selenium\\Selenium Websites.docx");
		
		//To Access System ClipBoard
		Clipboard cb=Toolkit.getDefaultToolkit().getSystemClipboard();
		
		//To Copy the Path into System Clipboard
		cb.setContents(path, null);//null in our own system //Companies will provide path in case of shared system
		
		//To Paste Use Robot Class
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
//		CANNOT PERFORM BY USING ACTIONS CLASS -TRIED
//		Actions act=new Actions(driver);
//		act.keyDown(Keys.CONTROL).sendKeys("v").perform();
//		act.keyUp(Keys.CONTROL).perform();
//		act.keyDown(Keys.ENTER).perform();
//		act.keyUp(Keys.ENTER).perform();
	}
}
