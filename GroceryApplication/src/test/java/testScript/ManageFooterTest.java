package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Baseclass {
	
	
	@Test(groups= {"Regression"})
	public void verifyuserabletomanagefoootertext() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPageU");
		String password=ExcelUtility.readStringData(1, 1, "LoginPageU");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(username);
		
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		
		String address=ExcelUtility.readStringData(1, 0, "ManageFooter");
		String mailid=ExcelUtility.readStringData(1, 1, "ManageFooter");
		String phone_no=ExcelUtility.readStringData(1, 1, "ManageFooter");
		
		ManageFooterPage footerpage=new ManageFooterPage(driver);
		footerpage.clickonmoreinfofooter();
		footerpage.clickonediticon();
		footerpage.editaddress(address);
		footerpage.editemail(mailid);
		footerpage.editphone(phone_no);
		footerpage.clickonupdatebtn();
		boolean alert2=footerpage.isAlertDisplayed();
		Assert.assertTrue(alert2);
		
	}

}
