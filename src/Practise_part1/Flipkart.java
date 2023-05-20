package Practise_part1;

import org.openqa.selenium.WebElement;

//SCENARIO :- LAUNCH CHROME BROWSER & OPEN FLIPKART

import org.openqa.selenium.chrome.ChromeDriver; //"ChromeDriver" Class Package

public class Flipkart 
{
	public static void main(String[] args) 
	{
	
	//TO CONFIGURE BROWSER SERVER (Chrome)
		//System.setProperty(String key,String value);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Priya\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
	//TO LAUNCH CHROME BROWSER
		//Import & Create Object for "ChromeDriver" Class
		ChromeDriver driver=new ChromeDriver();
		
		
	//TO OPEN APPLICATION (FLIPKART)
		//get(String url);
		driver.get("https://www.flipkart.com/");

}
}