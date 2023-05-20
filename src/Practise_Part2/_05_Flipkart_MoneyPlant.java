package Practise_Part2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _05_Flipkart_MoneyPlant 
{
	public static void main(String[] args)
	{
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("Money Plant");
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		//Getting 1 of 40 plants name
		List<WebElement> allplants=driver.findElements(By.xpath("//a[contains(text(),'Money Plant')]"));
		
		//Should Get 1 of 40 plants price
		List<WebElement> allprice=driver.findElements(By.xpath("//a[contains(text(),'Money Plant')]/../a[3]/div[1]/div[1]"));
		
		for(int i=0;i<allplants.size();i++)
		{
			WebElement plant=allplants.get(i);
			WebElement price=allprice.get(i);
			
			System.out.println(plant.getText()+"---->"+price.getText());
		}
		
		//Printing Each Plant Name
		for(WebElement plant:allplants)
		{
			System.out.println(plant.getText());
		}
		
		//For Sorting Must Store in ArrayList
		//Coz Sort(List l) accepts only "List"
		
		ArrayList al_plants=new ArrayList();
		
		for(int i=0;i<allplants.size();i++)
		{
			al_plants.add(allplants.get(i).getText());//Adding Each Plant Name into Array List
		}
		
		System.out.println("\nSorting By Plant Name\n");
		Collections.sort(al_plants);//Sorting by Plant Name
		
		System.out.println(al_plants);
		
		
		
		ArrayList al_price=new ArrayList();
		
		for(int i=0;i<allprice.size();i++)
		{
			al_price.add(allprice.get(i).getText());
		}
		
		System.out.println("\nSorting By Plant Price\n");
		Collections.sort(al_price);
		
		System.out.println(al_price);
		
	}
}
