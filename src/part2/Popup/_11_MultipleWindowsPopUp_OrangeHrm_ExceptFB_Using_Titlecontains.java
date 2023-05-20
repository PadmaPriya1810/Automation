package part2.Popup;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _11_MultipleWindowsPopUp_OrangeHrm_ExceptFB_Using_Titlecontains 
{
	public static void main(String[] args) 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//LOGIN /MainPage --Index=0
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//Click LinkedIn --Index=1
		driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[1]")).click();
		
		//Click FB --Index=2
		driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[2]")).click();
		
		//Click Twitter --Index=3
		driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[3]")).click();
		
		//Returns AllTabs Session ID's
		Set<String> allpageids=driver.getWindowHandles();
		
		for(String id:allpageids)
		{
			driver.switchTo().window(id);
			String title=driver.getTitle();//Fetches all pages's Title
			//System.out.println(title);
			
			//if(!(title.equals("OrangeHRM - World's Most Popular Opensource HRIS | Secaucus NJ | Facebook")))
			if(!(title.contains("Facebook")))
			{
				driver.switchTo().window(id);
				driver.close();
			}
			else
				System.out.println(driver.getTitle());//To Fetch FB Title
		}
}
}
