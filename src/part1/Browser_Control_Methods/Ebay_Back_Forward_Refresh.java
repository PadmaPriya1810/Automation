package part1.Browser_Control_Methods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ebay_Back_Forward_Refresh {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();

		driver.get("https://www.ebay.com/");
	
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
		
		//TO NAVIGATE BACK
		driver.navigate().back();
		
		String title=driver.getTitle();
		System.out.println("Title is :" +title);
		
		//TO NAVIGATE FORWARD
		driver.navigate().forward();
		
		//TO NAVIGATE REFRESH
		driver.navigate().refresh();
		
		String url=driver.getCurrentUrl();
		System.out.println("URL is: "+url);
		
		//TO SET THE SIZE OF BROWSER
		driver.manage().window().setSize(new Dimension(200,300));
		
		//TO SET THE POSITION OF BROWSER
		driver.manage().window().setPosition(new Point(100,100));
		
		driver.manage().window().fullscreen();
		
		
	}
}
