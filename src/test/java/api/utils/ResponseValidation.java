package api.utils;

import org.testng.Assert;

import io.restassured.response.Response;

public class ResponseValidation {
	
	
	
	public static void validateStatusCode(Response response, int expectedStatusCode){
		
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
		
	}
	
	
	
	

}
