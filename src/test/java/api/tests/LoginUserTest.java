package api.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import api.endpoints.LoginOperation;
import api.endpoints.UserOperations;
import api.utils.BaseAPITest;
import api.utils.DataSetup;
import api.utils.PropUtil;
import api.utils.ResponseValidation;
import api.utils.SchemaValidation;
import io.restassured.response.Response;

public class LoginUserTest extends BaseAPITest {

	
	@Test(priority=1, description="Login User")
	public void testLoginUser() throws IOException{
	
		String userName=DataSetup.loginUserDataSetup().get(0).toString();
		String password=DataSetup.loginUserDataSetup().get(1).toString();
		
		Response loginUserResponse= LoginOperation.loginUser(userName, password);
		loginUserResponse.then().log().all();
		
		//VALIDATE STATUS CODE
		ResponseValidation.validateStatusCode(loginUserResponse, 200);
				
		//VALIDATE RESPONSE JSON USING JSONPATH
		ResponseValidation.validateJsonValue(loginUserResponse, "", "");
	}
	
	
	
}
