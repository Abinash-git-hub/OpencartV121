package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	//create one constructor same name as class name
	//passing the driver to the parent class constructor for driver instance
	//the page object class should extend by parent class basepage
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//capture the elements
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfrmpwd;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement chkdSubscribe;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	//once account is successfully register then get the message
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	//for every elements create action methods
	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String confpwd)
	{
		txtConfrmpwd.sendKeys(confpwd);
	}
	
	public void setSubscribe()
	{
		chkdSubscribe.click();
	}
	
	public void setPolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickBtn()
	{
		btnContinue.click();
	}
	
	//we cant validate in page object class
	//so here we create one method to capture the element and verify the returned message
	//capture the text value and return the text value
	//based upon the return value we compare the text if not match it will throw exception
	
	
	public String getConfirmMsg()
	{
		try {
			return (msgConfirmation.getText());  //capture the text value and retun the text value
		}catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
	
//in future if we want automate something else then if we need more lements
//then for this page we can add more no of elements and action methods
//as soon as completing new test cases so there will be requirement to update the page object calss
//so we doing keep adding more no of elements and action methods,
//that is the continuous task till we completing the all the test cases 
	


