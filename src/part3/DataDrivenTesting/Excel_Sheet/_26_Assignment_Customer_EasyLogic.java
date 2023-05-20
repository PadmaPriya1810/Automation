package part3.DataDrivenTesting.Excel_Sheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class _26_Assignment_Customer_EasyLogic 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\Customer Assignment.xlsx");
		
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet1");
		
		//To Get the value in "String" Format 
		DataFormatter format=new DataFormatter();
		
		//Find Lastrow
		int lastrow=sh.getLastRowNum();
		
		//Find Lastcell
		int lastcell=sh.getRow(lastrow).getLastCellNum();
		
		//Traverse till LastRow
		for(int i=0;i<=lastrow;i++)
		{
			//Traverse till LastCell
			for(int j=0;j<lastcell;j++)
			{
				String value=format.formatCellValue(sh.getRow(i).getCell(j));
				System.out.print(value+"\t");
			}
			System.out.println();
		}
	
	}
}
