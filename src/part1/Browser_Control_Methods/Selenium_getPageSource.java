package part1.Browser_Control_Methods;

import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_getPageSource {
	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		
		//TO MAXIMIZE THE PAGE
		driver.manage().window().maximize();
		
		//TO GET SOURCE CODE
		String sourcecode=driver.getPageSource();
		System.out.println(sourcecode);
		
		//TO CLOSE
		driver.close();
		
	}

}
