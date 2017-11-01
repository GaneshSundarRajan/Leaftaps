/*package tests;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.DataInputProvider;
import wrappers.LeaftapsWrappers;

public class Createlead extends LeaftapsWrappers{
	
	//Getting value from 
	@Test(dataProvider="createlead")
	public void createLead(String companyname,String fristname,String lastname){
		clickByLink("CRM/SFA");
		clickByLink("Create Lead");
		enterById("createLeadForm_companyName", companyname);
		enterById("createLeadForm_firstName", fristname);
		enterById("createLeadForm_lastName", lastname);
		clickByName("submitButton");
	}


	 @DataProvider(name="createlead")
	 public String[][] getExcelData() throws InvalidFormatException, IOException{
		
		 DataInputProvider excel = new DataInputProvider();
		String[][] data = excel.sheetData("Login");
		return data;
		}


}
*/