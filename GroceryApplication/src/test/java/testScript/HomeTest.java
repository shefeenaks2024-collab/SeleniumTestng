package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Baseclass {
	public HomePage home;

	@Test(description = "Verify whether user is able to logout successfully")
	public void verifyuserabletologout() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPageU");
		String password = ExcelUtility.readStringData(1, 1, "LoginPageU");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterpassword(password);
		home = loginpage.clickSignin();

		HomePage logout = new HomePage(driver);
		logout.profileClick();
		logout.clickOnLogout();

	}
}
