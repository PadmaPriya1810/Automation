package part1.Locators.Relative_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class Flipkart_Iphone {

	EdgeDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		Flipkart_Iphone f=new Flipkart_Iphone();
		f.launchBrowser();
		f.openApp();
		String product="APPLE iPhone XS";
		f.searchProduct(product);
		String productPrice=f.fetchPrice();
		System.out.println("Product Price : "+productPrice);
		f.closeBrowser();	
	}
	
	public void launchBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	public void openApp() throws InterruptedException
	{
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		Thread.sleep(3000);
	}
	
	public void searchProduct(String product) throws InterruptedException
	{
		driver.findElement(By.name("q")).sendKeys(product);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(3000);
	}
	
	//USING SURROUNDING ELEMENTS
	public String fetchPrice()
	{
		String productPrice=driver.findElement(By.xpath("//div[text()='APPLE iPhone XS (Gold, 512 GB)']/../../div[2]/div[1]/div[1]/div[1]")).getText();
		return productPrice;
	}
	
	//USING FOLLOWING SIBLING
	/*public String fetchPrice()
	{
		String productPrice=driver.findElement(By.xpath("//div[text()='APPLE iPhone XS (Gold, 512 GB)']/../../div[2]/div[1]/div[1]/div[1]")).getText();
		return productPrice;
	}
	 
	 */
	
	
	public void closeBrowser()
	{
		driver.close();
	}
}
