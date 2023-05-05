package api.utils;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseAPITest {
	
	
	
	//BASE CLASS FOR API TESTS
	
	@BeforeSuite
	public void beforeSuite(){
		
	}
	
	
	@AfterSuite
	public void afterSuite(){
		
	}
	
	
	@BeforeTest
	public void beforeTest() throws IOException{
		
	}
	
	@AfterTest
	public void afterTest(){	
		
	}
	
	
	
	
	

}
