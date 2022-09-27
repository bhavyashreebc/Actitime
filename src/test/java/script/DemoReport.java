package script;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
/*
 * extent report object we need to create in @BeforeSuite method as
 * it's the only method which runs only once for entire framework.
 * 
 * and flush we need to add in @AfterSuite method as we have to generate the report 
 * only at the end of complete execution+ 
 */
public class DemoReport {

	public static void main(String[] args) {
		
		ExtentReports eReport=new ExtentReports();
		ExtentSparkReporter reportType=new ExtentSparkReporter("./target/MyReport.html");
		eReport.attachReporter(reportType);
		
		ExtentTest test = eReport.createTest("Test1");
		
		test.info("Hi this is info");
		test.pass("this is pass");
		test.warning("this is warning");
		test.fail("this is fail");
		
		ExtentTest test2 = eReport.createTest("Test2");
		
		test2.info("Hi this is info");
		test2.pass("this is pass");
//		test2.warning("this is warning");
//		test2.fail("this is fail");
		
		eReport.flush();//flush() actually generates the report. Must n should add it at the end
		
	
		
	}
}
