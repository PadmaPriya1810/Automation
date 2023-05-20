package part1.Locators.Relative_xpath;



import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class Worldometers {

	EdgeDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		Worldometers w=new Worldometers();
		w.launchBrowser();
		w.openApp();
		String coronavirusCases=w.coronavirusCases();
		System.out.println("Coronavirus Cases : "+coronavirusCases);
		String deaths=w.deaths();
		System.out.println("Deaths : "+deaths);
		String recovered=w.recovered();
		System.out.println("Recovered : "+recovered);
		w.closeBrowser();
	}
	
	public void launchBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	public void openApp() throws InterruptedException
	{
		driver.get("https://www.worldometers.info/coronavirus/");
		Thread.sleep(3000);
	}
	
	public String coronavirusCases()
	{
		String coronavirusCases=driver.findElement(By.xpath("//h1[text()='Coronavirus Cases:']/../div/span")).getText();
		return coronavirusCases;
	}
	
	public String deaths()
	{
		String deaths=driver.findElement(By.xpath("//h1[text()='Deaths:']/../div/span")).getText();
		return deaths;
	}
	
	public String recovered()
	{
		String recovered=driver.findElement(By.xpath("//h1[text()='Recovered:']/../div/span")).getText();
		return recovered;
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
}
