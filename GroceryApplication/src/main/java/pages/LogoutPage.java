package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement profile;
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Logout']")WebElement logoutbtn;
	
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickonlogout()
	{


        profile.click();

		logoutbtn.click();
	}

}
