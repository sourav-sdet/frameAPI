package api.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;

import api.endpoints.UserOperations;
import api.requestPayloads.CreateUserRequestPayload;
import api.utils.BaseAPITest;
import api.utils.DataSetup;
import api.utils.ResponseValidation;
import api.utils.SchemaValidation;
import io.restassured.response.Response;

public class CreateUserTest extends BaseAPITest {
	
	
	//TEST CREATE USER OPERATION- POST REQUEST
	//SEND JSON PAYLOAD AS REQUEST BODY
	@Test(priority=1, description="Create User")
	public void testCreateUser() throws IOException, ProcessingException{
		
		//SEND JSON PAYLOAD AS REQUEST BODY
		CreateUserRequestPayload createUserPayload=DataSetup.createUserDataSetup();
		Response createUserResponse= UserOperations.createUser(createUserPayload);
		createUserResponse.then().log().all();
		
		createUserResponse.then().log().body().statusCode(200);
		
		//VALIDATE STATUS CODE
		ResponseValidation.validateStatusCode(createUserResponse, 200);
		
		//VALIDATE JSON SCHEMA
		SchemaValidation.validateJSONSchema("createUserSchema", createUserResponse.asString());
		
		//VALIDATE RESPONSE JSON USING JSONPATH
		ResponseValidation.validateJsonValue(createUserResponse, "", "");
		ResponseValidation.validateJsonValue(createUserResponse, "", 1);
		
		//VALIDATE RESPONSE JSON USING JACKSON
		ResponseValidation.validatecreateUserResponse(createUserResponse);
		
		
		
	}
	
	
	
	//TEST CREATE USER OPERATION- POST REQUEST
	//SEND JSON PAYLOAD AS STRING USING JACKSON API
	@Test(priority=2, description="Create User using Jackson API")
	public void testCreateUserUsingJackson() throws IOException, ProcessingException{
		
		//SEND JSON PAYLOAD AS STRING USING JACKSON API
		CreateUserRequestPayload createUserPayload=DataSetup.createUserDataSetup();
		Response createUserUsingJacksonResponse= UserOperations.createUserUsingJackson(createUserPayload);
		createUserUsingJacksonResponse.then().log().all();

		
		//VALIDATE STATUS CODE
		ResponseValidation.validateStatusCode(createUserUsingJacksonResponse, 200);
		
		//VALIDATE JSON SCHEMA
		SchemaValidation.validateJSONSchema("", createUserUsingJacksonResponse.asString());
		
	}
	
	
	
	
	

}
