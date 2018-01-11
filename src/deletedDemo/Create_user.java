package deletedDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Create_user {
	static{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8080/app/admin/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin1");
		driver.findElement(By.xpath("//button[.='Login']")).click();
		driver.findElement(By.xpath("//img[@id='button-menu']")).click();
		driver.findElement(By.xpath("(//a[@class='parent'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[.='Customers']")).click();
   	    driver.findElement(By.xpath("//i[@class='fa fa-plus']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("sharmila");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("NandaKumar");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("devi.sharmila37@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("password");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
		
		
		
		
		

	}

}
