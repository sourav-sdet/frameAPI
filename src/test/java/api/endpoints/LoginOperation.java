package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payloads.CreateUserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginOperation {

	public static Response loginUser(String userName, String password){
		
		Response loginUserResponse=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.queryParam("username",userName)
				.queryParam("password", password)
		
		.when()
				.get(Routes.loginUser_url);
		
		return loginUserResponse;
		
	}
	
	
	
	
}