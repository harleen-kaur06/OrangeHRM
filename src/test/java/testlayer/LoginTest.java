package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import basepackage.BaseClass;
import pompackage.PomLogin;
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

	@Test (priority=1)
	public void gettitle() {
		String actual=log.verify();
		System.out.println("Verifying the page title has started");
		System.out.println(actual);	
		System.out.println("The page title has been successfully verified");		
		//Assert.assertEquals(expectedUrl,actualUrl);	
		Assert.assertEquals(actual,"Sentrifugo - Open Source HRMS");
		
	}
	
	@DataProvider 
	public Object[][] Details(){ 
		Object result[][]=ExcelSheet.readdata("Sheet1"); 
		return result; 
	}

	@Test(priority=2,dataProvider="Details")
	//public void Login() {
		//log.typeusername(prop.getProperty("username"));
		//log.typepassword(prop.getProperty("password"));
	public void Login(String name,String password) throws InterruptedException {
		log.typeusername(name);
		Thread.sleep(3000);
		log.typepassword(password);
		Thread.sleep(3000);
		log.clickbutton();
		String actualUrl="http://demo.sentrifugo.com/index.php/index/welcome";	
		String expectedUrl= driver.getCurrentUrl();		
		if(actualUrl.equalsIgnoreCase(expectedUrl)) { 
			  System.out.println("Test passed"); 
			  System.out.println("User logged in successfully");
		} 
		else { System.out.println("Test failed"); 
		}
	}
	
	
	@AfterMethod
	public void AfterMethod() {			
		driver.close();
	}
}