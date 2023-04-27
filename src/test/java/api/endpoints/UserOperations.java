package api.endpoints;

import api.payloads.CreateUserPayload;
import api.payloads.UpdateUserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserOperations {
	
	
	//CREATE USER OPERATION- POST REQUEST
	//SEND JSON PAYLOAD AS REQUEST BODY
	public static Response createUser(CreateUserPayload createUserPayloadJson){
		
		Response postUserResponse=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(createUserPayloadJson)
		
		.when()
				.post(Routes.post_url);
		
		return postUserResponse;
		
	}
	
	//CREATE USER OPERATION- POST REQUEST
	//SEND JSON PAYLOAD AS STRING USING JACKSON API
	public static Response createUserUsingJackson(CreateUserPayload createUserPayloadJson) throws JsonProcessingException{
		
		ObjectMapper mapper=new ObjectMapper();
		String createUserPayloadString=mapper.writeValueAsString(createUserPayloadJson);
		
		Response postUserResponse=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(createUserPayloadString)
		
		.when()
				.post(Routes.post_url);
		
		return postUserResponse;
		
	}
	
	
	//GET USER BY USERNAME OPERATION- GET REQUEST
	public static Response getUser(String userName){
		
		Response getUserResponse=given()
				.pathParam("username", userName)
				
		.when()
				.get(Routes.get_url);
		
		return getUserResponse;
		
	}
	
	
	//UPDATE USER BY USERNAME OPERATION- PUT REQUEST
	//SEND JSON PAYLOAD AS REQUEST BODY
	public static Response updateUser(String userName, UpdateUserPayload updateUserPayloadJson ){
		
		Response updateUserResponse=given()
				.pathParam("username", userName)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(updateUserPayloadJson)
		.when()
				.put(Routes.put_url);
		
		return updateUserResponse;
		
	}
	
	//UPDATE USER BY USERNAME OPERATION- PUT REQUEST
	//SEND JSON PAYLOAD AS STRING USING JACKSON API
	public static Response updateUserUsingJackson(String userName, UpdateUserPayload updateUserPayloadJson ) throws JsonProcessingException{
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValueAsString(updateUserPayloadJson);
		
		Response updateUserResponse=given()
				.pathParam("username", userName)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(updateUserPayloadJson)
		.when()
				.put(Routes.put_url);
		
		return updateUserResponse;
		
	}
	
	
	
	//DELETE USER BY USERNAME OPERATION- DELETE REQUEST
	public static Response deleteUser(String userName){
		
		Response deleteUserResponse=given()
				.pathParam("username", userName)
				
		.when()
				.delete(Routes.delete_url);
		
		return deleteUserResponse;
		
	}

}
