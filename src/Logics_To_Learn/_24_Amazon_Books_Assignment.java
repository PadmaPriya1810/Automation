package Logics_To_Learn;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class _24_Amazon_Books_Assignment 
{
	public static void main(String[] args) throws IOException 
	{
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Books",Keys.ENTER);
	
	driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'][1]")).click();
	
	String mainid=driver.getWindowHandle();
	Set<String> allSessionids=driver.getWindowHandles();
	
	for(String id:allSessionids)
	{
		if(!mainid.equals(id))
		driver.switchTo().window(id);
	}
	
	driver.findElement(By.xpath("//span[contains(text(),'Advanced Search')]")).click();
	
	//CATEGORY
	WebElement category=driver.findElement(By.id("category"));
	Select s1=new Select(category);
	s1.selectByVisibleText("Politics");
	
	//Format
	WebElement format=driver.findElement(By.name("field-binding_browse-bin"));
	Select s2=new Select(format);
	s2.selectByVisibleText("Paperback");
	
	//Language
	WebElement language=driver.findElement(By.name("field-feature_browse-bin"));
	Select s3=new Select(language);
	s3.selectByVisibleText("English");
	
	//Year
	driver.findElement(By.name("field-dateyear")).sendKeys("1990");
	
	//Month
	WebElement month=driver.findElement(By.name("field-datemod"));
	Select s4=new Select(month);
	s4.selectByVisibleText("4");
	
	//Price
	WebElement price=driver.findElement(By.name("field-price"));
	Select s5=new Select(price);
	s5.selectByVisibleText("₹200 - ₹500");
	
	//Sort Price
	WebElement sort=driver.findElement(By.name("sort"));
	Select s6=new Select(sort);
	s6.selectByVisibleText("Price: Low to High");
	
	//Search Image Button
	driver.findElement(By.name("Adv-Srch-Books-Submit")).click();
	
	//ENTIRE WEBPAGE SCREENSHOT
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File trg=new File("./Screenshot/AmazonBooks1.png");
	FileUtils.copyFile(src, trg);
	}
}
