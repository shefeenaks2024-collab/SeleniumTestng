package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class Fileuploadutility {
	
	
	public void fileUploadUsingSendkeys(WebElement elementname,String path)
	{
		elementname.sendKeys(path);
	}
	public void fileUploadUsingRobotclass(WebElement elementname,String path) throws AWTException
	{
		StringSelection str=new StringSelection(path);//this is used to data transfer
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);//pass object of String Selection and null
		Robot r=new Robot();
		r.delay(2500);
		r.keyPress(KeyEvent.VK_CONTROL);//VK==virtual Key.Keyevent is a class in Robot.
		r.keyPress(KeyEvent.VK_V);//Perform Control+V
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
