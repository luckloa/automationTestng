package utilities;

import pages.LoginPage;
import pages.shopPage;

public class PageInitialize extends BaseClass { 
	
	public static LoginPage lp;
	public static shopPage sp;
	
	
	
	
	public static void initializer() {
		lp = new LoginPage();
		sp = new shopPage();
		
	}
	
	
	
	
}
