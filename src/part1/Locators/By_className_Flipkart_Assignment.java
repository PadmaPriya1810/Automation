package part1.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/* Goto Flipkart
 * Close the Login page
 * Search for toys
 * Fetch the title -Toys
 */
public class By_className_Flipkart_Assignment 
{
public static void main(String[] args) throws InterruptedException
{
	ChromeDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	
	//To Click Close Login Pop-Up Close Button
	driver.findElement(By.className("_2doB4z")).click();
	
	//To Enter "toys" text in Search Box
	driver.findElement(By.className("_3704LK")).sendKeys("toys");
	
	//To Click "Search" Icon
	driver.findElement(By.className("_34RNph")).click();
	Thread.sleep(3000);//To Get The Title Properly Coz it takes some time to Load 
	
	String title=driver.getTitle();
	System.out.println("Title is: "+title);
	//Title is: Toys- Buy Products Online at Best Price in India - All Categories | Flipkart.com

}
}
