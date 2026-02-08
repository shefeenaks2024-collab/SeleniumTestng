package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	
	
	public WebDriver driver;
	
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'][normalize-space()='More info']")WebElement contactmoreinfo;
	@FindBy(xpath="//i[@class='fas fa-edit']")WebElement editicon;
	@FindBy(xpath="//input[@name='phone']")WebElement phoneno;
	@FindBy(xpath="//input[@name='email']")WebElement newemail;
	@FindBy(xpath="//button[@name='Update']")WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//child::h5")WebElement alertmsge;
	
	
	
	
	public ManageContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/*public void clickonmanagecontact()
	{
		contactmoreinfo.click();
	}*/
	
	public ManageContactPage clickOnEdit()
	{
		editicon.click();
		return this;
	}
	
	public ManageContactPage enterPhoneData(String phone)
	{
		phoneno.clear();
		phoneno.sendKeys(phone);
		return this;
		
	}
	public ManageContactPage enterMail(String email)
	{
		newemail.clear();
		newemail.sendKeys(email);
		return this;
	}
	
	public ManageContactPage updateData()
	{
		update.click();
		return this;
	}
	
	public boolean  isAlertDisplayed()
	{
		return alertmsge.isDisplayed();
	}

}
