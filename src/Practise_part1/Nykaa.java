package Practise_part1;

import org.openqa.selenium.chrome.ChromeDriver;

public class Nykaa 
{
	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Priya\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.nykaa.com/");
		
		driver.manage().window().maximize();
		
		String title=driver.getTitle();
		System.out.println("Title is "+ title);
		
		String url=driver.getCurrentUrl();
		System.out.println("Url is "+ url);
		
		String pagesource=driver.getPageSource();
		System.out.println(pagesource);
		
		driver.manage().window().minimize();
		
		driver.manage().window().fullscreen();
		
		driver.close();
		
		driver.quit();
		
		
	}

}
