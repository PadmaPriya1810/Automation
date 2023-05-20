package part2.Popup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _14_FileUpload_PopUp_sendKeys_herokuapp 
{
public static void main(String[] args) 
{
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	WebDriver driver=new ChromeDriver(options);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://the-internet.herokuapp.com/upload");
	
	
	//In html type="file" use sendKeys()
	//Locate Choose File Button & inside sendKeys("Path Of The File")
	driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Priya\\Documents\\Selenium\\Selenium Websites.docx");
}
}
