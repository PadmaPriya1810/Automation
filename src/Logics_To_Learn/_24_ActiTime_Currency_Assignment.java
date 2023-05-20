package Logics_To_Learn;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class _24_ActiTime_Currency_Assignment {
	public static void main(String[] args) throws IOException
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("keepLoggedInCheckBox")).click();
		driver.findElement(By.id("loginButton")).click();
		
		driver.findElement(By.xpath("//div[@class='popup_menu_button popup_menu_button_settings ']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'  General Settings')]")).click();
		
		Actions act=new Actions(driver);
		act.scrollByAmount(0, 2000).perform();
		WebElement currency=driver.findElement(By.id("currencySignFieldPredefined"));
		act.scrollToElement(currency).click().perform(); 
		
		Select s=new Select(currency);
		List<WebElement> allcurrency=s.getOptions();
		
		for(WebElement wb:allcurrency)
		{
			System.out.println(wb.getText());
		}
		
	}
}
