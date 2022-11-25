package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Basepackage.BaseClass;
import PomPackage.PomLogin;

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
	
	@AfterMethod
	public void close() {
		if (driver != null) {
            driver.quit();
        }
	}
}