package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTestclass extends Baseclass {

	public HomePage homepage;

	@Test(priority = 1, groups = {
			"Regression" }, description = "Verify user able to login by using vaid credentials successfully")
	public void verifywhetheruserisabletoenterusingvalidcredentials() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPageU");
		String password = ExcelUtility.readStringData(1, 1, "LoginPageU");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterpassword(password);
		homepage = loginpage.clickSignin();
		boolean home1 = loginpage.isHomePageDisplayed();
		Assert.assertTrue(home1, Constant.LOGIN_VALID_CREDENTIALS);

	}

	@Test(priority = 2, description = "Verify whether user able to login through wrong username and password  ")
	public void verifyuserabletoenterusinginvalidcredentials() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "LoginPageU");
		String password = ExcelUtility.readStringData(2, 1, "LoginPageU");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterpassword(password);
		homepage = loginpage.clickSignin();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.LOGIN_VALID_CREDENTIALS);

	}

	@Test(priority = 3, description = "Verify user able to login throug valid username and invalid password  ")
	public void verifyuserabletoenterusingvalidusernameandinvalidpassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "LoginPageU");
		String password = ExcelUtility.readStringData(3, 1, "LoginPageU");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterpassword(password);
		homepage = loginpage.clickSignin();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.LOGIN_VALID_CREDENTIALS);
	}

	@Test(priority = 4, dataProvider = "loginProvider", description = "Verify user is able to login by using invalid username and valid password")
	public void verifyuserabletoenterusinginvalidusernameandvalidpassword(String username, String password)
			throws IOException {
		// String username=ExcelUtility.readStringData(4, 0, "LoginPageU");
		// String password=ExcelUtility.readStringData(4, 1, "LoginPageU");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterpassword(password);
		homepage = loginpage.clickSignin();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.LOGIN_VALID_CREDENTIALS);
		
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}
}
