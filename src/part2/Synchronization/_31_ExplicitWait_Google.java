package part2.Synchronization;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _31_ExplicitWait_Google
{
	public static void main(String[] args) throws InterruptedException
	{
        WebDriver driver=new EdgeDriver();          
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("selenium");
		List<WebElement> allsugg=driver.findElements(By.xpath("//ul//li"));
		
		for(WebElement sugg:allsugg)
		{
		String sugName=sugg.getText();
			if(sugName.contains("webdriver"))	
			{
			   sugg.click();
			   break; 
			}         
       }
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        String result=driver.findElement(By.id("result-stats")).getText();
        System.out.println(result);	
	}
}
