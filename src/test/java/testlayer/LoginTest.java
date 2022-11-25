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
	public void initsetup() {
		initate();		
		log= new PomLogin();
	}

	@Test
	public void gettitle() {
		String actual=log.verify();
		System.out.println("actual");		
		Assert.assertEquals(actual,"OrangeHRM");
	}
	
	@Test 
	public void Login() {
		log.typeusername(prop.getProperty("username"));
		log.typepassword(prop.getProperty("password"));
		log.clickbutton();
	}
	
	@DataProvider 
	public Object[][] Details(){ 
		Object result[][]=ExcelSheet.readdata("Sheet1"); return result; 
	}

	@AfterMethod
	public void close() {
		if (driver != null) {
            driver.quit();
        }
	}
}