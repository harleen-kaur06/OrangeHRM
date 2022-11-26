package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseClass;


public class PomLogin extends BaseClass {
	@FindBy(id="username")	
	//@FindBy(xpath="//*[@id=\"username\"]")
	WebElement Username;
	@FindBy(id="password")
	//@FindBy(xpath="//*[@id=\"password\"]")
	WebElement Password;
	@FindBy(id="loginsubmit")
	//@FindBy(xpath="//*[@id=\"loginsubmit\"]")
	WebElement LoginButton;
	
	public PomLogin() {	
		PageFactory.initElements(driver, this);	
	}
	public void typeusername(String name) {	
		System.out.println("Entering the username"+name);		
		Username.sendKeys(name);
	}
	public void typepassword(String pass) {
		System.out.println("Entering the password"+pass);		
		Password.sendKeys(pass);
	}
	public void clickbutton() {	
		System.out.println("Clicking login button");
		LoginButton.click();
	}
	public String verify() {	
		return driver.getTitle();
		
	}
}