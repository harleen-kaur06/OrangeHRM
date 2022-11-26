package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Basepackage.BaseClass;


public class PomLogin extends BaseClass {
	@FindBy(id = "username")	
	WebElement Username;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(id="loginsubmit")			
	WebElement LoginButton;
	
	public PomLogin() {	
		PageFactory.initElements(driver, this);	
	}
	public void typeusername(String name) {	
		System.out.println("Entering the username");
		Username.sendKeys("username");
	}
	public void typepassword(String pass) {
		System.out.println("Entering the password");
		Password.sendKeys("password");
	}
	public void clickbutton() {	
		System.out.println("Clicking login button");
		LoginButton.click();
	}
	public String verify() {	
		return driver.getTitle();
	}
}