package wrapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.ReadExcel;

public class ProjectSpecificWrapper extends GenericWrapper{

	public String excelFileName;
	public static Properties prop;

	@BeforeSuite
	public void loadObject() {
		
	}


	@BeforeMethod
	public void login() { // 123
		eachnode = test.createNode("Test Data: ");
		invokeBrowser("chrome", "http://dev.new.ripplekonnect.com/");
	}

	//	@AfterMethod
	public void closeApp() {
		close();
	}

	@DataProvider(name="fetchData")
	public String[][] getData() throws IOException {
		ReadExcel re = new ReadExcel();
		String[][] data = re.readExcel(excelFileName);
		return data;
	}

}
