package part3.DataDrivenTesting.Excel_Sheet;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class _26_Assignment_Customer 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\Customer Assignment.xlsx");
		
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet1");
		
		//To Get the value in "String" Format 
		DataFormatter format=new DataFormatter();
		
		//To Traverse All Rows till Last
		for(int i=0;i<=sh.getLastRowNum();i++)
		{
			//Getting Each Row Number
			Row row=sh.getRow(i);
			
			//To Traverse Each Row's Last Cell
			for(int j=0;j<row.getLastCellNum();j++)
			{
				//To Fetch The Value Inside Cell
				String value=format.formatCellValue(row.getCell(j));
				System.out.print(value+"\t");
			}
			System.out.println();
		}	
	}
}
