package ReadExcelData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		
		File scr = new File("C:\\Eclipse\\db.xlsx");
		
		FileInputStream fileStream = new FileInputStream(scr);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fileStream);  //for .xlsx files
		
		XSSFSheet sheet = workbook.getSheetAt(0);  //which sheet to read
		
//		HSSFWorkbook workbook = new HSSFWorkbook(fileStream);  //for .xls files
		
//		String ExcelData = sheet.getRow(1).getCell(0).getStringCellValue();
		
	//	sheet.getRow(0).createCell(4).setCellValue("Pass1");  - to write something in the file cell		
	//	FileOutputStream testWrite  = new FileOutputStream(scr); - to write something in the file cell		
	//	workbook.write(testWrite);	- to write something in the file cell

		
//		System.out.println("Data from excel: " + ExcelData);
		
		int rowcount = sheet.getLastRowNum()+1;
		
		System.out.println("Row count is : " + rowcount);
		
	
		for (int i=1; i<rowcount; i++)
		{
			String data=sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Row name is : " + data);
		}
	

		
		workbook.close();
	}

}
