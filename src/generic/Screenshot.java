package generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void get(WebDriver driver,String destFile) {
		TakesScreenshot t=(TakesScreenshot)driver;
		File srcFile=t.getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(srcFile,new File(destFile));
			}
		catch(IOException e){
			e.printStackTrace();
		}

	}

	public static String generateimageName() {
		SimpleDateFormat s=new SimpleDateFormat("dd-MMM-yy_hh-mm-ss");
		String dateTimes=s.format(new Date());
		String imgName=dateTimes+".png";
		return imgName;
	}

}
