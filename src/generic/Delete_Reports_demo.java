package generic;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Delete_Reports_demo {

	public static void main(String[] args) {
		//create a extentreports
		ExtentReports e=new ExtentReports();
		
		//create extentReport type and Attatch it to ExtentReport
		ExtentHtmlReporter h=new ExtentHtmlReporter("./res/Report.html");
		e.attachReporter(h);
		
		//create test and say pass/fail
		ExtentTest test=e.createTest("Valid login");
		test.pass("This test is pass");
		
		//create test and say pass/fail
		ExtentTest test2=e.createTest("InvalidLogin");
		test2.info("Here also v have diff methods like v have in log4j");
		test2.warning("Warning msg.. like log4j");
		test2.fail("This test is failed");
		
		//adding a photo
		File f=new File("./photo/ForFailure/login.png");
		String p=f.getAbsolutePath();
		System.out.println(p);
		try {
			test2.addScreenCaptureFromPath(p);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//finally publish the report
		e.flush();
		
		

	}

}
