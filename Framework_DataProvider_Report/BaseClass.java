package Framework_DataProvider_Report;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass implements BaseInterface {
	protected RemoteWebDriver driver = null;
	WebElement ele;
	WebDriverWait wait;

	@BeforeMethod
	@Parameters({"Browser"})
	@Override
	public void BrowserSetup(String BrowserName) {
		System.out.println(BrowserName);
         switch(BrowserName.toLowerCase()) {
         case "chrome":
        	 driver = new ChromeDriver();
        	 driver.manage().window().maximize();
        	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
        	 break;
         case "edge":
        	 driver = new EdgeDriver();
        	 driver.manage().window().maximize();
        	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
        	 break;
         default:
        	 System.out.println("Browser Name is InValid.");
        	 break;
         }
		
	}
    
	@AfterMethod
	@Override
	public void BrowserClose() {
		//driver.quit();
		
	}

	@Override
	public WebElement findElements(String Type, String Value) {
		switch (Type.toLowerCase()) {
		case "id":
			ele = driver.findElement(By.id(Value));
			break;
		case "name":
			ele = driver.findElement(By.name(Value));
			break;
		case "xpath":
			ele = driver.findElement(By.xpath(Value));
			break;
		case "classname":
			ele = driver.findElement(By.className(Value));
			break;
		default:
			System.out.println("Invalid Type Name");	
			break;
		}
			
		return ele;
	}

	@Override
	public void ElementClick(WebElement ele) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ele));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		
	}

	@Override
	public void ElementSendKeys(WebElement ele, String data) {
		ele.sendKeys(data);
		
	}

	@Override
	public void SendKeysWithKeyboard(WebElement ele, String data, Keys key) {
		ele.sendKeys(data,key);
		
	}

	@Override
	public void DropdownAccess(WebElement ele, String data) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(data);
		
	}

	@Override
	public void WindowHandling(int num) {
		Set<String> setVar =  driver.getWindowHandles();
		List<String> listVar = new ArrayList<String>(setVar);
		String ChildWin = listVar.get(num);
		driver.switchTo().window(ChildWin);		
	}

	@Override
	public String CaptureScreenshot(String FileName) throws IOException {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/"+FileName+".png");
		org.openqa.selenium.io.FileHandler.copy(src, dest);
		String Path = dest.getAbsolutePath();
		return Path;
		
		
	}

}
