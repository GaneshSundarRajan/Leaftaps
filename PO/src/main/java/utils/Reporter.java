package utils;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter  {
	public static ExtentReports reports;
	public static ExtentTest test;
	public void createReport() {
		reports = new ExtentReports("./reports/findlead.html",false);
		reports.loadConfig(new File("./Leaptapsreport.xml"));
	}
	
	public void createTestReport(String testcaseName, String desc,
			   String author, String category) {
		
		test = reports.startTest(testcaseName, desc);
		test.assignAuthor(author);
		test.assignCategory(category);
	
	}

	 public void logSteps(String status, String desc) {
		 
		if(status.equalsIgnoreCase("PASS")){
			test.log(LogStatus.PASS,desc);
			}
		else if(status.equalsIgnoreCase("FAIL")){
			test.log(LogStatus.FAIL, desc);
			//throw new RuntimeException();
		}
		else if(status.equalsIgnoreCase("WARNING")){
			test.log(LogStatus.WARNING, desc);
		}
		 
	 }
	 
	 
	 public void closeTestReport() {
		 
		 reports.endTest(test);
	 }
	 
	 public void saveReport() {
		 reports.flush();
	 }
}
