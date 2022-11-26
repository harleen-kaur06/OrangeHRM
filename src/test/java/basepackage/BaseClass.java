package basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static Properties prop=new Properties();	 
	public static WebDriver driver;
	
	public BaseClass() {
		try {
			FileInputStream file=new FileInputStream ("C:\\Users\\DELL\\git\\OrangeHRM\\src\\test\\java\\enviornmentvariables\\config.properties");
			prop.load(file);  
		}		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}	
		catch(IOException a) {
			a.printStackTrace();
		}	 
	 }


	public static void initate() {
		String browsername=	prop.getProperty("browser");  
	  if (browsername.equals("ChromeDriver")) {
		  System.setProperty("WebDriver.Chrome.Driver","ChromeDriver.exe.");
		  driver=new ChromeDriver();
	  }
	  else if (browsername.equals ("FirefoxDriver")) {
		  System.setProperty("WebDriver.Gecko.driver","GeckoDriver.exe");
		  driver=new FirefoxDriver();
	  }  
  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	  driver.get(prop.getProperty("url"));
	  
	}
}  