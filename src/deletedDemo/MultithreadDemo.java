package deletedDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import executor.IAutoConst;

public class MultithreadDemo extends Thread implements IAutoConst {
	String browser;
	public MultithreadDemo(String s)
	{
		browser=s;
	}
	public void run(){
		WebDriver driver;
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else{
			driver=new FirefoxDriver();
		}
		driver.get("http://localhost:8080/app/admin/index.php");
		for(int i=1;i<=200;i++)
		{
			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("username")).sendKeys("admin");
		}
		driver.close();
	}
	static{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}

	public static void main(String[] args) {
		MultithreadDemo d=new MultithreadDemo("chrome");
		d.start();
		MultithreadDemo d2=new MultithreadDemo("firefox");
		d2.start();
		
		

	}

}
