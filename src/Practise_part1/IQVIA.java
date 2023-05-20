package Practise_part1;

import org.openqa.selenium.chrome.ChromeDriver;

public class IQVIA
{
	public static void main(String[] args)
	{
		//To Configure Browser Server(Chrome)
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Priya\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		//To Launch(Open)Chrome Browser ->Create Object for ChromeDriver
		ChromeDriver driver=new ChromeDriver();
		
		//To Open Application(IQVIA)
		driver.get("https://www.iqvia.com/");
	}

}
