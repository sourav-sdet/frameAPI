package api.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserOperations;
import api.payloads.CreateUserPayload;
import api.utils.BaseAPITest;
import api.utils.ExcelUtil;
import api.utils.PropUtil;
import io.restassured.response.Response;

public class UserTests extends BaseAPITest {
		
	
	//TEST CREATE USER OPERATION- POST REQUEST
	//SEND JSON PAYLOAD AS REQUEST BODY
	@Test(priority=1)
	public void testCreateUser() throws IOException{
		
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
		
		Response createUserResponse= UserOperations.createUser(createUserPayload);
		createUserResponse.then().log().all();
		
		//VALIDATIONS FOR CREATE USER OPERATION
		Assert.assertEquals(createUserResponse.getStatusCode(), 200);
		
	}
	
	
	
	//TEST CREATE USER OPERATION- POST REQUEST
	//SEND JSON PAYLOAD AS STRING USING JACKSON API
	@Test(priority=2)
	public void testCreateUserUsingJackson() throws IOException{
		
		//READ FILENAME FROM PATH.PROPERTIES
		String excelFileName=PropUtil.readProperty("path.properties", "userPayloadExcelFileName");
		String excelSheetName=PropUtil.readProperty("path.properties", "createUserPayloadSheetName");
		
		
		//SEND JSON PAYLOAD AS STRING USING JACKSON API
		CreateUserPayload createUserPayload=new CreateUserPayload();
		
		createUserPayload.setUsername((String)ExcelUtil.readData(excelFileName, excelSheetName, 1, 0));
		createUserPayload.setFirstName((String)ExcelUtil.readData(excelFileName, excelSheetName, 1, 1));
		createUserPayload.setLastName((String)ExcelUtil.readData(excelFileName, excelSheetName, 1, 2));
		createUserPayload.setEmail((String)ExcelUtil.readData(excelFileName, excelSheetName, 1, 3));
		createUserPayload.setPassword((String)ExcelUtil.readData(excelFileName, excelSheetName, 1, 4));
		createUserPayload.setPhone((String)ExcelUtil.readData(excelFileName, excelSheetName, 1, 5));
		
		createUserPayload.setUserstatus((Integer)ExcelUtil.readData(excelFileName, excelSheetName, 1, 5));
		createUserPayload.setId((Integer)ExcelUtil.readData(excelFileName, excelSheetName, 1, 5));
		
		Response createUserUsingJacksonResponse= UserOperations.createUserUsingJackson(createUserPayload);
		createUserUsingJacksonResponse.then().log().all();
	
		//VALIDATIONS FOR CREATE USER OPERATION
		Assert.assertEquals(createUserUsingJacksonResponse.getStatusCode(), 200);
		
	}
	
	
	
	
	

}
