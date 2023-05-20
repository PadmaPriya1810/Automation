package part1.Browser_Control_Methods;

import org.openqa.selenium.chrome.ChromeDriver;

public class Cowin_getCurrentUrl {
	public static void main(String[] args) 
	{
		
		//TO LAUNCH THE CHROME BROWSER
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.cowin.gov.in/"); //Pass the Url - void get(String url)
		
		//TO GET THE TITLE OF THE WEBPAGE
		String title=driver.getTitle(); //String getTitle();
		
		//TO GET URL OF THE WEBPAGE
		String url=driver.getCurrentUrl(); //String getCurrentUrl();
		
		System.out.println("Title is "+title );
		System.out.println("URL is "+url );
		
	}

}
