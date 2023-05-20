package Logics_To_Learn;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class _24_Naukri_Assignment {
	public static void main(String[] args) throws IOException
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.naukri.com/");
		Actions act=new Actions(driver);	
		WebElement jobs=driver.findElement(By.xpath("//div[text()='Jobs']"));
		act.moveToElement(jobs).perform();
		
		driver.findElement(By.xpath("//div[text()='Jobs in Bangalore']")).click();
	
		WebElement end=driver.findElement(By.xpath("//div[@class='cir']"));
		act.dragAndDropBy(end, -170,0).perform();
		
		String text=driver.findElement(By.xpath("//span[contains(@class,'fleft count-string mr')]")).getText();
		System.out.println(text);
		
		WebElement scrollto=driver.findElement(By.xpath("//a[text()='Sitemap']"));
		
		act.scrollByAmount(0, 3000).perform();
		act.scrollToElement(scrollto).perform(); 
		
		scrollto.click();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./Screenshot/Naukri.png");
		FileUtils.copyFile(src,trg);
	}
}
