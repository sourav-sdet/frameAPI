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
	
	@BeforeClass
	public void userLogin(){
		
		
		
	}
	
	@AfterClass
	public void afterClass(){
		
	}
	
	
	@BeforeTest
	public void beforeTest() throws IOException{
		
		System.out.println("User logging in....");
		
		//Code to log user into the system
		String user=ExcelUtil.readData("", "", 1,1);
		String pwd=ExcelUtil.readData("", "", 1,1);
		
		
		
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("User logging out....");
		//Code to logout user from the system
		
	}
	
	
	
	
	

}
