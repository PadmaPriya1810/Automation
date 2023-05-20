package part2.Mouse_Action_Handling;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class _04_contentClick_Google {
	public static void main(String[] args) throws AWTException {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.co.in/");
		
		WebElement gmail=driver.findElement(By.cssSelector("[aria-label='Gmail (opens a new tab)']"));
		Actions act=new Actions(driver);
		
		act.contextClick(gmail).perform();	
		
		//act.contextClick(gmail).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		
		//Actions class Wont work,opens in Same window
		
		//Use Only Robot Class, opens in New Tab
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);	
	}
}
