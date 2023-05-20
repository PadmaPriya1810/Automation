package LetCode;

/*
 * 		On completion of this exercise, you can learn the following concepts.
			sendKeys()
			Keys.TAB
			getAttribute()
			clear()
			isEnabled()
 */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _01_Input 
{
public static void main(String[] args) 
{
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://letcode.in/edit");
	
	//Enter your full Name
	driver.findElement(By.id("fullName")).sendKeys("PriyaRanjith");
	
	//Append a text and press keyboard tab
	driver.findElement(By.id("join")).sendKeys(" Singer",Keys.TAB);
	
	//What is inside the text box
	String text=driver.findElement(By.id("getMe")).getAttribute("value");
	System.out.println(text);
	
	//Clear the text
	driver.findElement(By.id("clearMe")).clear();
	
	//Confirm edit field is disabled
	WebElement editfield=driver.findElement(By.id("noEdit"));
	
	if(editfield.isEnabled())
	{
		System.out.println("Enabled");
	}
	else
		System.out.println("Disabled");
	
	//Confirm text is readonly
	String readonlyfield=driver.findElement(By.id("dontwrite")).getAttribute("readonly");
	//Next to value u can find "readonly" in HTML Code
	
	System.out.println(readonlyfield);//true
	
	if(readonlyfield.equals(true))//Checking using Condition
	{
		System.out.println("Read Only");	
	}
	else
		System.out.println("Readable & Writable");
	
}
}
