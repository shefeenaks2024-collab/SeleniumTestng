package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTestclass extends Baseclass {

	public HomePage home;
	public ManageNewsPage managenews;

	@Test(priority = 1, description = "Verify user able to add news successfully")
	public void verifuserabletopublishmessage() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPageU");
		String password = ExcelUtility.readStringData(1, 1, "LoginPageU");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterpassword(password);
		home = loginpage.clickSignin();
		boolean home1 = loginpage.isHomePageDisplayed();
		Assert.assertTrue(home1, Constant.LOGIN_VALID_CREDENTIALS);

		// ManageNewsPage manage = new ManageNewsPage(driver);

		String newsmessage = ExcelUtility.readStringData(1, 0, "ManageNews");
		managenews = home.clickonmoreinfo();
		managenews.clickOnNews().enterMessage(newsmessage).save();
		// manage.entermessage();
		// manage.save();
		boolean msgalert = managenews.isAlertmessageDisplayed();
		Assert.assertTrue(msgalert);
	}

}
