package utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataInputProvider {
	@Test
	public  Object[][] readData(String name) throws InvalidFormatException, IOException {
		
		
		
		// Step 1: Open the workbook
		File exceldata = new File("./data/"+name+".xlsx");		
		XSSFWorkbook book = new XSSFWorkbook(exceldata);

		// Step 2: Go to the specific sheet
		XSSFSheet sheet = book.getSheetAt(0);

		// Step 2a: Get the number of rows
		int rowcount = sheet.getLastRowNum();
		System.out.println("Number of rows :"+rowcount);
		
		// Step 2b: Get the number of columns in row 1
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		//initializing Array
		Object[][] data = new Object[rowcount][columnCount];
		
		for (int i = 1; i <=rowcount; i++) {
			// Step 3: Go to the specific row
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				// Step 4: Go to the specific cell
				XSSFCell cell = row.getCell(j);
				// Step 5: Read the content of the cell
				data[i-1][j] = cell.getStringCellValue();
				System.out.println(data[i-1][j]);
				
			}
		}
		
		return data;
	}


}



