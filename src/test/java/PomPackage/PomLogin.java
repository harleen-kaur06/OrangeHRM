package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basepackage.BaseClass;


public class PomLogin extends BaseClass {

	@FindBy(name="username")
	WebElement Username;
	@FindBy(name="password")
	WebElement Password;
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")			
	WebElement LoginButton;
	
	public PomLogin() {
	
	PageFactory.initElements(driver, this);
	
}
	public void typeusername(String name) {
	
	Username.sendKeys("name");
	}
	public void typepassword(String pass) {
		
		Password.sendKeys("pass");
	}
	public void clickbutton() {
		
		LoginButton.click();
	}
	

	public String verify() {	
	return driver.getTitle();
	}
}