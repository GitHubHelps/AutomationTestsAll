package utility;

import java.util.ArrayList;

public class dataExtract {
	
	static Xls_Reader reader;	

	
	public static ArrayList<Object[]> getDataFromFile () {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			// /WikiTest/src/dataProvider/db.xlsx
			reader = new Xls_Reader(System.getProperty("C:\\Eclipse\\db2.xlsx"));
///WikiTest/src/dataProvider/db.xlsx			
		} catch (Exception e) {																			
			e.printStackTrace();
		}
		
			for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet1"); rowNum++) {
				
				String Name = reader.getCellData("Sheet1", "Name", rowNum);
				String Family = reader.getCellData("Sheet1", "Family", rowNum);
				String Email = reader.getCellData("Sheet1", "Email", rowNum);
				String Pass = reader.getCellData("Sheet1", "Pass", rowNum);
				
//				Object ob[] = {Name, Family, Email, Pass}; // the same as myData.add(new Object[]{Name, Family, Email, Pass});
//				myData.add(ob);
				myData.add(new Object[]{Name, Family, Email, Pass});
			}
		
		return myData;
	}

}
