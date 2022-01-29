package week5.day1_day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readExcel(String filename) throws IOException {

		// Set path of excel workbook
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+filename+".xlsx");
		// Get into the sheet
//		XSSFSheet sheet = wb.getSheet("CreateLead_Data");
		XSSFSheet sheet = wb.getSheetAt(0);

		// Get no of rows and cols
		int rowCount = sheet.getLastRowNum();// excludes header
//		int rowCount = sheet.getPhysicalNumberOfRows();//includes header
		int colCount = sheet.getRow(0).getLastCellNum();// get cell count of header

		String[][] data = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			// Get the row data
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				// Get into the first cell
				XSSFCell cell = row.getCell(j);
				// Retrieve data
				String cellValue = cell.getStringCellValue();
				System.out.print(cellValue + " | ");
				data[i - 1][j] = cellValue;
			}
			System.out.println("");
		}
		wb.close();
		return data;
	}

}
