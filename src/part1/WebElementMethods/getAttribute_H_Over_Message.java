package part1.WebElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class getAttribute_H_Over_Message {
	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(3000);
		WebElement check=driver.findElement(By.id("keepLoggedInCheckBox"));
		String h_over=check.getAttribute("title");
		System.out.println(h_over);
	}

}
