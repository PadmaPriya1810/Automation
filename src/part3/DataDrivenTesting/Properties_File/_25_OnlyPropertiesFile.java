package part3.DataDrivenTesting.Properties_File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _25_OnlyPropertiesFile 
{
	public static void main(String[] args) throws IOException 
	{
				//TO READ THE DATA FROM OUTSIDE FILE TO JAVA
				FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\testdata.properties");
				
				//TO HANDLE PROPERTIES FILE _ CREATE OBJECT OF PROPERTIES CLASS
				Properties pobj=new Properties(); // Present in Map <I>
				
				//TO LOAD THE VALUES(Test data) INTO "pobj" OBJECT
				pobj.load(fis);
				
				//TO FETCH THE VALUE FROM PROPERTIES FILE
				
				//For Url
				String Url=pobj.getProperty("url");
				System.out.println(Url);
				
				//For Username
				String Username=pobj.getProperty("username");
				System.out.println(Username);
				
				//For Password
				String Password=pobj.getProperty("password");
				System.out.println(Password);
				
		
		
	}
}
