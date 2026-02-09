package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Baseclass {

	public HomePage home;
	public ManageFooterPage managefooter;

	@Test(groups = { "Regression" }, description = "Verify user able to update footer text  successfully")
	public void verifyuserabletomanagefoootertext() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPageU");
		String password = ExcelUtility.readStringData(1, 1, "LoginPageU");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);

		// loginpage.enterpassword(password);
		home = loginpage.clickSignin();
		boolean home1 = loginpage.isHomePageDisplayed();
		Assert.assertTrue(home1, Constant.LOGIN_VALID_CREDENTIALS);

		String address = ExcelUtility.readStringData(1, 0, "ManageFooter");
		String mailid = ExcelUtility.readStringData(1, 1, "ManageFooter");
		String phone_no = ExcelUtility.readStringData(1, 1, "ManageFooter");

		// ManageFooterPage footerpage = new ManageFooterPage(driver);
		managefooter = home.clickonmoreinfofooter();
		managefooter.clickOnEditIcon().editAddress(address).editEmail(mailid).editPhone(phone_no).clickonUpdatebtn();
		// footerpage.editaddress(address);
		// footerpage.editemail(mailid);
		// footerpage.editphone(phone_no);
		// footerpage.clickonupdatebtn();
		boolean alert2 = managefooter.isAlertDisplayed();
		Assert.assertTrue(alert2);

	}

}
