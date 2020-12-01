package Sir.com.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Sir.com.util.BaseClass;
import Sir.com.util.ExcelOperation;
import Sir.com.webPage.LoginPage;
import Sir.com.webPage.OpenTaskPage;

@Listeners(Sir.com.util.FrameWorkListener.class)
 class TestScript1Login extends BaseClass {
	LoginPage  l ;
	OpenTaskPage otp;
	@Test(dataProvider="actiTimeData")
	public void testLoginPage(String userNames,String passWords) throws InterruptedException
	{
		l= new LoginPage();
		otp = new OpenTaskPage();
		l.clearUserName();
		l.enteruserName(userNames);
		l.clearPassWord();
		l.enterPassword(passWords);
		l.clickOnLoginButton();
		Thread.sleep(3000);
		if(driver.getTitle().contains("actiTIME - Open Tasks"))
		{
		otp.clickOnLogoutButton();
		}
		else
		{
			String s = l.getErrorMessage();
			System.out.println(s);
		}
		
	}
	
	
	
	@DataProvider(name="actiTimeData")
	public Object[][] passData() throws EncryptedDocumentException, InvalidFormatException, IOException

	{
		ExcelOperation  rev= new ExcelOperation(System.getProperty("user.dir")+"\\test-data\\Moduls.xlsx");
	int row = rev.getRowCount(0);
		Object [][] Data=new Object[row][2];
		for(int i=0 ; i<row ; i++)
		{
			Data [i][0]=rev.readData(0, i, 0);
			Data [i][1]=rev.readData(0, i, 1);
		}
		
		return Data;

}
}
