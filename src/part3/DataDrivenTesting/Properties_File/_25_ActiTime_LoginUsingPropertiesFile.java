package part3.DataDrivenTesting.Properties_File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _25_ActiTime_LoginUsingPropertiesFile 
{
	public static void main(String[] args) throws IOException 
	{
	
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\testdata.properties");
		
		Properties pobj=new Properties();
		pobj.load(fis);
		
		//getProperty(String Key)-Returns value
		String Url=pobj.getProperty("url");
	   //Passing Stored value inside get()
		driver.get(Url);
		
		String Username=pobj.getProperty("username");
		driver.findElement(By.name("username")).sendKeys(Username);
		
		String Password=pobj.getProperty("password");
		driver.findElement(By.name("pwd")).sendKeys(Password);
		driver.findElement(By.id("loginButton")).click();
		
	}
}
