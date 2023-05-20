package part1.WebElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

//With TestCase Validation
public class Naukri 
{
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		Naukri n=new Naukri();
		n.launchBrowser();
		n.openApp();
		n.fetchDetails();
		n.closeBrowser();
	}

	public void launchBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	public void openApp() throws InterruptedException
	{
    	driver.get("https://www.naukri.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Companies")).click();
		Thread.sleep(2000);
		
	}
	
	public void fetchDetails() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='filter-content-outer with-margin']//a//i")).click();
		WebElement result=driver.findElement(By.className("subhead"));
		Thread.sleep(2000);
		
		String showresult=result.getText();
		System.out.println("Result is : "+ showresult);
		Thread.sleep(2000);
		
		String colour=result.getCssValue("color");
		System.out.println("Colour is : "+colour);
		
		Dimension size=result.getSize();
		System.out.println("Width & Height is : "+size);
		
		String tagname=result.getTagName();
		System.out.println("TagName is : "+tagname);	
	}
	
	public void closeBrowser()
	{
		driver.close();
    }
}
