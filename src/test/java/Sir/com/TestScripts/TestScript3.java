package Sir.com.TestScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Sir.com.util.BaseClass;
import Sir.com.webPage.LoginPage;
import Sir.com.webPage.OpenTaskPage;
import Sir.com.webPage.StaffOutputReportPage;

@Listeners(Sir.com.util.FrameWorkListener.class)
public class TestScript3 extends BaseClass{
	
	@Test
	public void testsetCalender() throws InterruptedException
	{
		LoginPage  l = new LoginPage();
		OpenTaskPage  otp = new OpenTaskPage();
		StaffOutputReportPage sor = new StaffOutputReportPage();
		l.enteruserName("admin");
		l.enterPassword("manager");
		l.clickOnLoginButton();
		otp.clickOnLinkReport();
		String mainWindow = driver.getWindowHandle();
		sor.clickOnLinkCalender();
		Set<String> allWindows = driver.getWindowHandles();
		for (String s: allWindows)
		{
			driver.switchTo().window(s);
			if (driver.getTitle().contains("Calendar"))
			{
				driver.manage().window().maximize();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[text()='23']")).click();
				break;
			}
			
		}
		driver.switchTo().window(mainWindow);
		otp.clickOnLogoutButton();
			
		
	}
	

}
