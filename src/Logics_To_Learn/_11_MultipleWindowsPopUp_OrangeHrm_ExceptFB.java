package Logics_To_Learn;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _11_MultipleWindowsPopUp_OrangeHrm_ExceptFB 
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
		
		//Set don't have get(int index) Method
		//So We're Creating an Array List To change the driver focus to Corresponding WebPage Based on Index
		
		ArrayList<String> list=new ArrayList<String>(allpageids);//Creating ArrayList to use get(i)
		//Passing allids inside Constructor - So allids are present inside ArrayList now
		
		//Passing list.get(i) inside window(String nameOrHandle)
		//So that Particular Window Opens based on Index
		
		driver.switchTo().window(list.get(2));//Index 2=FB
		
		//Find FB page Session ID -To Use in "if(Condition)"
		String Fbpageid=driver.getWindowHandle();
	
		//To Get FB Window Title
		System.out.println(driver.getTitle());//OrangeHRM - World's Most Popular Opensource HRIS | Secaucus NJ | Facebook
	
		//Use "for-each" Loop to CLOSE allTabs except FB
		for(String pageid:allpageids)
		{
			if(!(pageid.equals(Fbpageid)))//Not equals Fbpageid
			{
				driver.switchTo().window(pageid);//Switch To Other Pages-Each Page
				driver.close(); //Closes Other Pages Except FB
			}
		}
	}
}
