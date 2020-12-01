package Sir.com.TestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Sir.com.util.BaseClass;
import Sir.com.webPage.LoginPage;
import Sir.com.webPage.OpenTaskPage;

@Listeners(Sir.com.util.FrameWorkListener.class)
public class TestScript2  extends BaseClass{
	
	@Test
	public void testOnWindow() throws AWTException, InterruptedException
	{
		LoginPage l = new LoginPage();
		OpenTaskPage otp = new OpenTaskPage();
		l.clearUserName();
		l.enteruserName("admin");
		l.clearPassWord();
		l.enterPassword("manager");
		l.clickOnLoginButton();
		WebElement w = driver.findElement(By.linkText("Projects & Customers"));
		  Actions  a = new Actions(driver);
		  a.contextClick(w).build().perform();
		  Robot  r = new Robot();
		  Thread.sleep(3000);
		  r.keyPress(KeyEvent.VK_DOWN);
		  r.keyPress(KeyEvent.VK_ENTER);  
		  String mainWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for (String s: allWindows)
			{
				driver.switchTo().window(s);
				if (driver.getTitle().contains("actiTIME - Active Projects & Customers"))
				{
					driver.manage().window().maximize();
					driver.close();
					break;
				}
				
			}
				
			driver.switchTo().window(mainWindow);
			otp.clickOnLogoutButton();
		
		
	}

}
