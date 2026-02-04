package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {

		TakesScreenshot scrShot = (TakesScreenshot) driver;// TakesScreenshot Interface used to take screenshot ,//convert webdriver to screenshot mode
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//to capture the screenshot and store it as a temporary file

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//create date and time

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory
		if (!f1.exists()) {

		f1.mkdirs();//create a folder if it doesnt exist
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png";//decide final screenshot path
		
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);//copy method used to move from one location to another location 
		}

}
