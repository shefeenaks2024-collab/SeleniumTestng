package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Baseclass{
	@Test(groups= {"Regression"},retryAnalyzer=retry.Retry.class)
	public void verifyusercancreateadminusers() throws IOException
	{
	String username=ExcelUtility.readStringData(1, 0, "LoginPageU");
	String password=ExcelUtility.readStringData(1, 1, "LoginPageU");
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterusername(username);
	loginpage.enterpassword(password);
	loginpage.clicksignin();
	
	
	
	String uname=ExcelUtility.readStringData(1, 0, "AdminUsers");
	String pwd=ExcelUtility.readStringData(1, 1, "AdminUsers");
	AdminUsersPage adminuser=new AdminUsersPage(driver);
	adminuser.clickonadminusers();
	adminuser.clickonNew();
	adminuser.enteruname(uname);
	adminuser.enterpwd(pwd);
	adminuser.performdropdown();
	adminuser.savedata();
	boolean alertmessage=adminuser.isAlertDisplayed();
	Assert.assertTrue(alertmessage);
	
	}

}


