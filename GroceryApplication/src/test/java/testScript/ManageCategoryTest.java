package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Baseclass{
	
	@Test(groups= {"Regression"})
	public void verifyuserabletomanagecategorysuccessfully() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPageU");
		String password=ExcelUtility.readStringData(1, 1, "LoginPageU");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(username);
		
		loginpage.enterpassword(password);
		loginpage.clicksignin();
		
		
		ManageCategoryPage category=new ManageCategoryPage(driver);
		category.clickoncategorymoreinfo();
		category.clickonnew();
		category.adddata();
		
		category.addfile();
		category.savedata();
		
	}

}
