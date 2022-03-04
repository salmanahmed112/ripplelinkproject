package utils;


import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public String[][] readExcel(String fileName) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
		//XSSFWorkbook wb = new XSSFWorkbook(fileName);
		XSSFSheet sh = wb.getSheetAt(0);
		// row count
		int rowCount = sh.getLastRowNum();
		// column count
		int colCount = sh.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowCount][colCount];
		
		// for row
		for (int i = 1; i <=rowCount; i++) {
			XSSFRow row = sh.getRow(i);
			//for column
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				// read the data from cell
				String value = cell.getStringCellValue();
				data[i-1][j] = value;
			}
		}

		return data;
	}

}
