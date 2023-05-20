package part3.DataDrivenTesting.Assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import genericLib.DataUtility;


public class _29_Assignment_Seleniumdev
{
	public static void main(String[] args) throws IOException,EncryptedDocumentException 
	{
		DataUtility du=new DataUtility();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//To Open Application using Properties File
		driver.get(du.getDataFromProperties("selurl"));
		
		//To Fetch Color & Font of Selenium IDE
		WebElement ide=driver.findElement(By.xpath("//h4[text()='Selenium IDE']"));
		String color=ide.getCssValue("color");
		String font=ide.getCssValue("font");
		
		//To Write Color & Font Into Excel Sheet
		FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\Write Data.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet3");
		
		sh.createRow(0).createCell(0).setCellValue(color);
		sh.getRow(0).createCell(1).setCellValue(font);//Already Row -0 is created. Don't Create Again
		
		//TO WRITE THE DATA INTO THE FILE
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Priya\\Documents\\Selenium\\Write Data.xlsx");
		
		//TO WRITE THE VALUE IN EXCEL WORKBOOK
		book.write(fos);
		fos.flush();//Compulsory Method

	}
}
