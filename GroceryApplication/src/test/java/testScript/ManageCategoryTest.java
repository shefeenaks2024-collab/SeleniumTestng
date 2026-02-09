package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Baseclass {

	public HomePage home;
	public ManageCategoryPage managecategory;

	@Test(groups = { "Regression" }, description = "Verify user able to enter category information  successfully")
	public void verifyuserabletomanagecategorysuccessfully() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPageU");
		String password = ExcelUtility.readStringData(1, 1, "LoginPageU");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);

		// loginpage.enterpassword(password);
		home = loginpage.clickSignin();

		// ManageCategoryPage category = new ManageCategoryPage(driver);

		managecategory = home.clickoncategorymoreinfo();

		managecategory.clickOnNew().addData().addFile().saveData();
		// category.adddata();

		// category.addfile();
		// category.savedata();
		boolean alertmsg = managecategory.isAlertDisplayed();
		Assert.assertTrue(alertmsg);

	}

}
