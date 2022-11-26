package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Basepackage.BaseClass;
import PomPackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseClass {
	PomLogin log;
	
	public LoginTest() {	
		super();
	}
	
	@BeforeMethod
	public void initsetup() throws InterruptedException {
		initate();		
		log= new PomLogin();
		  
	}

	@Test
	public void gettitle() {
		String actual=log.verify();
		System.out.println("Verifying the page title has started");
		System.out.println(actual);	
		System.out.println("The page title has been successfully verified");
		String actualUrl="url";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl);	
		//Assert.assertEquals(actual,"Sentrifugo - Open Source HRMS");
		
	}
	
	@Test 
	public void Login() {
		log.typeusername(prop.getProperty("username"));
		log.typepassword(prop.getProperty("password"));
		log.clickbutton();
	}
	
	/*@DataProvider 
	public Object[][] Details(){ 
		Object result[][]=ExcelSheet.readdata("Sheet1"); return result; 
	}*/

	@AfterMethod
	public void AfterMethod() {		
		System.out.println("User logged in successfully");
		driver.close();
	}
}