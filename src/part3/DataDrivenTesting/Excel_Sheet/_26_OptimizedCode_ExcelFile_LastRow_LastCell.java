package part3.DataDrivenTesting.Excel_Sheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class _26_OptimizedCode_ExcelFile_LastRow_LastCell 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\Book1.xlsx");
		
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet1");
		
		String value1=sh.getRow(0).getCell(1).getStringCellValue();
		System.out.println(value1);//admin
		
		double value2=sh.getRow(1).getCell(0).getNumericCellValue();
		System.out.println(value2);//12345.0
		
		//String value3=sh.getRow(1).getCell(0).getStringCellValue();
		//System.out.println(value3);//java.lang.IllegalStateException: 
		//Cannot get a STRING value from a NUMERIC cell
		
		int lastrow=sh.getLastRowNum();
		System.out.println(lastrow);//1 [Count from '0']
		
		int lastcell=sh.getRow(0).getLastCellNum();
		System.out.println(lastcell);//2 [Count from '1']
		
	}
}
