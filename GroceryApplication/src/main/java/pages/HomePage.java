package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement profile;
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement logoutbtn;
	
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[contains(@href,'admin/list-admin')]")WebElement adminuser_moreinfo;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i[@class='fas fa-arrow-circle-right']")
	WebElement categoryinfo;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'][normalize-space()='More info']")WebElement contactmoreinfo;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'][normalize-space()='More info']")
	WebElement Footermoreinfo;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'][normalize-space()='More info']")
	WebElement news_moreinfo;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public AdminUsersPage clickOnAdminUsers()
	{
		adminuser_moreinfo.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageCategoryPage clickoncategorymoreinfo() {
		categoryinfo.click();
		return new ManageCategoryPage(driver);
	}
	
	public ManageContactPage clickonmanagecontact()
	{
		contactmoreinfo.click();
		return new ManageContactPage(driver);
	}
	
	public ManageFooterPage clickonmoreinfofooter() {
		Footermoreinfo.click();
		return new ManageFooterPage(driver);
	}
	
	public ManageNewsPage clickonmoreinfo() {
		news_moreinfo.click();
		return new ManageNewsPage(driver);
	}
	
	
	public void profileClick()
	{
		profile.click();
	}

	public void clickOnLogout() {

		

		logoutbtn.click();
	}

}
