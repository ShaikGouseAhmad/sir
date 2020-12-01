package Sir.com.webPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sir.com.util.BaseClass;

public class OpenTaskPage {
	@FindBy(className="logoutImg")
	private WebElement logout;
	
	@FindBy(linkText="Projects & Customers")
	private WebElement clickonlinkProjectsCustomers;
	
	@FindBy(linkText="Reports")
	private WebElement clickonlinkReport;
	
	
	
	public OpenTaskPage()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void clickOnLogoutButton()
	{
		logout.click();
	}
	
	public void clickOnLinkProjectsCustomers()
	{
		clickonlinkProjectsCustomers.click();
	}
	public void clickOnLinkReport()
	{
		clickonlinkReport.click();	
	}

}
