package part2.Scrolling;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;

public class _30_Selenium_Scrolling 
{
	public static void main(String[] args) throws IOException 
	{
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		//IMPLICIT WAIT
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/");
		driver.findElement(By.xpath("//span[text()='Documentation']")).click();
		driver.findElement(By.id("m-documentationwebdriver")).click();
		driver.findElement(By.id("m-documentationwebdriveractions_api")).click();
		driver.findElement(By.id("m-documentationwebdriveractions_apiwheel-li")).click();
		
		//Finding Location Of The Particular Element To Scroll Upto That Element is Visible
		WebElement scrollto=driver.findElement(By.xpath("//a[text()='Scroll from a offset of origin (element) by given amount']"));
		
		
		//Object Creation For "Action class" to use "scrollToElement()" -It'll Scroll Upto that Particular Element
		Actions act=new Actions(driver);
		act.scrollByAmount(0, 2900).perform();
		act.scrollToElement(scrollto).perform(); //Passing "scrollto" Object Reference
		
		//ScrollOrigin -Scrolling in WebElement Level(Another ScrollBar inside WebPage)
		
		//First Find the Location Of Scrolling Origin
		WebElement scrollelement=driver.findElement(By.xpath("//p[contains(text(),'Note that if the offset from the upper')]/following-sibling::div[1]"));//CHECK-No 
		ScrollOrigin se=ScrollOrigin.fromElement(scrollelement);
		act.scrollFromOrigin(se, 300, 0).perform();
		
		
		
		//TAKE SCREENSHOT
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./Screenshot/Scroll.png");
		FileUtils.copyFile(src, trg);
		
		
	}

	
}
