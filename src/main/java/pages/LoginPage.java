package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrapper.ProjectSpecificWrapper;

public class LoginPage extends ProjectSpecificWrapper{

	public LoginPage(RemoteWebDriver driver, ExtentTest eachnode) {
    this.driver = driver;
	this.eachnode = eachnode;
	}
	
	public LoginPage enterUserName(String uname) {
		clearAndType(locSelector("name", "email"), uname);
		return this;
	}
	
	public LoginPage enterPassword(String pwd) {
		clearAndType(locSelector("name", "password"), pwd);
		return this;

	}
public HomePage clicklogin(  ) {
		click(locSelector("xpath", "//span[text()='Login']"));
		return new HomePage(driver,eachnode);	
	
	

}
	}
