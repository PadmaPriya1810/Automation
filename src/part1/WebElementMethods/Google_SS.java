package part1.WebElementMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Google_SS 
{
	WebDriver driver;
	
	public static void main(String[] args) throws Exception 
	{
		Google_SS ss=new Google_SS();
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
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
	}
	
	public void takeScreenshot() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./Screenshot/Google.png");
		FileUtils.copyFile(src,trg);
	}

	public void closeBrowser()
	{
		driver.close();
	}
}
