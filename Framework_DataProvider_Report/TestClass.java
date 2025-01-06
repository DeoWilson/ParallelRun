package Framework_DataProvider_Report;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass extends BaseClass{
	
	@DataProvider(name = "ExcelRead", parallel = true)
	public String[][] dataprovider() throws IOException{
		String[][] data = ReadingExcel. ReadExcelData();
		return data;
	}
	
	@Test(dataProvider = "ExcelRead")
	public void FormFill(String data[]) {
		driver.get("https://letcode.in/forms");
		WebElement Firstname = findElements("id", "firstname");
		ElementSendKeys(Firstname, data[0]);
		WebElement Lastname = findElements("id", "lasttname");
		ElementSendKeys(Lastname, data[1]);
		
		WebElement email = findElements("id", "email");
		email.clear();
		ElementSendKeys(email,data[2]);
		
		WebElement dropdown = findElements("xpath", "(//div[@class='select']/select)[1]");
		DropdownAccess(dropdown, "India (+91)");
		
		WebElement phone = findElements("id", "Phno");
		ElementSendKeys(phone, data[3]);
		
		WebElement Address01 = findElements("id", "Addl1");
		ElementSendKeys(Address01, data[4]);
		
		WebElement Address02 = findElements("id", "Addl2");
		ElementSendKeys(Address02, data[5]);
		
		WebElement Address03 = findElements("id", "state");
		ElementSendKeys(Address03, data[6]);
		
		WebElement postalCode = findElements("id", "postalcode");
		ElementSendKeys(postalCode, data[7]);
		
		WebElement dropdown2 = findElements("xpath", "(//div[@class='select']/select)[2]");
		DropdownAccess(dropdown2, "India");
		
		WebElement date = findElements("id", "Date");
		ElementSendKeys(postalCode, "18061996");
		
		WebElement Gender = findElements("id", "male");
		ElementClick(Gender);
		
		WebElement TermsAgreement = findElements("xpath", "//input[@type='checkbox']");
		ElementClick(TermsAgreement);
		
		
	}

}
