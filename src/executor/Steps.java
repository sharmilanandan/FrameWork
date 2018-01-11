package executor;
import generic.Excel;
import generic.Screenshot;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
public class Steps {
	public static void  executeSteps(Logger log,WebDriver driver,String path,String sheet)
	{   
		
		log.info("start execute steps");
	    int stepcount=Excel.getRowCount(path, sheet);
	    log.info("step count:"+stepcount);
	    for(int i=1;i<=stepcount;i++)
	    {
	    log.info("-----start step:"+i+"-------");
		String desc = Excel.getCellValue(path, sheet, i, 0);
		log.info("Desc:"+desc);
		String keyword1 = Excel.getCellValue(path, sheet, i, 1);
		log.info("keyword1:"+keyword1);
		String keyword2 = Excel.getCellValue(path, sheet, i, 2);
		log.info("keyword2:"+keyword2);
		String keyword3 = Excel.getCellValue(path, sheet, i, 3);
		log.info("keyword3:"+keyword3);
		
		String oldTitle=driver.getTitle();
		Keyword.executeKeyword(log, driver,keyword1,keyword2,keyword3);
		String newTitle=driver.getTitle();
		if(oldTitle.equals(newTitle))
		{
			log.info("same page no navigation");
		}
		else{
			log.info("Diff page so taking screen shot");
			String imgName=Screenshot.generateimageName();
			String imgPath=IAutoConst.PAGE_PHOTO_PATH+"/"+sheet+"_"+imgName;
			log.info("Taking Screenshot:"+imgPath);
			Screenshot.get(driver, imgPath);
						
		}
					
		log.info("end execute steps");

		log.info("----EndStep"+i+"-----------");
	    }
	}

}
