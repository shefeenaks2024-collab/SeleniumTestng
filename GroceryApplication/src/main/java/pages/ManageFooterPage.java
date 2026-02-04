package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'][normalize-space()='More info']")WebElement moreFooterinfo;
	@FindBy(xpath="//a[contains(@href,'admin/Footertext/edit?edit=1')]//child::i[@class='fas fa-edit']")WebElement editicon;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']")WebElement newaddress;
	@FindBy(xpath="//input[@name='email']")WebElement newemail;
	@FindBy(xpath="//input[@name='phone']")WebElement newphoneno;
	@FindBy(xpath="//button[@name='Update']")WebElement updatebtn;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'][normalize-space()='More info']")WebElement alertmessage;
	
	
	public ManageFooterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void clickonmoreinfofooter()
	{
		moreFooterinfo.click();
	}
	public void clickonediticon()
	{
		editicon.click();
	}
  public void editaddress(String address)
   {
	newaddress.clear();
	newaddress.sendKeys(address);
   }
	
	 public void editemail(String mailid)
	 {
	newemail.clear();
	newemail.sendKeys(mailid);
	 }
	 
	 public void editphone(String phone_no)
	 {
	newphoneno.clear();
	newphoneno.sendKeys(phone_no);
	 }
	
   
  public void clickonupdatebtn()
  {
	  updatebtn.click();
  }
  
  public boolean isAlertDisplayed()
  {
	  return alertmessage.isDisplayed();
  }
}
