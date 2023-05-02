package api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserOperations;
import api.payloads.CreateUserPayload;
import api.utils.BaseAPITest;
import io.restassured.response.Response;

public class UserTests extends BaseAPITest {
		
	
	//TEST CREATE USER OPERATION- POST REQUEST
	//SEND JSON PAYLOAD AS REQUEST BODY
	@Test(priority=1)
	public void testCreateUser(){
		
		//SEND JSON PAYLOAD AS REQUEST BODY
		CreateUserPayload createUserPayload=new CreateUserPayload();
		createUserPayload.setEmail("");
		createUserPayload.setFirstName("");
		createUserPayload.setId(1);
		createUserPayload.setLastName("");
		createUserPayload.setPassword("");
		createUserPayload.setPhone("");
		createUserPayload.setUsername("");
		createUserPayload.setUserstatus(1);
		
		
		Response createUserResponse= UserOperations.createUser(createUserPayload);
		createUserResponse.then().log().all();
		
		//VALIDATIONS FOR CREATE USER OPERATION
		Assert.assertEquals(createUserResponse.getStatusCode(), 200);
		
	}
	
	
	
	//TEST CREATE USER OPERATION- POST REQUEST
	//SEND JSON PAYLOAD AS STRING USING JACKSON API
	@Test(priority=2)
	public void testCreateUserUsingJackson(){
		
		//SEND JSON PAYLOAD AS STRING USING JACKSON API
		CreateUserPayload createUserPayload=new CreateUserPayload();
		createUserPayload.setEmail("");
		createUserPayload.setFirstName("");
		createUserPayload.setId(1);
		createUserPayload.setLastName("");
		createUserPayload.setPassword("");
		createUserPayload.setPhone("");
		createUserPayload.setUsername("");
		createUserPayload.setUserstatus(1);
		
		Response createUserUsingJacksonResponse= UserOperations.createUser(createUserPayload);
		createUserUsingJacksonResponse.then().log().all();
	
		//VALIDATIONS FOR CREATE USER OPERATION
		Assert.assertEquals(createUserUsingJacksonResponse.getStatusCode(), 200);
		
	}
	
	
	
	
	

}
