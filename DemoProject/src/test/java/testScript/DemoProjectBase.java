package testScript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.Waitutility;

public class DemoProjectBase {
	
	
	public WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("Browser")
	public void browserinitialisation(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("Invalid");
		}
		
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Waitutility.IMPLICITWAIT));
		driver.manage().window().maximize();
	}

	
	@AfterMethod(alwaysRun=true)
	public void browserclose()
	{
		driver.quit();	
		}
}
