package Framework_DataProvider_Report;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface BaseInterface {

	public void BrowserSetup(String BrowserName);
	public void BrowserClose();
	public WebElement findElements(String Type, String Value);
	public void ElementClick(WebElement ele);
	public void ElementSendKeys(WebElement ele,String data);
	public void SendKeysWithKeyboard(WebElement ele, String data, Keys key);
	public void DropdownAccess(WebElement ele, String data);
	public void WindowHandling(int num);
	public String CaptureScreenshot(String FileName) throws IOException;
	
	
	
	
}
