package part1.Locators.Relative_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class Flipkart_Tv 
{
	EdgeDriver driver;
	
 public static void main(String[] args) throws InterruptedException 
 {
	 Flipkart_Tv tv=new Flipkart_Tv();
	 tv.launchBrowser();
	 tv.openApp();
	 String product="TV";
	 tv.searchTv(product);
	String rating_review= tv.getRatings_Reviews1();
	System.out.println(rating_review);
	 tv.closeBrowser();
	
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
	
 public void searchTv(String product) throws InterruptedException
 {
	 driver.findElement(By.name("q")).sendKeys(product);
	 driver.findElement(By.cssSelector("[type='submit']")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
	 Thread.sleep(3000);
 }
 //USING FOLLOWING SIBLING
// public String getRatings_Reviews()
// {
//	 String ratings=driver.findElement(By.xpath("//div[text()='BeethoSOL 60 cm (24 inch) HD Ready LED TV']/following-sibling::div[1]/span[2]/span/span[1]")).getText();
//	 String reviews=driver.findElement(By.xpath("//div[text()='BeethoSOL 60 cm (24 inch) HD Ready LED TV']/following-sibling::div[1]/span[2]/span/span[3]")).getText();
//	 return "Ratings : "+ratings+"\nReviews : "+reviews;
// }
 
 //USING DESCENDANT
public String getRatings_Reviews1()
{
	String ratings=driver.findElement(By.xpath("//div[text()='BeethoSOL 60 cm (24 inch) HD Ready LED TV']/following-sibling::div[1]/descendant::span[contains(text(),'Ratings')]")).getText();
	String reviews=driver.findElement(By.xpath("//div[text()='BeethoSOL 60 cm (24 inch) HD Ready LED TV']/following-sibling::div[1]/descendant::span[contains(text(),'Reviews')]")).getText();
	return "Ratings : "+ratings+"\nReviews : "+reviews;
}


 public void closeBrowser()
 {
	 driver.close();
 }
}
