package part1.Browser_Control_Methods;

import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome_Google_Flipkart {
public static void main(String[] args) {
	ChromeDriver driver=new ChromeDriver();
	
	//TO OPEN GOOGLE
	driver.get("https://www.google.com/");
	
	//TO MAXIMIZE THE WINDOW
	driver.manage().window().maximize();
	
	//TO OPEN FLIPKART
	driver.get("https://www.flipkart.com/");
	

}
}
