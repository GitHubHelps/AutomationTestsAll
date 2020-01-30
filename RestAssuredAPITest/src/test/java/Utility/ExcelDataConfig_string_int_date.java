package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig_string_int_date {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow rowCount;
	XSSFCell Cell;
	XSSFSheet sheet1;
	
	public ExcelDataConfig_string_int_date (String excelPath) {
		
		try {
			
			File scr = new File(excelPath);
			
			FileInputStream fileStream = new FileInputStream(scr);
			
			workbook = new XSSFWorkbook(fileStream);
			
			XSSFSheet sheet1=workbook.getSheetAt(0);
	        int rowcount=sheet1.getLastRowNum();
	        System.out.println("Total Row " + rowcount);

		}
		
			catch (Exception e) {
			
			System.out.println(e.getMessage());
			
				
			}
		
	}

	public String getData (int sheetNumber, int row, int column)
	{
		rowCount = sheet.getRow(row);
		Cell = rowCount.getCell(column);
		sheet = workbook.getSheetAt(sheetNumber);
		
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		
		XSSFCell cell = XLUtils.ws.getRow(row).getCell(column); 
		
		data = cell.toString();  //XLUtils.ws.getRow(rownum).getCell(colnum).toString();

        switch (cell.getCellType()) {

        case STRING:
            System.out.println(cell.getRichStringCellValue().getString());
            break;

        case NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
                System.out.println(cell.getDateCellValue());
            } else {
                System.out.println(cell.getNumericCellValue());
            }
            break;

        case BOOLEAN:
            System.out.println(cell.getBooleanCellValue());
            break;

        case FORMULA:
            System.out.println(cell.getCellFormula());
            break;

        default:
            System.out.println();
    }
		
		return data;
		
			
	}
	
	public int getRowCount (int sheetIndex)
	{
		int row = workbook.getSheetAt(sheetIndex).getLastRowNum();
		row = row +1;
		return row;
	}
	
	 public int getColumnCount(String sheetName)
	   {
	       sheet = workbook.getSheet(sheetName);
	       rowCount = sheet.getRow(0);
	       int colCount = rowCount.getLastCellNum();
	       return colCount;
	   }
	
}
