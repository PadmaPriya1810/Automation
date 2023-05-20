package part1.WebElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class IsSelected_ActiTime
   {
	EdgeDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		IsSelected_ActiTime is=new IsSelected_ActiTime();
		is.launchBrowser();
		is.loginApp();	
	}

	public void launchBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}

	public void loginApp() throws InterruptedException
	{
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(3000);
		WebElement cbox=driver.findElement(By.id("keepLoggedInCheckBox"));
		Point location=cbox.getLocation();
		
		if(cbox.isSelected())
		{
			System.out.println("It is Selected");
		}
		else
		{
		System.out.println("It is Not Selected");
		driver.findElement(By.id("keepLoggedInCheckBox")).click();
		Thread.sleep(3000);
		}
	}
}
