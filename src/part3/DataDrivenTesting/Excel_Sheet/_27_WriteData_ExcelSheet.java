package part3.DataDrivenTesting.Excel_Sheet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class _27_WriteData_ExcelSheet 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\Write Data.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet1");
		
		sh.createRow(0).createCell(0).setCellValue("admin");
		
		//TO WRITE THE DATA INTO THE FILE
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Priya\\Documents\\Selenium\\Write Data.xlsx");
		
		//TO WRITE THE VALUE IN EXCEL WORKBOOK
		book.write(fos);
		fos.flush();//Compulsory Method
		System.out.println("Pass");
	}

}
