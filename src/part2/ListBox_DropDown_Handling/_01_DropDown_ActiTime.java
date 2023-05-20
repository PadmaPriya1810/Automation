package part2.ListBox_DropDown_Handling;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

//Goto ActiTime 
//Click on Settings 
//Click on General Settings "Top Grouping level" DropDown 
//Select "Product Line"
//Take Screenshot of "Modification not saved" Element SS

public class _01_DropDown_ActiTime 
{
	public static void main(String[] args) throws IOException 
	{
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin",Keys.TAB,"manager",Keys.TAB,Keys.SPACE,Keys.ENTER);
		driver.findElement(By.cssSelector(".popup_menu_button.popup_menu_button_settings ")).click();
		driver.findElement(By.xpath("//div[text()='Manage system settings & configure actiTIME']/preceding-sibling::div")).click();
		WebElement wb=driver.findElement(By.id("firstHierarchyLevelCodeSelect"));
		
		//USING "Select" CLASS FOR DROPDOWN SELECTION
		Select s=new Select(wb);
		s.selectByVisibleText("Product Line");
		
		//FOR WEBELEMENT SCREENSHOT
		WebElement mod=driver.findElement(By.id("FormModifiedTextCell"));
		File src=mod.getScreenshotAs(OutputType.FILE);
		File trg=new File("./Screenshot/Modification.png");
		FileUtils.copyFile(src, trg);	
	}
}
