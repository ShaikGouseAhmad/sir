package Sir.com.webPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sir.com.util.BaseClass;

public class AddNewCustomerPage {
	
	@FindBy(name="name")
	private WebElement enterCustomerName;
	
	@FindBy(name="createCustomerSubmit")
	private WebElement clickOnCreateCustomer;
	
	@FindBy(id="add_project_action")
	private WebElement createnewprojectforthiscustomer;
	
	@FindBy(id="active_customers_action")
	private WebElement showlistofactiveprojectsandcustomers;
	
	@FindBy(id="add_more_customers_action")
	private WebElement  addmorecustomers;
	
	@FindBy(className="successmsg")
	private WebElement successMessage;
	
	public AddNewCustomerPage()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void enterCustomerName(String name)
	{
		enterCustomerName.sendKeys(name);	
	}
	
	public void clickOnCreateCustomerButton()
	{
		clickOnCreateCustomer.click();
	}
	
	public void showlistofactiveprojectsandcustomersRadioButton()
	{
		showlistofactiveprojectsandcustomers.click();
	}
	
	public void createnewprojectforthiscustomerRadioButton()
	{
		createnewprojectforthiscustomer.click();
	}
	public void addmorecustomersRadioButton()
	{
		addmorecustomers.click();
	}
	
	public String retrieveSuccessMessage()
	{
		String s = successMessage.getText();
		return s;
	}

}
