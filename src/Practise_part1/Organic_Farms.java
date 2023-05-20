package Practise_part1;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class Organic_Farms
{
	public static void main(String[] args) throws InterruptedException 
	{
		EdgeDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.name("q")).sendKeys("best organic farming websites in india");
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("[jsmodel='hspDDf']")).click();
		
		driver.findElement(By.cssSelector("[class='z1asCe MZy1Rb']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//h3[text()='ORGANIC FARMING :: Related Websites']")).click();
		Thread.sleep(3000);
		
		String url=driver.getCurrentUrl();
		System.out.println("WEBSITE URL :" +url);
		
	}

}
