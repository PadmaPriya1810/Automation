package Practise_Part2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _11_MultipleWindows_OrangeHRM 
{
	public static void main(String[] args)
	{
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	WebDriver driver=new ChromeDriver(options);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[1]")).click();		
	driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[2]")).click();	
	driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[3]")).click();	
	
	Set<String> allpageids=driver.getWindowHandles();
	ArrayList<String> list=new ArrayList<String>(allpageids);		
	
	driver.switchTo().window(list.get(2));
	String Fbpageid=driver.getWindowHandle();
		
	System.out.println(driver.getTitle());
	for(String pageid:allpageids)
		{
			if(!(pageid.equals(Fbpageid)))
				{
					driver.switchTo().window(pageid);
					driver.close(); 
				}
		}
}
}