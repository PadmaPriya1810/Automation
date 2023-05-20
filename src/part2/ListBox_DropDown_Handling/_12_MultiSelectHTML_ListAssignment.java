package part2.ListBox_DropDown_Handling;

import java.time.Duration;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class _12_MultiSelectHTML_ListAssignment 
{
	public static void main(String[] args) 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("file:///C:/Users/Priya/Documents/Selenium/MultiselectDropdownWithDuplicates.html");
		WebElement dd=driver.findElement(By.id("Students"));
		
		Select s=new Select(dd);
		List<WebElement> allstudents=s.getOptions();
	
		//USING "for" Loop To Select First 2 Options and To Fetch The Remaining Unselected Options
		for(int i=0;i<allstudents.size();i++)
		{
			if(i<=2)
			{
				s.selectByIndex(i);
			}
			else if(i>2)
			{
				System.out.println(s.getOptions().get(i).getText());
			}	
		}
}
}