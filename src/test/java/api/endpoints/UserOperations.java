package api.endpoints;

import api.payloads.CreateUserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserOperations {
	
	
	//CREATE USER OPERATION- POST
	public static Response createUser(CreateUserPayload userPayload){
		
		Response postUserResponse=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(userPayload)
		
		.when()
				.post(Routes.post_url);
		
		return postUserResponse;
		
	}
	

}
