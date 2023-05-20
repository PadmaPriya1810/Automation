package part3.DataDrivenTesting.Properties_File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _26_GenericMethod_getDataFromProperties_ActiTime
{
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\testdata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);	
		String value=pobj.getProperty(key);
		return value; 
	}
	
	public static void main(String[] args) throws IOException 
	{

		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		_26_GenericMethod_getDataFromProperties_ActiTime act=new _26_GenericMethod_getDataFromProperties_ActiTime();
		driver.get(act.getDataFromProperties("url"));
		driver.findElement(By.name("username")).sendKeys(act.getDataFromProperties("username"));
		driver.findElement(By.name("pwd")).sendKeys(act.getDataFromProperties("password"));
		driver.findElement(By.id("loginButton")).click();	
		
	}
}
