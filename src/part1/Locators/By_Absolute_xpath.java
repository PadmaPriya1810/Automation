package part1.Locators;

//REGISTRATION HTML Code
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class By_Absolute_xpath 
{
public static void main(String[] args) throws InterruptedException
{
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("C:/Users/Priya/Documents/Selenium/Registration.html");
	Thread.sleep(3000);
	
	//For UserName
	driver.findElement(By.xpath("/html/body/input[1]")).sendKeys("Priya");
	//("html/body/input[1]") also working W/O '/'
	
	//For Female
	driver.findElement(By.xpath("/html/body/input[5]")).click();
	
	//For Accept the T&C
	driver.findElement(By.xpath("/html/body/input[7]")).click();
}
}
