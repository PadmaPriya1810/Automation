package Practise_Part2;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
	
	public class List_Flowers_Using_Comparator
	{	
		public static void main(String[] args) throws InterruptedException 
		{
			WebDriver driver=new EdgeDriver();
			driver.manage().window().maximize();
			
			 driver.get("https://www.flipkart.com/");
			 Thread.sleep(2000);                            
			 driver.findElement(By.xpath("//button[text()='✕']")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.name("q")).sendKeys("Flowers");
			 Thread.sleep(2000);
			 
			 //List of Suggestions
			 List<WebElement> allsugg=driver.findElements(By.xpath("//ul[contains(@class,'col')]//li"));
			 
			 //Print Using "foreach" loop -Just Printing Each Sugg
//			 System.out.println("USING FOREACH LOOP\n");
//			 for(WebElement sugg:allsugg)
//			 {
//				 System.out.println(sugg.getText());//Printing all Sugg
//			 }
			 
		     System.out.println("\nADDING INTO ARRAYLIST AND PRINTING USING FOREACH LOOP\n");
			 ArrayList al=new ArrayList();//Creating ArrayList to Add allsugg
//			 
//			 for(WebElement sugg:allsugg)
//			 {
//				 al.add(sugg.getText()); //Adding Each Suggestion into ArrayList
//			 }
//			 System.out.println(al);//Printing ArrayList
//			 
			
//
			 for(int i=0;i<allsugg.size();i++)
			 {
				 al.add(allsugg.get(i).getText());//Adding Same List Again into Same ArrayList using for
			 }
			 System.out.println(al);//Printing ArrayList
			 
			al.sort(Comparator.naturalOrder());
			System.out.println("\n AFTER SORTING Using \n\n");
			 System.out.println(al);//Printing After Sorting in Ascending Order using
		
			al.sort(Comparator.reverseOrder());
			
			//Sorting ArrayList
			 
			 
		
			 
		}

		
	}



