package api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	 
	static XSSFWorkbook workbook;
	static File file;
	static FileInputStream fis;
	static XSSFSheet sheet;
	
	public static String readData(String filePath, String sheetName, int rowNum, int colNum) throws IOException{
		
		file=new File(filePath);
		fis=new FileInputStream(file);
		
		// Create Workbook instance holding reference to .xlsx file
		workbook=new XSSFWorkbook(fis);
		
		// Get first/desired sheet from the workbook
		sheet= workbook.getSheet(sheetName);
		
		String value= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		
		fis.close();
		
		return value;
		
	}
	
	
	public static void readFromExcel(String filePath, String sheetName) throws IOException{
		
		file=new File(filePath);
		fis=new FileInputStream(file);
		
		// Create Workbook instance holding reference to .xlsx file
		workbook=new XSSFWorkbook(fis);
		
		// Get first/desired sheet from the workbook
		sheet= workbook.getSheet(sheetName);
		
		
		// Iterate through each rows one by one
		Iterator<Row> rowIterator= sheet.rowIterator();
		
		// Till there is an element condition holds true
		while(rowIterator.hasNext()){
			
			Row row=rowIterator.next();
			
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator=row.cellIterator();
			 
			while(cellIterator.hasNext()){
				 
				 Cell cell=cellIterator.next();
				 
				 cell.getStringCellValue();
				 
				 
			 }
			
		}
		
		fis.close();
		
		
	}

	
	
	public static void writeToExcel(String filePath, String sheetName, String testcaseName, String testStatus ) throws IOException{
		
		file=new File(filePath);
		fis=new FileInputStream(file);
		
		// Create Workbook instance holding reference to .xlsx file
		workbook=new XSSFWorkbook(fis);
		
		// Get first/desired sheet from the workbook
		sheet= workbook.getSheet(sheetName);
		
		int lastRowNum=sheet.getLastRowNum();
		Row row= sheet.createRow(++lastRowNum);
		
			
		row.createCell(0).setCellValue(testcaseName);
		row.createCell(1).setCellValue(testStatus);
			
		
		
		}
		
		
		
}
	
