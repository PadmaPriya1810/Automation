package part1.Locators;
/* Provide UN
	Provide Pwd
	Click on Login and 
	Fetch the Current Url
*/

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class By_Locators_OrangeHrm {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);//Use Thread to Avoid Exception
		driver.findElement(By.name("username")).sendKeys("Admin");//NoSuchElementException
		driver.findElement(By.className("oxd-input--active")).sendKeys("admin123");
		driver.findElement(By.className("oxd-button")).click();
		String URL=driver.getCurrentUrl();
		System.out.println(URL);
	}

}
