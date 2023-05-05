package api.utils;

import java.io.IOException;

import api.payloads.CreateUserPayload;

public class DataSetup {
	
	
	
	public static CreateUserPayload createUserDataSetup() throws IOException{
		
		//READ FILENAME FROM PATH.PROPERTIES
		String excelFileName=PropUtil.readProperty("path.properties", "userPayloadExcelFileName");
		String excelSheetName=PropUtil.readProperty("path.properties", "createUserPayloadSheetName");
			
		//SEND JSON PAYLOAD AS REQUEST BODY
		CreateUserPayload createUserPayload=new CreateUserPayload();
			
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
	

}
