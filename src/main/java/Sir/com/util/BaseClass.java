package Sir.com.util;

import java.io.FileInputStream;




import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public static Logger log; 
	FileInputStream fis;
	Properties p;
	
	@Parameters({"browser1"})
	 
	 @BeforeTest
	public void setupBrowser(String browser1) throws IOException
	{
		 log = Logger.getLogger(BaseClass.class);
		 PropertyConfigurator.configure("Log4j.properties");
		if(browser1.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
	      driver = new ChromeDriver();
	      log.info("*************Chrome Browser Launched *****************");
		}
		else if(browser1.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("*************Firefox Browser Launched *****************");
		}	
		else
		{
			System.out.println("no Browser Selected");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		fis = new FileInputStream(System.getProperty("user.dir")+"//App.properties");
		p = new Properties();
		p.load(fis);	
		driver.get(p.getProperty("url"));
		log.info("************* Entered Url *****************");
	}
	@AfterTest
	 public void closeBrowser()
	 {
		 driver.close();
	 }
}
