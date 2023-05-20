package part1.Browser_Control_Methods;

import org.openqa.selenium.chrome.ChromeDriver; //To Import ChromeDriver Class

public class Amazon_setProperty_get 
{
	public static void main(String[] args) 
	{
		//To Configure Browser Server --> Use System.setProperty()
		//System.setProperty(String key,String values);
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Priya\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		
		//To Launch Chrome Browser -->Create Object for "ChromeDriver" Class
		ChromeDriver driver=new ChromeDriver();
		
		//To Open Amazon -->get(String url); -> RemoteWebDriver
		driver.get("https://www.amazon.in/");
	}
}
