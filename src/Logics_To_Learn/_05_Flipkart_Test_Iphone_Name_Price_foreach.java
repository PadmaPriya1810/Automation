package Logics_To_Learn;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _05_Flipkart_Test_Iphone_Name_Price_foreach
{
	public static void main(String[] args) 
	{
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.xpath("//button[text()='✕']")).click();
	driver.findElement(By.name("q")).sendKeys("Iphonex");
	driver.findElement(By.cssSelector("[type='submit']")).click();
	
	List<WebElement> alliphone=driver.findElements(By.xpath("//div[starts-with(text(),'APPLE iPhone ')]"));
	
	for(WebElement iphone:alliphone)
	{
		String iphonename=iphone.getText();//Storing Iphone names
		
		//Finding Price For 1st Element //Passing "ProductName" in "for each" loop
		//Each time Product name changes // So Surrounding Element also gets Changed
		
		String price=driver.findElement(By.xpath("//div[text()='"+iphonename+"']/../../div[2]/div[1]/div[1]/div[1]")).getText();
		System.out.println(iphonename+" ------> "+price);
	}
  }
}
