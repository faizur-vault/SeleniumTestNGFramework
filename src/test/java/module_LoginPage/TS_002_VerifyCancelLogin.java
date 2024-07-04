package module_LoginPage;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.PageEvents_Home;
import pageEvents.PageEvents_Login;

public class TS_002_VerifyCancelLogin extends BaseTest {
	PageEvents_Home homePageEvents = new PageEvents_Home();
	PageEvents_Login loginPageEvents = new PageEvents_Login();

	@Test(groups = "smoke")
	public void TC_004_CancelLogin_Close() throws IOException, InterruptedException {
		extentTestLogger = extentReports.createTest("TC_004_CancelLogin_1 - " + driver.getClass().getSimpleName())
				.assignDevice(driver.getClass().getSimpleName()).assignCategory("Login_Module");
		homePageEvents.selectLoginOption();
		loginPageEvents.clickCloseButton();
		loginPageEvents.verifyLoginModelClosed();
	}

	@Test(groups = { "regression", "integration" } )
	public void TC_005_CancelLogin_X() throws IOException, InterruptedException {
		extentTestLogger = extentReports.createTest("TC_005_CancelLogin_2 - " + driver.getClass().getSimpleName())
				.assignDevice(driver.getClass().getSimpleName()).assignCategory("Login_Module");
		homePageEvents.selectLoginOption();
		loginPageEvents.clickXButton();
		loginPageEvents.verifyLoginModelClosed();
	}
}
