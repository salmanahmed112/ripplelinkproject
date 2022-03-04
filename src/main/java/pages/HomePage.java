package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrapper.ProjectSpecificWrapper;

public class HomePage extends ProjectSpecificWrapper{
	
	public HomePage(RemoteWebDriver driver, ExtentTest eachnode) {
	    this.driver = driver;
		this.eachnode = eachnode;
		}
	
	public LoginPage clickLogOut() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(locSelector("class", "MuiAvatar-img"));
		
		click(locSelector("xpath", "//li[text()='Logout']"));
		return new LoginPage(driver, eachnode);
	}
	
	

}