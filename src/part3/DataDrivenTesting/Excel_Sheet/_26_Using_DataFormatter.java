package part3.DataDrivenTesting.Excel_Sheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class _26_Using_DataFormatter 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\Book1.xlsx");
	
	Workbook book=WorkbookFactory.create(fis);
	
	Sheet sh=book.getSheet("Sheet1");
	
	//TO GET THE VALUE IN "String" FORMAT
	DataFormatter format=new DataFormatter();
	
	String value1=format.formatCellValue(sh.getRow(0).getCell(1));
	System.out.println(value1);//admin
	
	String value2=format.formatCellValue(sh.getRow(1).getCell(0));
	System.out.println(value2);//12345

}
}
