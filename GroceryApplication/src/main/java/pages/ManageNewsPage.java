package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageNewsPage {

	public WebDriver driver;

	//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'][normalize-space()='More info']")
	//WebElement news_moreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement New;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement message;
	@FindBy(xpath = "//button[@name='create']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newsalert;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*public void clickonmoreinfo() {
		news_moreinfo.click();
	}*/

	public ManageNewsPage clickOnNews() {
		New.click();
		return this;
	}

	public ManageNewsPage enterMessage(String newsmessage) {
		message.sendKeys(newsmessage);
		return this;
	}

	public ManageNewsPage save() {
		save.click();
		return this;
	}

	public boolean isAlertmessageDisplayed() {
		return newsalert.isDisplayed();
	}

}
