package part2.Popup;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _11_FramePopUp_And_NotificationPopUp_Selenium08blogspot
{
	public static void main(String[] args) throws InterruptedException, IOException
	{
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	
	//To Disable Notifications Pop Up
	options.addArguments("--disbale-notifications");
	WebDriver driver=new ChromeDriver(options);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://selenium08.blogspot.com/2019/11/selenium-iframe.html");
	
	driver.switchTo().frame("iframe_a");
	driver.findElement(By.xpath("//font[text()='Free Mock Tests']")).click();
	
	//Thread.sleep(5000);
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.numberOfWindowsToBe(2));//IMPORTANT
    
	Set<String> allpageids=driver.getWindowHandles();
	
	ArrayList<String> list=new ArrayList<String>(allpageids);
	
	driver.switchTo().window(list.get(1));
	
	//Railways
	driver.findElement(By.xpath("//div[@class='cs-topbar']//li[4]")).click();
	
	//ScrollBar
	driver.findElement(By.xpath("//ul[@class='cs-icon-list']/li[7]")).click();
	
	//TCS NQT
	driver.findElement(By.xpath("//a[text()='TCS NQT']")).click();
	
	//To Take ScreenShot
	WebElement tcsmsg=driver.findElement(By.className("cs-filter-bar"));
	File src=tcsmsg.getScreenshotAs(OutputType.FILE);
	File trg=new File("./Screenshot/TCS_NQT.png");
	FileUtils.copyFile(src, trg);
	
    }
}