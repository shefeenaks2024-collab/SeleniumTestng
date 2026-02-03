package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Pageutility;

public class ManageNewsPage {
	
	
	public WebDriver driver;
	
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'][normalize-space()='More info']")WebElement morenews;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement New;
	@FindBy(xpath="//textarea[@id='news']")WebElement message;
	@FindBy(xpath="//button[@name='create']")WebElement save;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")WebElement newsalert;
	
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickonmoreinfo()
	{
		morenews.click();
	}
	
	public void clicknew()
	{
		New.click();
	}
	
	public void entermessage()
	{
		message.sendKeys("Prod deployed");
		
	}
	public void saveclick()
	{
		save.click();
	}
	/*public void performdropdown()
	{
		Pageutility p=new Pageutility();
		p.dropdownselectByVisibleText(dropdown elementname, "India");
	}*/
	public boolean isAlertmessageDisplayed()
	{
		return newsalert.isDisplayed();
	}

	
}
