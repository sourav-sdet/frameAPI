package api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	 
	static XSSFWorkbook workbook;
	static File file;
	static FileInputStream fis;
	static XSSFSheet sheet;
	static String strCellValue;
	static double numericCellValue;
	
	public static Object readData(String fileName, String sheetName, int rowNum, int colNum) throws IOException{
		
		
		
		file=new File(System.getProperty("user.dir"+"src/test/java/api/resources/"+fileName));
		fis=new FileInputStream(file);
		
		// Create Workbook instance holding reference to .xlsx file
		workbook=new XSSFWorkbook(fis);
		
		// Get first/desired sheet from the workbook
		sheet= workbook.getSheet(sheetName);
		
		//Check the format of cell
		CellType cellType=sheet.getRow(rowNum).getCell(colNum).getCellType();
		
		if(cellType.equals(CellType.STRING)){
			strCellValue=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			fis.close();
			return strCellValue;
		}
		
		else if(cellType.equals(CellType.NUMERIC)){
			
			numericCellValue=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			fis.close();
			return (int)numericCellValue;
		}
		
		else{
			fis.close();
			return null;
		}
		
		
		
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

	
	public static int getRowCount(String excelFileName, String excelSheetName) {

		
		
		
		return 0;
	}


	public static int getCellCount(String excelSheetName, int i) {

		
		
		return 0;
	}
		
		
		
}
	
