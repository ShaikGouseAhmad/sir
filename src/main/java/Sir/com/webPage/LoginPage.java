package Sir.com.webPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sir.com.util.BaseClass;

public class LoginPage {
	
	@FindBy(name="username")
	private WebElement userName;
	
	@FindBy(name="pwd")
	private WebElement passWord;
	
	@FindBy(xpath="//input[@valign='absmiddle']")
	private WebElement clickOnLoginButton;
	
	@FindBy(className="errormsg")
	private WebElement displayErrorMessage;
	
	
	public LoginPage()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void enteruserName(String userNames)
	{
		userName.sendKeys(userNames);
	}
	
	public void clearUserName()
	{
		userName.clear();
	}
	
	public void enterPassword(String passWords)
	{
		passWord.sendKeys(passWords);
	}
	
	public void clearPassWord()
	{
		passWord.clear();
	}
	
	public void clickOnLoginButton()
	{
		clickOnLoginButton.click();
	}
	
	public String  getErrorMessage()
	{
		String s = displayErrorMessage.getText();
		return s;
	}

	
}
