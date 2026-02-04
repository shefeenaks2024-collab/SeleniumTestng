package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Baseclass {
	
	@Test(groups= {"Regression"})
	public void verifyusercanupdatecontactinformation() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPageU");
		String password=ExcelUtility.readStringData(1, 1, "LoginPageU");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(username);
		
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		
		
		String phone=ExcelUtility.readIntegerData(1, 0, "ManageContact");
		String email=ExcelUtility.readStringData(1, 1, "ManageContact");
		ManageContactPage manage=new ManageContactPage(driver);
		manage.clickonmanagecontact();
		manage.clickonedit();
		manage.enterphonedata(phone);
		manage.entermail(email);
		manage.updatedata();
		boolean contactalert=manage.isAlertDisplayed();
		Assert.assertTrue(contactalert);
	}
	
	
	
	

}
