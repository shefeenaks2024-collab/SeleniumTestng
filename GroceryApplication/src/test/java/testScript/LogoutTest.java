package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Baseclass {
	
	@Test
	public void verifyuserabletologout() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPageU");
		String password=ExcelUtility.readStringData(1, 1, "LoginPageU");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		
		LogoutPage logout=new LogoutPage(driver);
		logout.clickonlogout();

}
}
