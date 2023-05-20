package part2.Keyboard_Stroke_Handling;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Amazon_SeleniumBook
{
	WebDriver driver;
	
	public static void main(String[] args) throws Exception
	{
		Amazon_SeleniumBook a=new Amazon_SeleniumBook();
		a.launchBrowser();
		a.openApp();
		a.searchBar();
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
	
	public void searchBar() throws AWTException, InterruptedException, IOException
	{
		//To Type SELENIUM in SearchBar
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.SHIFT,"selenium");
		Thread.sleep(2000);
		
		//Import "Robot" Class For Keyboard Handling methods keyPress(),keyRelease()
		
		Robot r=new Robot();
		
		//To Select the Text
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		
		//To Delete the Text
		r.keyPress(KeyEvent.VK_DELETE);
		
		//To again Type "selenium book with java" in searchBar
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("selenium book with java",Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.ENTER);
		Thread.sleep(3000);
		
		//To Take ScreenShot of page
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./Screenshot/Selenium with Java.png");
		FileUtils.copyFile(src, trg);	
	}
}
