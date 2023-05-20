package Logics_To_Learn;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _05_Flipkart_Test_Iphone_Name_Price_Using_List 
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
	
	//Finding all 24 iphone names
	List<WebElement> alliphone=driver.findElements(By.xpath("//div[starts-with(text(),'APPLE iPhone ')]"));//24 Elements
	
	//Finding all 24 iphone prices
	List<WebElement> allprice=driver.findElements(By.xpath("//div[starts-with(text(),'APPLE iPhone ')]/../../div[2]/div[1]/div[1]/div[1]"));//24 Elements
	
	//Loop till alliphones
	for(int i=0;i<alliphone.size();i++)
	{
		WebElement iphone=alliphone.get(i);//Taking Each "iphone" WebElement by index
		WebElement price=allprice.get(i);//Taking Each "price" WebElement by index
		
		System.out.println(iphone.getText()+"------>"+price.getText());//Printing Using Concat
	}
}
}
