package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basepackage.BaseClass;


public class PomLogin extends BaseClass {
	@FindBy(xpath="//*[@name='username']")
	WebElement Username;
	@FindBy(xpath="//*[@name='password']")
	WebElement Password;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")			
	WebElement LoginButton;
	
	public PomLogin() {	
		PageFactory.initElements(driver, this);	
	}
	public void typeusername(String name) {	
		Username.sendKeys("username");
	}
	public void typepassword(String pass) {		
		Password.sendKeys("password");
	}
	public void clickbutton() {		
		LoginButton.click();
	}
	public String verify() {	
		return driver.getTitle();
	}
}