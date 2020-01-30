package ReadExcelData;

import lib.ExcelDataConfig;

public class ReadExcelData {

	public static void main(String[] args) {

		ExcelDataConfig excel = new ExcelDataConfig("C:\\Eclipse\\db.xlsx");
		System.out.println(excel.getData(0, 1, 0));
	}

}
