package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeaftapsWrappers;

public class TC001_Login extends LeaftapsWrappers {
	
	
	
	@BeforeClass
		public void beforeClass() {
			excelName="TC001";
			testName="Login";
			testDescription="Login to leaftaps";
			author = "Ganesh";
			category = "Loginpage";
		}
		
		
		@Test(dataProvider="fetchexceldata")
		public void login(String username, String password) {
			
			new LoginPage(driver, test)
			.typeUserName()
			.typePasswd()
			.clickLogin()
			.clickLogout()
			.closeBrowser();
	}
	
}
