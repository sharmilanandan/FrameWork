package generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import exception.ColourMismatchException;
import exception.DBValueMismatchException;
import exception.ElementNotPresentException;
import exception.FontMismatchException;
import exception.FontSizeMismatchException;
import exception.ListBoxNotSortedException;
import exception.OptionNotFoundException;
import exception.TextNotMatchingException;
import exception.TitleNotMatchingException;
import exception.UrlNotMatchingException;

public class WebGeneric {
	public static void enter(WebDriver driver,String keyword2,String keyword3){
		driver.findElement(By.xpath(keyword2)).sendKeys(keyword3);
	}
	//----------------------------
	public static void click(WebDriver driver,String keyword2)
	{
		driver.findElement(By.xpath(keyword2)).click();
	}
	//--------------------
	public static void verifyElementPresent(Logger log,WebDriver driver,String keyword2)
	{
		try{
			boolean displayed = driver.findElement(By.xpath(keyword2)).isDisplayed();
			if(displayed){
				log.info("PASS: Element is present "+keyword2);
			}
			else{
				log.error("FAIL:Element is not present");
				String msg="Element is not present:";
				throw new ElementNotPresentException(msg+keyword2);
			}
				
			
		}
		catch(NoSuchElementException e){
			String msg="Element is not present in (SRC):";
			throw new ElementNotPresentException(msg+keyword2);
			
			
		}
	}
	public static void verifyElementPresent(Logger log,WebDriver driver,String keyword2,String keyword3)
	{
		Long timeOut=Long.parseLong(keyword3);
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		try{
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(keyword2)));
				log.info("PASS: Element is present "+keyword2);
			}
			
		catch(TimeoutException e){
			log.error("FAIL:Element is Not present even after:"+timeOut+"Section");
			throw new ElementNotPresentException("Element is not present in (SRC):"+keyword2);
						
		}}
		public static void verifyTitle(Logger log,WebDriver driver,String keyword2,String keyword3)
		{
			Long timeOut=Long.parseLong(keyword3);
			log.info("Expected Title:"+keyword2);
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			try{
				    wait.until(ExpectedConditions.titleIs(keyword2));
					log.info("PASS:Title is matching");
				}
				
			catch(TimeoutException e){
				String aTitle=driver.getTitle();
				log.info("Actual Title "+aTitle);
				log.error("FAIL:Title  is Not Matching even after:"+timeOut+"Section");
				throw new TitleNotMatchingException("Title not Matching");
							
			}
	}
		public static void verifyURLPresent(Logger log,WebDriver driver,String keyword2,String keyword3)
		{
			Long timeOut=Long.parseLong(keyword3);
			log.info("Expected URL Fraction:"+keyword2);
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			try{
				    wait.until(ExpectedConditions.urlContains(keyword2));
					log.info("PASS:Actual url contains expected url fraction");
				}
			
			catch(TimeoutException e){
				String aUrl=driver.getCurrentUrl();
				log.info("Actual url "+aUrl);
				log.error("FAIL:URL does not contain Expected URL Fraction");
				throw new UrlNotMatchingException("URL not Matching");
							
			}
	}
		
		public static void verifyElementisEnabled(Logger log,WebDriver driver,String keyword2)
		{
			boolean enabled = driver.findElement(By.xpath(keyword2)).isEnabled();
			if(enabled){
				log.info("PASS:Element isEnabled "+keyword2);
			}
			else{
				log.info("FAIL: Element isDisabled"+keyword2);
				throw new InvalidElementStateException();//built in exception
			}
		}
		public static void verifyElementisSelected(Logger log,WebDriver driver,String keyword2)
		{
			boolean selected = driver.findElement(By.xpath(keyword2)).isSelected();
			if(selected)
			{
				log.info("Element isSelected "+keyword2);
			}
			else{
				log.error("Element is not Selectetd :"+keyword2);
				throw new ElementNotPresentException("Element not selected");
			}
		}
		public static void verifyText(Logger log,WebDriver driver,String keyword2,String keyword3){
			log.info("Expected Text "+keyword3);
			String aText=driver.findElement(By.xpath(keyword2)).getText();
			log.info("Actual text "+aText);
			if(aText.equalsIgnoreCase(keyword3))
			{
				log.info("PASS:Text is Matching");
			}
			else{
				log.error("FAIL:Text is not matchin");
				throw new TextNotMatchingException("Text is not matching");
			}
		}
		public static void verifyColour(Logger log,WebDriver driver,String keyword2,String keyword3)
		{
			WebElement element=driver.findElement(By.xpath(keyword2));
			String aColour=element.getCssValue("color");
			String hColour=Color.fromString(aColour).asHex();
			log.info("Actual colour code:"+aColour);
			log.info("Expected colour code"+hColour);
			if(hColour.equals(keyword3))
			{
				log.info("pass:Colour is matching for "+keyword2);
			}
			else{
				log.error("Fail:Colour is not matching for"+keyword2);
				throw new ColourMismatchException("colour is not matching exception");
			}
			
		}
		public static void verifyFont(Logger log,WebDriver driver,String keyword2,String keyword3)
		{
			WebElement element=driver.findElement(By.xpath(keyword2));
			String aFont=element.getCssValue("font-family");
			log.info("Actual Font:"+aFont);
			log.info("Expected Font"+keyword3);
			if(aFont.equals(keyword3))
			{
				log.info("PASS:Font is matching for "+keyword2);
			}
			else{
				log.error("Fail:Font is not matching for"+keyword2);
				throw new FontMismatchException("Font is not matching exception");
			}
			
		}
		 
		 public static void verifyFontSize(Logger log,WebDriver driver,String keyword2,String keyword3)
			{
				WebElement element=driver.findElement(By.xpath(keyword2));
				String aFont=element.getCssValue("font-size");
				log.info("Actual Font-Size:"+aFont);
				log.info("Expected Font-size"+keyword3);
				if(aFont.contains(keyword3))
				{
					log.info("PASS:Font-size is matching for "+keyword2);
				}
				else{
					log.error("Fail:Font-size is not matching for"+keyword2);
					throw new FontSizeMismatchException("Font-size is not matching exception");
				}
				
			}
		 public static void mouseHover(Logger log,WebDriver driver,String keyword2)
		 {
			 Actions actions=new Actions(driver);
			 WebElement e=driver.findElement(By.xpath(keyword2));
			 actions.moveToElement(e).perform();
			 log.info("Hovering on element:"+keyword2);
			 
		 }
		 public static void dragDrop(Logger log,WebDriver driver,String keyword2,String keyword3)
		 {
			Actions actions=new Actions(driver);
			WebElement from=driver.findElement(By.xpath(keyword2));
			WebElement to=driver.findElement(By.xpath(keyword3));
			actions.dragAndDrop(from,to).perform();
			log.info("Drag element :"+keyword2);
			log.info("Drop it on to element :"+keyword3);
		 }
		 public static void doubleClick(Logger log,WebDriver driver,String keyword2)
		 {
			Actions actions=new Actions(driver);
			WebElement e=driver.findElement(By.xpath(keyword2));
			
			actions.doubleClick(e).perform();
			log.info("Double clicking on element :"+keyword2);
		 }
		 public static void rightClick(Logger log,WebDriver driver,String keyword2)
		 {
			Actions actions=new Actions(driver);
			WebElement e=driver.findElement(By.xpath(keyword2));
			actions.contextClick(e).perform();
			log.info("Double clicking on element :"+keyword2);
		 }
		 public static void selectOptionByIndex(Logger log,WebDriver driver,String keyword2,String keyword3)
		 {
			WebElement e = driver.findElement(By.xpath(keyword2));
			Select select=new Select(e);
			int index=Integer.parseInt(keyword3);
			select.selectByIndex(index);
			log.info("Selecting option in ListBox using index"+keyword3);
			
		 }
		 public static void selectOptionByValue(Logger log,WebDriver driver,String keyword2,String keyword3)
		 {
			WebElement e = driver.findElement(By.xpath(keyword2));
			Select select=new Select(e);
			select.selectByValue(keyword3);
			log.info("Selecting option in ListBox using value"+keyword3);
			
		 }
		 public static void selectOptionByText(Logger log,WebDriver driver,String keyword2,String keyword3)
		 {
			WebElement e = driver.findElement(By.xpath(keyword2));
			Select select=new Select(e);
			select.selectByVisibleText(keyword3);
			log.info("Selecting option in ListBox using Text:"+keyword3);
			
		 }
		 public static void deselectOptionByIndex(Logger log,WebDriver driver,String keyword2,String keyword3)
		 {
			WebElement e = driver.findElement(By.xpath(keyword2));
			Select select=new Select(e);
			int index=Integer.parseInt(keyword3);
			select.deselectByIndex(index);
			log.info("Selecting option in ListBox using index"+keyword3);
			
		 }
		 public static void deselectOptionByValue(Logger log,WebDriver driver,String keyword2,String keyword3)
		 {
			WebElement e = driver.findElement(By.xpath(keyword2));
			Select select=new Select(e);
			select.deselectByValue(keyword3);
			log.info("DeSelecting option in ListBox using value"+keyword3);
			
		 }
		 public static void deselectOptionByText(Logger log,WebDriver driver,String keyword2,String keyword3)
		 {
			WebElement e = driver.findElement(By.xpath(keyword2));
			Select select=new Select(e);
			select.selectByVisibleText(keyword3);
			log.info("Selecting option in ListBox using Text:"+keyword3);
			
		 }
		 public static void deselectAllOptions(Logger log,WebDriver driver,String keyword2)
		 {
			WebElement e = driver.findElement(By.xpath(keyword2));
			Select select=new Select(e);
			select.deselectAll();
			log.info("Deselecting all the optionsin listBox:");
						
		 }
		 public static void switchToFrameByIndex(Logger log,WebDriver driver,String keyword2)
		 {
			 int index=Integer.parseInt(keyword2);
			 driver.switchTo().frame(index);
			 log.info("Switching in to Frame By index:"+keyword2);
		 }
		 public static void switchToFrameByIdOrName(Logger log,WebDriver driver,String keyword2)
		 {
			 driver.switchTo().frame(keyword2);
			 log.info("Switching in to Frame By id or Name:"+keyword2);
		 }
		 public static void switchToFrameByAddress(Logger log,WebDriver driver,String keyword2)
		 {   WebElement e=driver.findElement(By.xpath(keyword2));
			 driver.switchTo().frame(e);
			 log.info("Switching in to Frame By Address:"+keyword2);
		 }
		 public static void exitFromFrameToPage(Logger log,WebDriver driver)
		 {
			 driver.switchTo().defaultContent();
			 log.info("Exiting from frame to page");
		 }
		 public static void exitFromFrameToParent(Logger log,WebDriver driver)
		 {
			 driver.switchTo().parentFrame();
			 log.info("Exiting from frame to parent");
		 }
		 public static void searchListBox(Logger log,WebDriver driver,String keyword2,String keyword3)
		 {    log.info("searching  "+keyword3+"in list box :"+keyword2);
			 boolean found=false;
			 WebElement e=driver.findElement(By.xpath(keyword2));
			 Select select=new Select(e);
			 List<WebElement> allOptions=select.getOptions();
			 for(WebElement options:allOptions)
			 {
				 String text=options.getText();
				 log.info("comparing with :"+text);
				 if(text.equalsIgnoreCase(keyword3))
				 {    found=true;
					break;
				 }
			}
			 if(found)
			 {
				 log.info("PASS: Option found in listbox");
			 }
			 else{
				 log.error("FAIL: option not found in listbox");
				 throw new OptionNotFoundException();
			 }
			 
		 }
		 public static void isListBoxSorted(Logger log,WebDriver driver,String keyword2)
		 {
                 log.info("checking the listbox is sorted");
			 
			 WebElement e=driver.findElement(By.xpath(keyword2));
			 Select select=new Select(e);
			 List<WebElement> allOptions=select.getOptions();
			 ArrayList<String> allText=new ArrayList<String>();
			 for(WebElement options:allOptions)
			 {
				 allText.add(options.getText());
		     }
			 ArrayList<String> copy=new ArrayList<String>(allText);
			 Collections.sort(copy);
			 if(allText.equals(copy)){
				 log.info("PASS: List box is in sorted order");
			 }
			 else{
				 log.info("FAIL: List box is not in sorted order");
				 throw new ListBoxNotSortedException();
			 }
		 
		 
		
		 }
		 public static void checkInDB(Logger log,String keyword2,String keyword3)
		 {
			 log.info("Expected value: "+keyword3);
			 log.info("Executing following query in DB: ");
			 log.info(keyword2);
			 String v=DataBase.getFirstValueFromDB(keyword2);
			 log.info("Actual value from DB: "+v);
			 if(v.equals(keyword3))
			 {
				 log.info("PASS: value is matching in DB");
			 }
			 else{
				 log.error("FAIL:value is not matching in DB");
				 throw new DBValueMismatchException();
			 }
			 
		 }
		 public static void checkMultipleInDB(Logger log,WebDriver driver,String keyword2,String keyword3)
		 {
			 log.info("Expected value from script");
			 String[] s1 = keyword3.split(";");
			 ArrayList<String> fromXL=new ArrayList<String>();
			 for(String s:s1)
			 {
				 fromXL.add(s);
				 log.info(s);
			 }
			 log.info("Executing following query in DataBase:");
			 log.info(keyword2);
			 ArrayList<String> fromDB=DataBase.getAlltValueFromDB(keyword2);
			 log.info("Actual value from database:");
			 for(String s:fromDB)
			 {
				 log.info(s);
			 }
			 if(fromXL.equals(fromDB))
			 {
				 log.info("PASS:Value is matching in DB");
			 }
			 else{
				 log.error("FAIL: value is not matching in DB");
				 throw new DBValueMismatchException();
			 }
		 }

}
