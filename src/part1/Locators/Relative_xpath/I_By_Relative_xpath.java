package part1.Locators.Relative_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/* USING RELATIVE PATH
 * Goto Registration Page
 * Provide the UserName
 * Click on Male
 * Click on Accept the T&C
 */
public class I_By_Relative_xpath 
{
public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("C:\\Users\\Priya\\Documents\\Selenium\\Registration.html");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[1]")).sendKeys("Ranjith");
	driver.findElement(By.xpath("//input[4]")).click();
	driver.findElement(By.xpath("//input[7]")).click();
	
}
}
