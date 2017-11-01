package wrappers;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.DataInputProvider;


public class LeaftapsWrappers extends GenericWrappers {

	public String excelName,testName,testDescription, author,category;

	

	@BeforeSuite
	public void report(){
		createReport();
	}
	
	/*@BeforeClass
	public void beforeClass() {
	}*/

	@Parameters({"broswer","url"})

	@BeforeMethod
	
	public void beforeMethod(String broswer,String url){
		createTestReport(testName,testDescription,author,category);
		invokeApp(broswer,url);
	}

@AfterMethod
	public void close(){
		closeBrowser();
		closeTestReport();
	}

	@AfterSuite
	public void save() {
		saveReport();
	}

	
	
	@DataProvider(name="fetchexceldata")
	public Object[][] getExcelData() throws InvalidFormatException, IOException {

		DataInputProvider excel = new DataInputProvider();
		Object[][] data = excel.readData(excelName);
		return data;
	}
	
}










