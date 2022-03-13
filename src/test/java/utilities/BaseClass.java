package utilities;



import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	//Driver	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver == null) {
			switch(BaseClass.getProperty("browser")) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
				
			}
			
			PageInitialize.initializer();
			
		}
		return driver;
		
	}
	//close
	public void tearDown() {
		if(driver != null) {
			driver.close();
			driver = null;
		}
		
	}
	//configReader
	private static Properties configFile;
	static {
		try {
			String filePath = Constants.configuration_filepath;
			FileInputStream input = new FileInputStream(filePath);
			
			configFile = new Properties();
			configFile.load(input);
			
			input.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static String getProperty(String Keyname) {
		return configFile.getProperty(Keyname);
	}

}
