package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;
import utilities.Waitutility;

public class Baseclass {

	public WebDriver driver;

	public FileInputStream file;
	public Properties property;

	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")
	public void browserInitialization(String browser) throws Exception {
		try {
			property = new Properties();
			file = new FileInputStream(Constant.CONFIGFILE);
			property.load(file);
		} catch (Exception e) {
			System.out.println(e);
		}

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else
			throw new Exception("Invalid");

		// driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(property.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Waitutility.IMPLICITWAIT));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility scrshot = new ScreenshotUtility();
			scrshot.getScreenshot(driver, iTestResult.getName());
		}

		driver.quit();
	}
}
