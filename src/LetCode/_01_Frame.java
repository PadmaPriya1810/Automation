package LetCode;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _01_Frame {
public static void main(String[] args) {
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
	
	//SWITCH TO PARTICULAR FRAME USING Frame-id
	driver.switchTo().frame("iframeResult");
	driver.findElement(By.xpath("//button[text()='Try it']")).click();
	
	//ALERT/POPUP Came
	
	//SWITCH TO PARTICULAR ALERT
	Alert alert=driver.switchTo().alert();
	alert.sendKeys("Priya");//TO PASS NAME IN ALERT TEXTBOX
	alert.accept();//MUST USE accept() -To Click "OK" Button
	
	//TO FETCH MESSAGE
	
	String message=driver.findElement(By.id("demo")).getText();
	System.out.println(message);
	
	
	//NOT IN HOMEWORK BUT TRIED
	//TO COME OUT OF THAT FRAME
	driver.switchTo().parentFrame();//frame-1
	
	//If there are more than 2 frames present in a window
	driver.switchTo().parentFrame();//frame-2
	driver.switchTo().parentFrame();//frame-1
}
}
