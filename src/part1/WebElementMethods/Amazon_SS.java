package part1.WebElementMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Amazon_SS 
{
	WebDriver driver;
	
	public static void main(String[] args) throws Exception 
	{
		Amazon_SS ss=new Amazon_SS();
		ss.launchBrowser();
		ss.openApp();
		ss.takeScreenshot();
		ss.closeBrowser();
		
	}
	public void launchBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	public void openApp() throws InterruptedException
	{
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
	}
	
	public void takeScreenshot() throws IOException
	{
		WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
		File src=logo.getScreenshotAs(OutputType.FILE);
		File trg=new File("./Screenshot/AmazonLogo.png");
		FileUtils.copyFile(src,trg);
	}
	
	public void closeBrowser()
	{
		driver.close();
	}

}
