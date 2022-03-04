package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import pages.LoginPage;
import wrapper.ProjectSpecificWrapper;

public class TC001_LoginLogout extends ProjectSpecificWrapper{


	@BeforeTest
	public void setData() {
		testCaseName = "login";
		testCaseDesc ="xyz";
		author="syed";
		category="xyz";
		device="windows";
		excelFileName = "TC001";
	}


	@Test(dataProvider = "fetchData")
	public void loginLogOut(String uname, String pwd) {	
		new LoginPage(driver, eachnode)
		.enterUserName(uname)
		.enterPassword(pwd)
		.clicklogin() 
		.clickLogOut();

	}
}
