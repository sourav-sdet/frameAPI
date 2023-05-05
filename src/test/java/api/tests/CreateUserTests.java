package api.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.UserOperations;
import api.payloads.CreateUserPayload;
import api.utils.BaseAPITest;
import api.utils.DataSetup;
import api.utils.ResponseValidation;
import io.restassured.response.Response;

public class CreateUserTests extends BaseAPITest {
	
	
	//TEST CREATE USER OPERATION- POST REQUEST
	//SEND JSON PAYLOAD AS REQUEST BODY
	@Test(priority=1, description="Create User")
	public void testCreateUser() throws IOException{
		
		//SEND JSON PAYLOAD AS REQUEST BODY
		CreateUserPayload createUserPayload=DataSetup.createUserDataSetup();
		Response createUserResponse= UserOperations.createUser(createUserPayload);
		createUserResponse.then().log().all();
		
		//VALIDATIONS FOR CREATE USER OPERATION
		createUserResponse.then().log().body().statusCode(200);
		Assert.assertEquals(createUserResponse.getStatusCode(), 200);
		
	}
	
	
	
	//TEST CREATE USER OPERATION- POST REQUEST
	//SEND JSON PAYLOAD AS STRING USING JACKSON API
	@Test(priority=2, description="Create User using Jackson API")
	public void testCreateUserUsingJackson() throws IOException{
		
		//SEND JSON PAYLOAD AS STRING USING JACKSON API
		CreateUserPayload createUserPayload=DataSetup.createUserDataSetup();
		Response createUserUsingJacksonResponse= UserOperations.createUserUsingJackson(createUserPayload);
		createUserUsingJacksonResponse.then().log().all();
	
		//VALIDATIONS FOR CREATE USER OPERATION
		createUserUsingJacksonResponse.then().log().body();
		ResponseValidation.validateStatusCode(createUserUsingJacksonResponse, 200);
		
	}
	
	
	
	
	

}
