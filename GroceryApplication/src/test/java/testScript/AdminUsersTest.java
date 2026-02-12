package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Baseclass {

	public HomePage home;
	public AdminUsersPage adminuser;

	@Test(groups = {
			"Regression" }, description = "Verify user able to create admin users successfully", retryAnalyzer = retry.Retry.class)
	public void verifyusercancreateadminusers() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPageU");
		String password = ExcelUtility.readStringData(1, 1, "LoginPageU");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);// chaining
		// loginpage.enterpassword(password);
		home=loginpage.clickSignin();

		// String uname=ExcelUtility.readStringData(1, 0, "AdminUsers");
		FakerUtility fake = new FakerUtility();
		String uname = fake.creatARandomFirstName();
		String pwd = ExcelUtility.readStringData(1, 1, "AdminUsers");
		String roletype = ExcelUtility.readStringData(1, 2, "AdminUsers");
		// AdminUsersPage adminuser = new AdminUsersPage(driver);
		adminuser = home.clickOnAdminUsers();
		adminuser.clickOnNew().enterUsername(uname).enterPassword(pwd).performDropdown(roletype).saveData();
		// adminuser.enterUsername(uname);
		// adminuser.enterPassword(pwd);
		// adminuser.performDropdown(roletype);
		// adminuser.savedata();
		boolean alertmessage = adminuser.isAlertDisplayed();
		Assert.assertTrue(alertmessage);
		

	}

}
