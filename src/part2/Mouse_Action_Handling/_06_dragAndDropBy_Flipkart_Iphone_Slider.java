package part2.Mouse_Action_Handling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _06_dragAndDropBy_Flipkart_Iphone_Slider
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("Iphonex");
		driver.findElement(By.cssSelector("[type='submit']")).click();
		WebElement start=driver.findElement(By.xpath("(//div[contains(@class,'FdLqY')])[1]"));
		WebElement end=driver.findElement(By.xpath("(//div[contains(@class,'FdLqY')])[2]"));
		Actions act=new Actions(driver);
		act.dragAndDropBy(start, 40, 0).perform();
		//Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Clear all']")));
		act.dragAndDropBy(end, -40,0).perform();
		
	}
}
