package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.Fileuploadutility;
import utilities.Waitutility;

public class ManageCategoryPage {

	public WebDriver driver;

	//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i[@class='fas fa-arrow-circle-right']")
	//WebElement categoryinfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement category_new;
	//@FindBy(xpath = "//a[normalize-space(text())='New']")
	//WebElement category_new;
	//@FindBy(xpath="//a[contains(@href,'/admin/Category/add') and contains(normalize-space(.),'New')]WebElement category_new")WebElement category_new;
	
	@FindBy(xpath = "//input[@name='category']")
	WebElement category_name;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement discount;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement addfile;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement Save;
	@FindBy(xpath="//div[contains(@class,'alert-success')]")WebElement AlertMessage;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	/*public void clickoncategorymoreinfo() {
		categoryinfo.click();
	}*/

	public ManageCategoryPage clickOnNew()
	{
		//Actions act=new Actions(driver);
		//act.click(category_new).perform();
	//category_new.click();
		//return this;
		JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", category_new);
		return this;

	}

	public ManageCategoryPage addData() {
		category_name.sendKeys("Hero");
		discount.click();
		return this;

	}

	public ManageCategoryPage addFile() {
		Fileuploadutility fileupload = new Fileuploadutility();
		fileupload.fileUploadUsingSendkeys(addfile, Constant.TESTDATAIMAGE);
		return this;
	}

	public ManageCategoryPage saveData() {
		Save.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return AlertMessage.isDisplayed();
		
		
	}
}
