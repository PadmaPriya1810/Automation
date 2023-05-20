package part1.Locators;

//sendKeys() ---> To Enter "Any Text" Inside WebElement
//click() ---> To Click that Particular WebElement

import org.openqa.selenium.By;//"By" -> Class
import org.openqa.selenium.WebElement;//"WebElement" -> Interface having findElement()
import org.openqa.selenium.chrome.ChromeDriver;

public class By_name_Google 
{
	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//TO OPEN GOOGLE
		driver.get("https://www.google.com/");
		
		//TO FIND "Search TextField" LOCATION
		By searchLoc=By.name("q");//Finding Location Of SearchBox using By.name()
		
		//TO FIND "Search TextField" WebElement
		WebElement searchBox=driver.findElement(searchLoc);//Passing SearchLocation inside findElement() to get the "SearchBox" WebElement
		
		//TO ENTER "Any Text" Inside "Search TextField"
		searchBox.sendKeys("Abdul Kalam");//Passing "Abdul Kalam" in Search Box
		
		//ElementNotInteractableException
		
		//Thread.sleep(3000);
		
		//TO FIND "Google Search" BUTTON LOCATION
		By gsearchLoc=By.name("btnK");//Finding "Google Search" Button Location
		
		//TO FIND "Google Search" BUTTON WebElement
		WebElement gsearchButton=driver.findElement(gsearchLoc);//Passing Location to the findElement() to get the "Google Search" Button WebElement 
		
		//To Click "Google Search" Button
		gsearchButton.click();
		
		
		
		//To Get the Title Of WebPage
		String title=driver.getTitle();
		System.out.println("Title is :"+title);
	}

}
