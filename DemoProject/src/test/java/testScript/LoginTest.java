package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends DemoProjectBase {

	
	@Test(priority=1,groups= {"Regression"},retryAnalyzer=retry.Retry.class)
	public void verifytheuserisabletologinthroghvalidcredentials() throws IOException
	{
		//String username="admin";
		//String password="admin";
		String username=ExcelUtility.readStringData(1, 0,"LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePAssword(password);
		loginpage.clickonSigninbutton();
		
		boolean homepage=loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepage);
		
	}
	
	@Test(priority=2)
	public void verifytheuserisabletologinthroghinvalidusernameandpwd() throws IOException
	{
		//String username="hrrrr";
		//String password="iiuuuu";
		String username=ExcelUtility.readStringData(2, 0, "LoginPage");
		String password=ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePAssword(password);
		loginpage.clickonSigninbutton();
		boolean alert1=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert1);
	
	}
	@Test(priority=3)
	public void verifytheuserisabletologinthroghinvalidusernameandvalidpwd() throws IOException
	{
		//String username="hrrrr";
		//String password="admin";
		String username=ExcelUtility.readStringData(3, 0, "LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePAssword(password);
		loginpage.clickonSigninbutton();
		boolean alert2=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert2);
	
		
	}
	@Test(priority=4)
	public void verifytheuserisabletologinthroghvalidusernameandinvalidpwd() throws IOException
	{
		//String username="admin";
		//String password="iiuuuu";
		String username=ExcelUtility.readStringData(4, 0, "LoginPage");
		String password=ExcelUtility.readStringData(4, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePAssword(password);
		loginpage.clickonSigninbutton();
		boolean alert3=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert3);
	
	}
}
