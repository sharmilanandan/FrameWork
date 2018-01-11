package deletedDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport_Demo {

	public static void main(String[] args) {
		// 
		ExtentReports er=new ExtentReports();
		ExtentHtmlReporter r=new ExtentHtmlReporter("./res/MyResult11.html");
		er.attachReporter(r);
		ExtentTest t1=er.createTest("valid_login");
		t1.pass("pass");
		t1.fail("fail");
		t1.warning("warning");
		t1.error("error");

		
		
		

	}

}
