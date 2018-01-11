package executor;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import generic.Excel;
import generic.Property;
import generic.Screenshot;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Driver  implements IAutoConst {
	//create the logger obj every step log folder 
	
	public static Logger log=Logger.getLogger("Driver");
	public static int pCount=0,fCount=0,tCount=0;
	public static WebDriver driver;
	static{
		log.info("set the path of Driverexecutable");
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	public static void executeScript(String scriptName) throws Exception
	{ 
		log.info("open  Browser in Remote System");
	     
	     URL remote=new URL(Property.getValue(SETTINGS_PATH, "REMOTE"));
	     DesiredCapabilities d=new DesiredCapabilities();
	     d.setBrowserName(Property.getValue(SETTINGS_PATH, "BROWSER"));
	     driver=new RemoteWebDriver(remote,d);
		String sITO=Property.getValue(SETTINGS_PATH, "ITO");//implicit time out
		long ITO=Long.parseLong(sITO);
		log.info("set ITO:"+ITO+"Sec");
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		String url=Property.getValue(SETTINGS_PATH, "URL");
		log.info("Enter the url"+url);
		driver.get(url);
			log.info("Execute script:"+scriptName);
			Steps.executeSteps(log, driver, SCRIPT_PATH, scriptName);
			
	}
	public static void executeSuite()
	{   
		ExtentReports extent=new ExtentReports();
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(EXTENT_REPORT_PATH);
        extent.attachReporter(htmlReporter);
		int scriptCount=Excel.getRowCount("./suite.xlsx","list");
 		log.info("script count:"+scriptCount);
		for(int j=1;j<=scriptCount;j++)
		{   
			String scriptName=Excel.getCellValue(SUITE_PATH,SUITE_SHEET, j, 0);
			ExtentTest test=extent.createTest(scriptName);
			String scriptStatus=Excel.getCellValue(SUITE_PATH,SUITE_SHEET, j, 1);
			log.info("script:"+scriptName+"Execute:"+scriptStatus);
			if(scriptStatus.equalsIgnoreCase("yes"))
			{   
				try{
				
					executeScript(scriptName);
					log.info("Script is PASSED:"+scriptName);
					pCount++;
					test.pass("Script is passed");
			}
				catch(Exception e)
				{
					log.error("Script is FAILED"+scriptName);
					fCount++;
					e.printStackTrace();
					String imgName=Screenshot.generateimageName();
					String imgPath=FAIL_PHOTO_PATH+"/"+scriptName+"_"+imgName;
					log.info("Taking Screenshot:"+imgPath);
					Screenshot.get(driver, imgPath);
					test.fail("Script is FAiled");
					String aImgagePath=new File(imgPath).getAbsolutePath();
					try{
						test.addScreenCaptureFromPath(aImgagePath);
					}
					catch(IOException e1)
					{
						
					}
				}
				finally{
					log.info("Quit the Browser");
					driver.quit();
				
				}
			}
			else{
				log.info("Not Executing script"+scriptName);
				test.skip("Not Executing Script");
			}
		}
		log.info("----------------------------------------");
		log.info("Total PASS:"+pCount);
		log.info("Total FAIL:"+fCount);
		tCount=pCount+fCount;
		log.info("TOtal Scripts Executed:"+tCount);
		log.info("----------------------------------------------------------");
		extent.flush();//don't forget to flush finally
	}

	public static void main(String[] args) {
	log.info("Suite Execution Started");	
	executeSuite();
	log.info("Suite EXecution Completed");
		 
	}}
		

	