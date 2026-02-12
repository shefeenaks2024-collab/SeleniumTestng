package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Baseclass {

	public HomePage home;
	public ManageContactPage managecontact;

	@Test(groups = { "Regression" }, description = "Verify user able to update contact information successfully")
	public void verifyusercanupdatecontactinformation() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPageU");
		String password = ExcelUtility.readStringData(1, 1, "LoginPageU");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);

		// loginpage.enterpassword(password);
		loginpage.clickSignin();

		String phone = ExcelUtility.readIntegerData(1, 0, "ManageContact");
		String email = ExcelUtility.readStringData(1, 1, "ManageContact");
		// ManageContactPage manage = new ManageContactPage(driver);
		managecontact = home.clickonmanagecontact();
		managecontact.clickOnEdit().enterPhoneData(phone).enterMail(email).updateData();
		// manage.enterphonedata(phone);
		// manage.entermail(email);
		// manage.updatedata();
		boolean contactalert = managecontact.isAlertDisplayed();
		Assert.assertTrue(contactalert);
		
	}

}
