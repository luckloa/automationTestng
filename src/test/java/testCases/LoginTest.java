package testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;

public class LoginTest extends CommonMethods {

	@BeforeMethod
	public void setUp() {
		BaseClass.getDriver().get(BaseClass.getProperty("url"));
		BaseClass.getDriver().manage().window().maximize();
		BaseClass.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void loginPage() {
		lp.pageLoginSuccessful();
		lp.incorrectUserAndPwd();
		lp.validUserEmptyPwd();
		lp.emptyUserValidPwd();
		lp.emUserEmPwd();
	
	
	}
	
	
	
	
	
}
