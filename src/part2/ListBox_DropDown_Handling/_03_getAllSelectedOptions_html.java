package part2.ListBox_DropDown_Handling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class _03_getAllSelectedOptions_html {
	public static void main(String[] args)
	{
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("file:///C:/Users/Priya/Documents/Selenium/MultiselectDropdown.html");
		WebElement movies=driver.findElement(By.id("Movies"));
		Select s=new Select(movies);
		
		//TO SELECT
		s.selectByVisibleText("Tare Zameen Par");
		s.selectByVisibleText("Frozen");
		s.selectByVisibleText("Minnale");
		
		List<WebElement> allselected=s.getAllSelectedOptions();
		
		for(WebElement select:allselected)
		{
			System.out.println(select.getText());
		}
	}

}
