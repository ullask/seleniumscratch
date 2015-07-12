package SeleniumStart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
//import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
//dynamic browser,fire fox profiler

public class DynamicBrowser 
{	
	static WebDriver driver= null;

	static String browser = "Firefox";
	static FirefoxProfile myprof = null;
	//static String browser = "Chrome";
	
	//static String browser = "Ie";
	@AfterTest
	public void quitDriver() throws InterruptedException
	{
		driver.close();
		
		
		//driver.wait(5000);
		
		//driver.quit();
		
		System.out.println("After all Test");
	}	

   @Test
	public void testDynamicBrowser() throws InterruptedException
	{
		fireFoxProfiler();
		initDriver();
		driver.get("https://gmail.com");
						
		WebElement lnkSignin = driver.findElement(By.xpath("//*[@id='gmail-sign-in']"));
		if(lnkSignin.isDisplayed())
		{
	lnkSignin.click();
    Thread.sleep(5000);
		}
        WebElement txtUserName = driver.findElement(By.id("Email"));
        txtUserName.sendKeys("ullasdwaraka@gmail.com");
        WebElement btnNext  = driver.findElement(By.id("next"));
	    btnNext.click();
	    Thread.sleep(5000);	
	    WebElement btnPswd = driver.findElement(By.id("Passwd"));
	    btnPswd.sendKeys("password");
	    System.out.print("Gmail opened");
	}


	public static  WebDriver initDriver()
	{
		if(driver == null)
		{
			getDriver();
		}
		return driver; 
			
	}
	public static  WebDriver getDriver()
	{
	if(browser =="Firefox")
	{
    // driver = new FirefoxDriver();	
     driver = new FirefoxDriver(myprof);	
	}
	else if(browser == "Chrome")
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe" );
		driver = new ChromeDriver();
		
	}
	else if(browser == "Ie")
	{
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe" );
		driver = new InternetExplorerDriver();
		
	}
	 return driver;
	}
	
	public static void  fireFoxProfiler()
	{
		ProfilesIni allprofs= new ProfilesIni();
		myprof = allprofs.getProfile("Selenium");
		
	}
	  	
}

