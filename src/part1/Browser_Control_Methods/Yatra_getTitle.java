package part1.Browser_Control_Methods;

import org.openqa.selenium.chrome.ChromeDriver;

public class Yatra_getTitle {
public static void main(String[] args) {
	ChromeDriver driver=new ChromeDriver();
	
	//TO GET YATRA PAGE
	driver.get("https://www.yatra.com/");
	
	//TO MAXIMIZE THE WINDOW
	driver.manage().window().maximize();
	
	//TO GET THE TITLE
	String title=driver.getTitle();
	System.out.println("Title is: "+title);
	
	driver.manage().window().fullscreen();
	
}
}
