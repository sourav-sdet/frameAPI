package api.utils;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.requestPayloads.CreateUserRequestPayload;
import api.responsePayloads.CreateUserResponsePayload;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ResponseValidation {
	
	
	static JsonPath jsonPath;
	static ObjectMapper mapper;
	static CreateUserResponsePayload createUserResponsePayload;
	
	public static void validateStatusCode(Response response, int expectedStatusCode){
		
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
		
	}
	
	
	public static void validateJsonValue(Response response, String path, String expectedValue){
		
		jsonPath=new JsonPath(response.asString());
		String actualValue= jsonPath.get(path);
		
		Assert.assertEquals(actualValue, expectedValue);
		
	}
	
	
	public static void validateJsonValue(Response response, String path, int expectedValue){
		
		 jsonPath=new JsonPath(response.asString());
		 int actualValue=jsonPath.getInt(path);
		 
		 Assert.assertEquals(actualValue, expectedValue);
		
	}
	
	public static void validatecreateUserResponse(Response createUserResponse) throws JsonMappingException, JsonProcessingException{
		
		String strcreateUserResponse=createUserResponse.asString();
		mapper=new ObjectMapper();
		
		createUserResponsePayload=mapper.readValue(strcreateUserResponse, CreateUserResponsePayload.class);
		
		
		
		
		
	}
	
	

}
