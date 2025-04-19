package factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.CommonUtils;
import utils.ConfigReader;

public class DriverFactory {
	
	static WebDriver driver=null;
	

	public WebDriver initializeBrowser(String browserName)
	{
		
		
		
		if(browserName.equals("chrome"))
		{
			
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			 driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			 driver = new EdgeDriver();
		}
		else if(browserName.equals("safari"))
		{
			 driver = new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		return driver;
		
		
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
}
