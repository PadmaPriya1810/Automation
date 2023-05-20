package part2.Mouse_Action_Handling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class _03_moveToElement_Flipkart 
{
public static void main(String[] args)
{
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.xpath("//button[text()='✕']")).click();
	
	//Find Electronics Location
	WebElement electronics=driver.findElement(By.cssSelector("[alt='Electronics']"));
	
	//Create Object For "Actions" Class to use moveToElement(WebElement wb)
	Actions act=new Actions(driver);
	act.moveToElement(electronics).perform();//perform()- Always Remember
	
}
}
