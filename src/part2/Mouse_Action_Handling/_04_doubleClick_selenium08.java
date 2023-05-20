package part2.Mouse_Action_Handling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class _04_doubleClick_selenium08 {
	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		WebElement search=driver.findElement(By.cssSelector(".post-share-buttons.post-share-buttons-bottom"));
		Actions act=new Actions(driver);
		//act.scrollByAmount(0, 1000).perform();
		//act.moveToElement(search).perform();
		act.doubleClick(search).perform();
	}

}
