package LetCode;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*		Window Handling Concepts
		close()
		quit()
		getTitle()
		List
		Set - LinkedHashSet
		Iterator or loop
*/
public class _Windows 
{
	public static void main(String[] args) 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://letcode.in/windows");
		
		//To Get Main Page Session Id
		String mainpageid=driver.getWindowHandle();
		System.out.println(mainpageid);//144943FCF4FDB7B1ABCE959D3719D950
		
		System.out.println(driver.getTitle());//Window handling - LetCode -[MainPage Title]
		
		driver.findElement(By.id("home")).click();
		
		System.out.println(driver.getTitle());//Window handling - LetCode -[MainPage Title]
		//Even after New Tab is Opened, still getting the Same Main Page Title 
		//Driver Still focusing on Main Page
		
		
		//To Get All Page ID's
		Set<String> allids=driver.getWindowHandles();
		
		System.out.println(allids);//[144943FCF4FDB7B1ABCE959D3719D950, 9CD1CC551AA287A68AA1AB1BCDDC1BF7]
		
		//Set don't have get(int index) Method
		//So We're Creating an Array List To change the driver focus to Corresponding WebPage Based on Index
		
		ArrayList<String> list=new ArrayList<String>(allids);//Creating ArrayList to use get(i)
		//Passing allids inside Constructor - So allids are present inside ArrayList now
		
		//Passing list.get(i) inside window(String nameOrHandle)
		//So that Particular Window Opens based on Index
		driver.switchTo().window(list.get(0));//index 0- MainPage Window
		System.out.println(driver.getTitle());//Window handling - LetCode
		
		//Changing "driver" focus to New Window
		driver.switchTo().window(list.get(1));//index 1- New Window
		System.out.println(driver.getTitle());//LetCode - Testing Hub
		
		//To Close Parent Window -MainPage
		driver.switchTo().window(list.get(0)).close();
		
		//To Close New Window 
	    driver.switchTo().window(list.get(1)).close();
	    
	    
	    //Again Opening Main Page
	    ChromeOptions options1=new ChromeOptions();
		options1.addArguments("--remote-allow-origins=*");
		
		WebDriver driver1 =new ChromeDriver(options1);
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver1.get("https://letcode.in/windows");
		
    
	    //To Click Multiple Windows Button
	    driver1.findElement(By.id("multi")).click();
	    
	    Set<String> allpageids=driver1.getWindowHandles();
	    
	    //Storing allpageids in ArrayList 
	    ArrayList<String> newlist=new ArrayList<String>(allpageids);
	    		
	    //To Switch the driver focus on Each Page & To Print Each Page Title
	    //Using "for" loop
	     for(int i=0;i<newlist.size();i++)
	    	{
	    		driver1.switchTo().window(newlist.get(i));
	    		System.out.println(driver1.getTitle());
	    	//Printing Each WebPage Title
//	    		Window handling - LetCode
//	    		LetCode with Koushik
//	    		LetCode with Koushik
	 	
	    	}
	}

}
