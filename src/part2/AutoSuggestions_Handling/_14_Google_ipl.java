package part2.AutoSuggestions_Handling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _14_Google_ipl 
{
public static void main(String[] args) throws InterruptedException 
{
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.google.com/");
	//Thread.sleep(2000);
	
	//To Pass ipl
	driver.findElement(By.name("q")).sendKeys("ipl");
	
	List<WebElement> allsugg=driver.findElements(By.xpath("//div[@class='mkHrUc']//li"));//Remember -//li -Mandatory-
	
	for(WebElement sugg:allsugg)
	{
		System.out.println(sugg.getText());
	}
}
}
