package part2.Mouse_Action_Handling;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _04_NewestFirst_Flipkart 
{
	public static void main(String[] args) throws IOException 
	{
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement home=driver.findElement(By.cssSelector("[alt='Home']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(home).perform();
		
		WebElement kandd=driver.findElement(By.linkText("Kitchen & Dining"));
		act.moveToElement(kandd).perform();
		
		WebElement ktools=driver.findElement(By.linkText("Kitchen tools"));
		act.moveToElement(ktools).click().build().perform();
		
        driver.findElement(By.xpath("//div[text()='Newest First']")).click();
        
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'krishnaa enterprises Surya King Non Stick Sandwich Gas')]")));
        
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		File trg=new File("./Screenshot/NewestFirst.png");
		
		FileUtils.copyFile(src, trg);	
	}
}
