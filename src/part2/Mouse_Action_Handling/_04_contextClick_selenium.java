package part2.Mouse_Action_Handling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class _04_contextClick_selenium {
	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.selenium.dev/");
		WebElement downloads=driver.findElement(By.xpath("//span[text()='Downloads']"));
		Actions act=new Actions(driver);
		act.click(downloads).perform();
		
		WebElement documentation=driver.findElement(By.xpath("//p[starts-with(text(),'To use the Selenium Server in a Grid')]/a"));
		act.contextClick(documentation).perform();
}
}