package api.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import api.requestPayloads.CreateUserRequestPayload;

public class DataSetup {
	
	static String excelFileName;
	static String excelSheetName;
	
	public static CreateUserRequestPayload createUserDataSetup() throws IOException{
		
		//READ FILENAME FROM PATH.PROPERTIES
		excelFileName=PropUtil.readProperty("userPayloadExcelFileName");
		excelSheetName=PropUtil.readProperty("createUserPayloadSheetName");
			
		//SEND JSON PAYLOAD AS REQUEST BODY
		CreateUserRequestPayload createUserPayload=new CreateUserRequestPayload();
			
		createUserPayload.setUsername((String)ExcelUtil.readData(excelFileName, excelSheetName, 1, 0));
		createUserPayload.setFirstName((String)ExcelUtil.readData(excelFileName, excelSheetName, 1, 1));
		createUserPayload.setLastName((String)ExcelUtil.readData(excelFileName, excelSheetName, 1, 2));
		createUserPayload.setEmail((String)ExcelUtil.readData(excelFileName, excelSheetName, 1, 3));
		createUserPayload.setPassword((String)ExcelUtil.readData(excelFileName, excelSheetName, 1, 4));
		createUserPayload.setPhone((String)ExcelUtil.readData(excelFileName, excelSheetName, 1, 5));
			
		createUserPayload.setUserstatus((Integer)ExcelUtil.readData(excelFileName, excelSheetName, 1, 5));
		createUserPayload.setId((Integer)ExcelUtil.readData(excelFileName, excelSheetName, 1, 5));
		
		return createUserPayload;
	
	
	}
	
	public static List<Object> loginUserDataSetup() throws IOException{
		
		//READ FILENAME FROM PATH.PROPERTIES
		excelFileName=PropUtil.readProperty("loginExcelFileName");
		excelSheetName=PropUtil.readProperty("loginExcelSheetName");
		
		List<Object> loginCreds=new ArrayList<Object>();
		
		loginCreds.add(ExcelUtil.readData(excelFileName, excelSheetName, 1, 0));
		loginCreds.add(ExcelUtil.readData(excelFileName, excelSheetName, 1, 1));
		
		return loginCreds;
		
	}
	

}
