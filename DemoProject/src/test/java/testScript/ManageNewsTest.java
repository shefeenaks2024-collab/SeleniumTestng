package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends DemoProjectBase{
	@Test(groups= {"Regression"})
	public void verifywhetheruserabletopublishmessage() throws IOException
	{
		
		
		String username=ExcelUtility.readStringData(1, 0,"LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePAssword(password);
		loginpage.clickonSigninbutton();
		
		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickonmoreinfo();
		managenewspage.clicknew();
		managenewspage.entermessage();
		managenewspage.saveclick();
		boolean newsalert=managenewspage.isAlertmessageDisplayed();
		Assert.assertTrue(newsalert);
	}

}
