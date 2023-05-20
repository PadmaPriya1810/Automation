package part3.DataDrivenTesting.Excel_Sheet;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class _26_GenericMethod_getDataFromExcel
{
	public String getDataFromExcel(String sheet,int row,short cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\Customer Assignment.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheet);
		DataFormatter format=new DataFormatter();
		String value=format.formatCellValue(sh.getRow(row).getCell(cell));
		return value;
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		_26_GenericMethod_getDataFromExcel excel=new _26_GenericMethod_getDataFromExcel();
		System.out.println(excel.getDataFromExcel("Sheet1", 0, (short) 1));
	}
}
