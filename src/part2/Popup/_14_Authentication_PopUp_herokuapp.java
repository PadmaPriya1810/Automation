package part2.Popup;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _14_Authentication_PopUp_herokuapp 
{
	public static void main(String[] args) throws AWTException 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//AUTHENTICATION POPUP 
		//We have to pass the UN & PWD Using Syntax While Opening the URL itself
		//UN:PWD@ ----> admin:admin@ 
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}	
}
