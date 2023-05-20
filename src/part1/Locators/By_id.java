package part1.Locators;

//LOCATORS - 1.BY.id(String id_attribute_value)

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class By_id
{
	public static void main(String[] args) 
	{
		//TO LAUNCH THE BROWSER
		ChromeDriver driver=new ChromeDriver();
		
		//TO MAXIMIZE THE WINDOW
		driver.manage().window().maximize();
		
		//To Goto ebay
		driver.get("https://www.ebay.com/");
		
		//TO GET THE LOCATION by using By.id()---> "Search for anything" i.e Search TextField
		By searchLoc=By.id("gh-ac");//Import "By" class since id() is Static() present in "By" Class
		//id="gh-ac" in HTML code
		
		
		//TO IDENTIFY THE WebElement ("searchBox") in the WebPage using findElement(By Passing Location)
		WebElement searchBox=driver.findElement(searchLoc);//
		
		
		//TO Pass Any Value to the WebElement -sendKeys("value") i.e mobiles
		searchBox.sendKeys("mobiles");//sendKeys -Non-Static() in ??
	}

}
