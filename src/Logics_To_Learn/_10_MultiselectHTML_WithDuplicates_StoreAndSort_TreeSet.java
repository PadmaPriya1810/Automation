package Logics_To_Learn;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class _10_MultiselectHTML_WithDuplicates_StoreAndSort_TreeSet
{
public static void main(String[] args) 
{
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	
	WebDriver driver=new ChromeDriver(options);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("file:///C:/Users/Priya/Documents/Selenium/MultiselectDropdownWithDuplicates.html");
	WebElement dd=driver.findElement(By.id("Students"));
	
	Select s=new Select(dd);
	List<WebElement> allstudents=s.getOptions();
	
	TreeSet<String> ts=new TreeSet<String>();
	
	//USING "for" Loop
	for(int i=0;i<allstudents.size();i++)
	{
		ts.add(allstudents.get(i).getText());
	}
	
	//TO PRINT AS SET
	System.out.println(ts);//[--Select Name--, Abisheka, Banu, Garzia, Karthik, Priya]

	
	//NOTE: No Index In Set-Can't use get(i) for Descending
	
	
	//USING ITERATOR TO PRINT EACH ELEMENT IN NEXTLINE
	Iterator itr=ts.iterator();
	while(itr.hasNext())
	{
		System.out.println(itr.next());
//		--Select Name--
//		Abisheka
//		Banu
//		Garzia
//		Karthik
//		Priya
	}
	
	//USING "forEach" Loop
	for(String student:ts)//Should Mention TreeSet as <String> Type
	{
		System.out.println(student);
//		--Select Name--
//		Abisheka
//		Banu
//		Garzia
//		Karthik
//		Priya
	}
	
	//DESCENDING USING descendingSet()
	
	System.out.println(ts.descendingSet());//[Priya, Karthik, Garzia, Banu, Abisheka, --Select Name--]
	
	
	//DESCENDING USING descendingIterator()
	Iterator descitr=ts.descendingIterator();
	while(descitr.hasNext())
	{
		System.out.println(descitr.next());
//		Priya
//		Karthik
//		Garzia
//		Banu
//		Abisheka
//		--Select Name--
	}
}
}
