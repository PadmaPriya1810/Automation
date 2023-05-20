package Logics_To_Learn;

import java.time.Duration;
import java.util.List;
import java.util.TreeSet;
//Using TREESET - Not Storing Juz Printing
//Remove Duplicates From List
//Sort in Ascending & Descending-Using descendingSet() Method
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class _10_DD_MultiselectHTML_With_Duplicates_TreeSet
{
	public static void main(String[] args)
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("file:///C:/Users/Priya/Documents/Selenium/MultiselectDropdownWithDuplicates.html");
		
		//Located List
		WebElement studentlist=driver.findElement(By.id("Students"));
		
		//Creating Object for Select Class to Use getOptions()
		Select s=new Select(studentlist);
		List<WebElement> allstudents=s.getOptions();//Returns all Students Name
		
		//Creating TreeSet To Remove Duplicates & Sort In Ascending
		TreeSet set=new TreeSet();
		
		for(WebElement student:allstudents)
		{
			set.add(student.getText());//For Printing only Elements No need index, getText() is Enough
		}
		
		System.out.println("Ascending Order  :"+set);//[--Select Name--, Abisheka, Banu, Garzia, Karthik, Priya]
		
		System.out.println("Descending Order :"+set.descendingSet());//[Priya, Karthik, Garzia, Banu, Abisheka, --Select Name--]
	}

}
