package api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	static HSSFWorkbook xlsWorkbook; 
	static XSSFWorkbook xlsxWorkbook;
	static File file;
	static FileInputStream fis;
	
	public static String readxlsFile(String filePath, String sheetName, int rowNum, int colNum) throws IOException{
		
		file=new File(filePath);
		fis=new FileInputStream(file);
		xlsWorkbook=new HSSFWorkbook(fis);
		
		
		
		return sheetName;
		
	}
	
	public static String readxlsxFile(String filePath, String sheetName, int rowNum, int colNum) throws IOException{
		
		file=new File(filePath);
		fis=new FileInputStream(file);
		xlsxWorkbook=new XSSFWorkbook(fis);
		
		
		return sheetName;
		
		
		
	}
	
	
	
	
	

}
