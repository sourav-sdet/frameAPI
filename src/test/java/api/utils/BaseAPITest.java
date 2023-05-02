package api.utils;

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
	
	@BeforeClass
	public void userLogin(String username, String password){
		
		System.out.println("User "+username+" logging in....");
		
	}
	
	@AfterClass
	public void afterClass(){
		
	}
	
	
	@BeforeTest
	public void beforeTest(){
		
	}
	
	@AfterTest
	public void afterTest(){
		
	}
	
	
	
	
	

}
