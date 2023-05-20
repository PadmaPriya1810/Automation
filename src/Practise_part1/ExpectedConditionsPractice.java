package Practise_part1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpectedConditionsPractice {
	public static void main(String[] args) {
		
	
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://letcode.in/edit");
	
	//Enter your full Name
	driver.findElement(By.id("fullName")).sendKeys("PriyaRanjith");
	
	//Append a text and press keyboard tab
	driver.findElement(By.id("join")).sendKeys(" Singer",Keys.TAB);
	
	//What is inside the text box
	String text=driver.findElement(By.id("getMe")).getAttribute("value");
	System.out.println(text);
	
	//Clear the text
	driver.findElement(By.id("clearMe")).clear();
	
	
	}
	
}
