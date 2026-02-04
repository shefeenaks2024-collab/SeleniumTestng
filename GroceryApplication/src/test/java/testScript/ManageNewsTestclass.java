package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTestclass extends Baseclass{
	@Test(priority=1)
	public void verifuserabletopublishmessage() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPageU");
		String password=ExcelUtility.readStringData(1, 1, "LoginPageU");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		
		ManageNewsPage manage=new ManageNewsPage(driver);
		manage.clickonmoreinfo();
		manage.clickonnews();
		manage.entermessage();
		manage.save();
		boolean msgalert=manage.isAlertmessageDisplayed();
		Assert.assertTrue(msgalert);
	}
	
	
	}
	
	
	
	
	
	


