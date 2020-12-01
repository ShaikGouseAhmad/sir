package Sir.com.webPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sir.com.util.BaseClass;

public class AddNewProject {
	
	
	@FindBy(name="name")
	private WebElement projectName;
	
	@FindBy(id="active_projects_action")
	private WebElement showlistofactiveprojectsandcustomers;
	
	@FindBy(id="add_tasks_action")
	private WebElement addtaskstothisproject;
	
	
	public AddNewProject()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
	public void enterProjectName(String name)
	{
		projectName.sendKeys(name);
	}
	
	public void clickOnshowlistofactiveprojectsandcustomersRadioButton()
	{
		showlistofactiveprojectsandcustomers.click();
	}
	
	public void clickOnaddtaskstothisprojectRadioButton()
	{
		addtaskstothisproject.click();
	}
	
	

}
