package module_LoginPage; 

import java.io.IOException;
import org.testng.annotations.Test;
import base.BaseTest;
import base.DataManagement;
import pageEvents.PageEvents_Home;
import pageEvents.PageEvents_Login;

public class TS_001_ValidateLoginCredentials extends BaseTest {
	PageEvents_Home homePageEvents = new PageEvents_Home();
	PageEvents_Login loginPageEvents = new PageEvents_Login();

	@Test(groups = { "smoke" }, dataProvider = "TestData_Login", dataProviderClass = DataManagement.class)
	public void TC_001_Login_ValidCredentials(String uname, String pwd) throws IOException, InterruptedException {
		extentTestLogger = extentReports
				.createTest("TC_001_Login_ValidCredentials - " + driver.getClass().getSimpleName())
				.assignDevice(driver.getClass().getSimpleName()).assignCategory("Login_Module");
		homePageEvents.selectLoginOption();
		loginPageEvents.enterUsername(uname);
		loginPageEvents.enterPassword(pwd);
		loginPageEvents.clickLoginButton();
		homePageEvents.verifyUserName();
	} 

	@Test(groups = { "regression" }, dataProvider = "TestData_Login", dataProviderClass = DataManagement.class)
	public void TC_002_Login_WrongPassword(String uname, String pwd) throws IOException, InterruptedException {
		extentTestLogger = extentReports.createTest("TC_002_Login_WrongPassword - " + driver.getClass().getSimpleName())
				.assignDevice(driver.getClass().getSimpleName()).assignCategory("Login_Module");
		homePageEvents.selectLoginOption();
		loginPageEvents.enterUsername(uname);
		loginPageEvents.enterPassword(pwd);
		loginPageEvents.clickLoginButton();
		loginPageEvents.verifyWrongPasswordAlert();
	}

	@Test(groups = { "integration" }, dataProvider = "TestData_Login", dataProviderClass = DataManagement.class)
	public void TC_003_Login_InvalidUsername(String uname, String pwd) throws IOException, InterruptedException {
		extentTestLogger = extentReports
				.createTest("TC_003_Login_InvalidUsername - " + driver.getClass().getSimpleName())
				.assignDevice(driver.getClass().getSimpleName()).assignCategory("Login_Module");
		homePageEvents.selectLoginOption();
		loginPageEvents.enterUsername(uname);
		loginPageEvents.enterPassword(pwd);
		loginPageEvents.clickLoginButton();
		loginPageEvents.verifyUserNotExistAlert();
	}
}
