package executor;

import exception.InvalidKeywordException;
import generic.WebGeneric;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Keyword {

	public static void executeKeyword(Logger log,WebDriver driver,
			String keyword1,String keyword2,String keyword3)
	{
		
		log.info("start-executeKeyword");
		if(keyword1.equalsIgnoreCase("enter"))
		{
			WebGeneric.enter(driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("click"))
		{
			WebGeneric.click(driver, keyword2);
		}
		else if(keyword1.equalsIgnoreCase("verifyElementPresent"))
		{   if(keyword3.length()>0){
			log.info("Timeout is:"+keyword3);
			WebGeneric.verifyElementPresent(log, driver, keyword2,keyword3);
		}
			else{ 
				log.info("NO TimeOut");
				WebGeneric.verifyElementPresent(log, driver, keyword2);
			}
		   }		
		else if(keyword1.equalsIgnoreCase("verifyTitle"))
		{   log.info("Verifying Title");
			WebGeneric.verifyTitle(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("verifyURLcontains"))
		{   log.info("Verify Url is present");
			WebGeneric.verifyURLPresent(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("verifyElementisEnabled")){
			log.info("Verifying element isEnabled or not"+keyword2);
			WebGeneric.verifyElementisEnabled(log, driver, keyword2);
			
		}
		else if(keyword1.equalsIgnoreCase("verifyElementisSelected"))
				{
			     log.info("Verify checkbox/radio button element isselected");
			     WebGeneric.verifyElementisSelected(log, driver, keyword2);
				}
		else if(keyword1.equalsIgnoreCase("verifyText"))
		{
			log.info("Verify Text");
			WebGeneric.verifyText(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("verifycolour"))
		{
			log.info("Verify colour");
			WebGeneric.verifyColour(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("verifyFont")){
			log.info("Verify font");
			WebGeneric.verifyFont(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("verifyFontSize"))
		{
			log.info("Verifying font-size");
			WebGeneric.verifyFontSize(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("mouseHover"))
		{    
			log.info("Hovering on element:"+keyword2);
			WebGeneric.mouseHover(log, driver, keyword2);
		}
		else if(keyword1.equalsIgnoreCase("dragDrop"))
		{
			log.info("Drag element :"+keyword2);
			log.info("Drop it on to element :"+keyword3);
			WebGeneric.dragDrop(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("doubleClick"))
		{
			log.info("Double clicking on element :"+keyword2);
			WebGeneric.doubleClick(log, driver, keyword2);
		}
		else if(keyword1.equalsIgnoreCase("rightClick"))
		{
			log.info("Double clicking on element :"+keyword2);
			WebGeneric.rightClick(log, driver, keyword2);
		}
		else if(keyword1.equalsIgnoreCase("selectOptionByIndex"))
		{
			log.info("Selecting option in ListBox using index"+keyword3);
			WebGeneric.selectOptionByIndex(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("selectOptionByValue"))
		{
			log.info("Selecting option in ListBox using value"+keyword3);
			WebGeneric.selectOptionByValue(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("selectOptionByText"))
		{
			log.info("Selecting option in ListBox using Text:"+keyword3);
			WebGeneric.selectOptionByText(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("deselectOptionByIndex"))
		{
			log.info("Selecting option in ListBox using index"+keyword3);
			WebGeneric.deselectOptionByIndex(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("deselectOptionByValue"))
		{
			log.info("DeSelecting option in ListBox using value"+keyword3);
			WebGeneric.deselectOptionByValue(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("deselectOptionByText"))
		{
			log.info("Selecting option in ListBox using Text:"+keyword3);
			WebGeneric.deselectOptionByText(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("deselectAllOptions"))
		{
			log.info("Deselecting all the optionsin listBox:");
			WebGeneric.deselectAllOptions(log, driver, keyword2);
		}
		else if(keyword1.equalsIgnoreCase("switchToFrameByIndex"))
		{
			log.info("Switching in to Frame By index:"+keyword2);
			WebGeneric.switchToFrameByIndex(log, driver, keyword2);
		}
		else if(keyword1.equalsIgnoreCase("switchToFrameByIdOrName"))
		{
			 log.info("Switching in to Frame By id or Name:"+keyword2);
			 WebGeneric.switchToFrameByIdOrName(log, driver, keyword2);
		}
		else if(keyword1.equalsIgnoreCase("switchToFrameByAddress"))
		{
			log.info("Switching in to Frame By Address:"+keyword2);
			WebGeneric.switchToFrameByAddress(log, driver, keyword2);
		}
		else if(keyword1.equalsIgnoreCase("exitFromFrameToPage"))
		{
			log.info("Exiting from frame to page");
			WebGeneric.exitFromFrameToPage(log, driver);
		}
		else if(keyword1.equalsIgnoreCase("exitFromFrameToParent"))
		{
			 log.info("Exiting from frame to parent");
			 WebGeneric.exitFromFrameToParent(log, driver);
		}
		else if(keyword1.equalsIgnoreCase("searchListBox"))
		{
			log.info("searching "+keyword3+" in listbox");
			WebGeneric.searchListBox(log, driver, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("isListBoxSorted"))
		{
			log.info("Checking list box is sorted or not");
			WebGeneric.isListBoxSorted(log, driver, keyword2);
			}
		else if(keyword1.equalsIgnoreCase("checkInDB"))
		{
			log.info("Checking data with database");
			WebGeneric.checkInDB(log, keyword2, keyword3);
		}
		else if(keyword1.equalsIgnoreCase("checkMultipleInDB"))
		{
			log.info("Checking multiple values in DB:");
			WebGeneric.checkMultipleInDB(log, driver, keyword2, keyword3);
		}
			
		else
		{   
			log.error("invalid keyword");
			throw new InvalidKeywordException("Invalid Keyword:"+keyword1);
		}
		log.info("End-ExecuteKeyword");
  
	}

}
