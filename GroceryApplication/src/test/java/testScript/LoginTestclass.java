package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTestclass extends Baseclass{
	
	
	@Test(priority=1,groups={"Regression"})
	public void verifywhetheruserisabletoenterusingvalidcredentials() throws IOException {
	
	
	String username=ExcelUtility.readStringData(1, 0, "LoginPageU");
	String password=ExcelUtility.readStringData(1, 1, "LoginPageU");
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterusername(username);
	loginpage.enterpassword(password);
	loginpage.clicksignin();
	boolean home=loginpage.isHomePageDisplayed();
	Assert.assertTrue(home);
	
	

}
	@Test(priority=2)
	public void verifyuserabletoenterusinginvalidcredentials() throws IOException
	{
		String username=ExcelUtility.readStringData(2, 0, "LoginPageU");
		String password=ExcelUtility.readStringData(2, 1, "LoginPageU");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		boolean alert1=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert1);
		
	}
	@Test(priority=3)
	public void verifyuserabletoenterusingvalidusernameandinvalidpassword() throws IOException
	{
		String username=ExcelUtility.readStringData(3, 0, "LoginPageU");
		String password=ExcelUtility.readStringData(3, 1, "LoginPageU");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		boolean alert1=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert1);
	}
	
	@Test(priority=4,dataProvider="loginProvider",description="Verify user is able to login by using invalid username and vlid password")
	public void verifyuserabletoenterusinginvalidusernameandvalidpassword(String username,String password) throws IOException
	{
		//String username=ExcelUtility.readStringData(4, 0, "LoginPageU");
		//String password=ExcelUtility.readStringData(4, 1, "LoginPageU");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		boolean alert1=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert1);
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}
}
