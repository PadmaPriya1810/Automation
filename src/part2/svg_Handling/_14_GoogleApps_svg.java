package part2.svg_Handling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _14_GoogleApps_svg 
{
public static void main(String[] args)
{
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.google.com/");
	
	//svg Handling
	//If Element is Present in svg Tag- Eg:Google Apps --> <svg class="gb_Be" >
	//Have to Use xpath as -To Find all svg Elements use --> //*[name()='svg']
	
	driver.findElement(By.xpath("//*[name()='svg' and @class='gb_Be']")).click();
	
}
}
