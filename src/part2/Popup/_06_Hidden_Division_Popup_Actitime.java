package part2.Popup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _06_Hidden_Division_Popup_Actitime 
{
	public static void main(String[] args)
	{
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		
		driver.findElement(By.id("username")).sendKeys("admin",Keys.TAB,"manager",Keys.TAB,Keys.SPACE,Keys.TAB,Keys.ENTER);
		
		//Tasks
		driver.findElement(By.id("container_tasks")).click();
		
		//Customers Check Box
		driver.findElement(By.xpath("//table[@class='headerRowTable']//div[1]/div")).click();
		
		//Delete Button
		driver.findElement(By.className("delete")).click();
		
		//To Fetch Title Message
		String titlemsg=driver.findElement(By.xpath("//div[contains(@class,'operationConfirmDialog someBlocked')]/div[1]/div[2]")).getText();
		System.out.println(titlemsg);
	}
}
