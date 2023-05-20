package part1.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/* SCENARIO: 
 * Goto ActiTime
 * Provide UserName & Password
 * Click on CheckBox
 * Click on Login
 * Click On Task
 * Fetch the Title
 */

public class By_cssSelector_ActiTime_Assignment
{
public static void main(String[] args) throws InterruptedException 
{
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://demo.actitime.com/login.do");
	Thread.sleep(3000);
	
	driver.findElement(By.cssSelector("#Username")).sendKeys("admin");//Omit if javaScript Duplicate is there
	
	driver.findElement(By.cssSelector(".textField.pwdfield")).sendKeys("manager");
	
	driver.findElement(By.cssSelector("#keepLoggedInCheckBox")).click();
	
	driver.findElement(By.cssSelector("a#loginButton")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.cssSelector("#container_tasks")).click();
	Thread.sleep(3000);
	
	String title=driver.getTitle();
	System.out.println("Title : "+title);	
}
}
