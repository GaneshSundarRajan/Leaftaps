package tests;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeaftapsWrappers;

public class TC002_CreateLead extends LeaftapsWrappers {
	
	
	
	
	@BeforeClass
		public void beforeClass() {
			excelName="TC002";
			testName="CreateLead";
			testDescription="Create Lead page to leaftaps";
			author = "Ganesh";
			category = "CreateleadPage";
		}
		
		
		@Test(dataProvider="fetchexceldata")
		public void create(String username, String password,String companyName,
				String firstName,String lastName) {
			
			new LoginPage(driver, test)
			.typeUserName()
			.typePasswd()
			.clickLogin()
			.clickCRM()
			.clickcreateLead()
			.typeCompanyName(companyName)
			.typeFirstName(firstName)
			.typeLastName(lastName)
			.clickCreateButton()
			.verifyLead();
			
			
	}
	
}
