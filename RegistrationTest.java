package Signup;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class RegistrationTest {
	//WebDriver driver;
	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver =new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");//opens the url of the website 
		driver.manage().window().maximize();//maximize the window 
		Thread.sleep(3000);
	}

	@AfterClass
	public static void tearDownAfterClass( ) throws Exception {
		
		driver.close();//it closes the window after execution of the @Test
	}
	

	@Test
	public void SignUp() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(3000);
		//it scroll the window at the given range
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,1000)");
	    
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("zzzzzzzzzzz@gmail.com");
		//After Entering the value Enter key is pressed using keyboard
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		
		            
		Thread.sleep(3000); 
		//Selects the Radio Button
		WebElement rb1=driver.findElement(By.xpath("//input[@id='id_gender1']"));
		rb1.click();
		driver.findElement(By.cssSelector("input[name=customer_firstname]")).sendKeys("Naveen");
		driver.findElement(By.cssSelector("input[name=customer_lastname]")).sendKeys("Shastry");
		driver.findElement(By.cssSelector("input[type=password]")).sendKeys("Naveen123");
		 js.executeScript("window.scrollBy(0,500)");
	}
		 
		 @Test
		 public void DropDown() throws InterruptedException
		 {
		 driver.findElement(By.id("days")).click();
	     Thread.sleep(2000);
	     //Drop Down used to Select the date from list
	     Select date =new Select(driver.findElement(By.id("days")));
	     date.selectByValue("10");
		 
	   //Drop Down used to Select the month from list
	    driver.findElement(By.cssSelector("select[name=months]")).click();
	    Thread.sleep(2000);
	    Select months =new Select(driver.findElement(By.cssSelector("select[name=months]")));
		months.selectByIndex(1);
		
		//Drop Down used to Select the year from list
		 driver.findElement(By.cssSelector("select[name=years]")).click();
		 Thread.sleep(2000);
		 Select years =new Select(driver.findElement(By.cssSelector("select[name=years]")));
	     years.selectByIndex(1);
		
			 
		WebElement check=driver.findElement(By.cssSelector("input[id=newsletter]"));
		check.click();
		 driver.findElement(By.cssSelector("input[id=firstname]")).sendKeys("Naveen");
		 driver.findElement(By.cssSelector("input[id=lastname]")).sendKeys("Shastry");
		 driver.findElement(By.cssSelector("input[id=address1]")).sendKeys("Bangalore");

		 driver.findElement(By.cssSelector("input[name=city]")).sendKeys("Bangalore");
		 driver.findElement(By.cssSelector("select[id=id_state]")).click();
		 Select state=new Select(driver.findElement(By.cssSelector("select[id=id_state]")));
		 state.selectByIndex(1);
		 driver.findElement(By.cssSelector("input[id=postcode]")).sendKeys("00000");
		 Select country=new Select(driver.findElement(By.cssSelector("select[id=id_country]")));
		 country.selectByIndex(1);
		 driver.findElement(By.cssSelector("input[id=phone_mobile]")).sendKeys("999999");
		 driver.findElement(By.cssSelector("input[id=alias]")).sendKeys("Bangalore");
		 driver.findElement(By.cssSelector("button[id=submitAccount]")).click();
		 
	}
		 @Test
public void Screenshot() throws IOException
{
			 //This method takes the Screenshot After user is registered and stores it in 
			 //ScreenShots folder 
			 TakesScreenshot ts=(TakesScreenshot)driver;
			 File source=ts.getScreenshotAs(OutputType.FILE);
			 FileHandler.copy(source,new File("./Screenshots/image1.png"));
}
	
}
