package Sir.com.webPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sir.com.util.BaseClass;

public class StaffOutputReportPage {
	
	@FindBy(xpath="//img[@alt='Click Here to Pick up the date']")
	private WebElement clickOnlinkCalender;
	
	
	public StaffOutputReportPage()
	{
		PageFactory.initElements(BaseClass.driver,this);
	}
	
	public void clickOnLinkCalender()
	{
		clickOnlinkCalender.click();
	}

}
