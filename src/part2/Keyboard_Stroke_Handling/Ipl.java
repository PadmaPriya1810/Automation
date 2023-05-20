package part2.Keyboard_Stroke_Handling;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ipl {
	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		Ipl g=new Ipl();
		g.launchBrowser();
		g.openApp();
		g.keyboardActions();
		
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
	
	public void keyboardActions() throws InterruptedException, IOException
	{
		Actions act=new Actions(driver);
		driver.findElement(By.name("q"));
		act.keyDown(Keys.SHIFT).sendKeys("ipl").perform();
		act.keyUp(Keys.SHIFT).perform();
		Thread.sleep(2000);
		act.sendKeys("ipl").perform();
		Thread.sleep(2000);
		act.keyDown(Keys.CONTROL).sendKeys("a").perform();
		act.keyUp(Keys.CONTROL).perform();
		Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./Screenshot/ipl.png");
		FileUtils.copyFile(src, trg);
		
		Thread.sleep(2000);
		act.keyDown(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("News")).click();
		Thread.sleep(2000);
		String result=driver.findElement(By.id("result-stats")).getText();
		System.out.println(result);
	}
}
