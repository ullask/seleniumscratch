package SeleniumStart;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestNGSample {
	WebDriver driver =null;
	boolean flag=true;
	@BeforeTest
	public WebDriver  initDriver() throws InterruptedException 
	{				
		if(driver==null)
		{
			driver = new FirefoxDriver();
			
		}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Before  all Test");
			return driver;
			
	}

//	public void closeDriver()
//	{
//		driver.close();
//	}
//	
	@AfterTest
	public void quitDriver() throws InterruptedException
	{
		driver.close();
		
		
		//driver.wait(5000);
		
		//driver.quit();
		
		System.out.println("After all Test");
	}	
	
	@BeforeMethod
	public  void testBeforeEachTest()
	{
		
		System.out.println("Before each test");
		
	}
	
	@AfterMethod
	public void AfterEachMethod()
	{
		System.out.println("After each test");
	}
	
	
	@Test
	public void testSample()
	{
		driver.get("http://www.calculator.net/mortgage-payoff-calculator.html");
		driver.findElement(By.xpath("//*[@id='cpayoff1']")).click();
	    System.out.println("Test 1: Radio button Selected is "+driver.findElement(By.id("cpayoff1")).isSelected());
		boolean status = driver.findElement(By.id("cpayoff1")).isSelected();
		Assert.assertEquals(status, false);
		System.out.println("After assertion");
	}
	@Test
	public void testSample1()
	{
		flag = false;
		if(!flag)
			throw new SkipException("Skipped");
		else
		System.out.println("Test 2: print");
		
	}





}