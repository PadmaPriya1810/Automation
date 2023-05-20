package part3.DataDrivenTesting.Excel_Sheet;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class _26_OnlyExcelSheet 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		//TO READ THE DATA FROM OUTSIDE FILE TO JAVA
		FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\Book1.xlsx");
		
		//GET THE WORKBOOK
		Workbook book=WorkbookFactory.create(fis);
		
		//GET THE SHEET
		Sheet sh=book.getSheet("Sheet1");
		
		//GET THE ROW
		Row row=sh.getRow(0);
		
		//GET THE CELL
		Cell cel=row.getCell(1);
		
		//TO FETCH String Value
		String Value=cel.getStringCellValue();
		
	}
}
