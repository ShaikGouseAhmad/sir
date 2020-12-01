package Sir.com.webPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sir.com.util.BaseClass;

public class ActiveProjectsAndCustomer {
	
	@FindBy(xpath="//input[@value='Add New Customer']")
	private WebElement clickOnAddNewCustomer;
	
	@FindBy(xpath="//input[@value='Add New Project']")
	private WebElement clickOnAddNewProject;
	
	@FindBy(className="successmsg")
	private WebElement successMessage;
	
	public ActiveProjectsAndCustomer()
	{
		PageFactory.initElements(BaseClass.driver,this);
	}
	
	public void clickOnAddNewCustomerButton()
	{
		clickOnAddNewCustomer.click();
	}
	
	public void clickOnAddNewProjectButton()
	{
		clickOnAddNewProject.click();	
	}
	public String retrieveSuccessMessage()
	{
		String s = successMessage.getText();
		return s;
	}
	
	
	

}
