package part2.ListBox_DropDown_Handling;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class _03_DropDown_ActiTime_UserGroups 
{
public static void main(String[] args) 
{
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://demo.actitime.com/login.do");
	driver.findElement(By.id("username")).sendKeys("admin",Keys.TAB,"manager",Keys.TAB,Keys.SPACE,Keys.TAB,Keys.ENTER);
	driver.findElement(By.cssSelector(".popup_menu_button.popup_menu_button_settings ")).click();
	driver.findElement(By.xpath("//div[text()='Manage system settings & configure actiTIME']/preceding-sibling::div")).click();

	//User Groups DropDown Location
	WebElement dropdown=driver.findElement(By.id("userGroupNamingCodeSelect"));
	
	//Create Object for "Select" Class to use getOptions()-To Fetch All The Options Present in the DropDown
	Select s=new Select(dropdown);
	
	List<WebElement> allgroups=s.getOptions();
	
	//Create ArrayList to Use "sort(List l)" -Accepts only list
	ArrayList alist=new ArrayList();
	
	System.out.println("BEFORE SORTING");
	
	for(int i=0;i<allgroups.size();i++)
	{
		alist.add(allgroups.get(i).getText());
	}
	System.out.println(alist);//[-- custom name --, Department, Cost Center, Location, Team, User Group]
	
	//SORT
	Collections.sort(alist);
	
	System.out.println("\nAFTER SORTING");
	
		System.out.println(alist);//[-- custom name --, Cost Center, Department, Location, Team, User Group]
}
}
