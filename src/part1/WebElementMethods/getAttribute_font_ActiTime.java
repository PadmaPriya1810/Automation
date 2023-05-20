package part1.WebElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class getAttribute_font_ActiTime
{
	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		getAttribute_font_ActiTime f=new getAttribute_font_ActiTime();
		f.launchBrowser();
		f.openApp();
		String emessage=f.errorMessage();
		
		//To Validate Error Message
		String message="Username or Password is invalid. Please try again.";
		if(message.equals(emessage))
		{
			System.out.println("TestCase is Pass");
			
		}
		else
			System.out.println("TestCase is Fail");
		
		f.closeBrowser();
	}
	
	public void launchBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	public void openApp() throws InterruptedException
	{
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(2000);
	}
	
	public String errorMessage() throws InterruptedException
	{
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(2000);
		
		//To Find the Location Of Error Msg -Store in WebElement to use getCssValue()
		WebElement errmsg=driver.findElement(By.xpath("//span[contains(text(),'Password is invalid')]"));
		
		//To Get/Fetch Error Message
		String emessage=errmsg.getText();
		
		//To Check the Font use getCssValue()
		String font=errmsg.getCssValue("font");
		System.out.println("Font is : "+font);
		return emessage;	
	}
	
	public void closeBrowser()
	{
		driver.close();
	}

}
