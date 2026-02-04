package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Pageutility;

public class AdminUsersPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[contains(@href,'admin/list-admin')]")WebElement adminmoreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement admin_new;
	@FindBy(xpath="//input[@id='username']")WebElement admin_uname;
	@FindBy(xpath="//input[@name='password']")WebElement admin_pwd;
	@FindBy(xpath="//button[@name='Create']")WebElement admin_save;
	@FindBy(xpath="//select[@name='user_type']")WebElement dropdwn_type;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//child::h5")WebElement alertmsg;
	
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickonadminusers()
	{
		adminmoreinfo.click();
	}
	public void clickonNew()
	{
		admin_new.click();
	}
	public void enteruname(String uname)
	{
		admin_uname.sendKeys(uname);
	}
	public void enterpwd(String pwd)
	{
		admin_pwd.sendKeys(pwd);
				
	}
	public void performdropdown()
	{
		Pageutility pageu=new Pageutility();
		pageu.dropdownSelectByVisibleText(dropdwn_type, "Admin");
	}
  public void savedata() 
   {
	  admin_save.click();
	  
   }
  
  public boolean isAlertDisplayed()
  {
	return alertmsg.isDisplayed();
	  
  }
}
