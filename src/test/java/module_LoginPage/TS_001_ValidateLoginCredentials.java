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

	@Test(dataProvider = "TestData_Login", dataProviderClass = DataManagement.class)
	public void TC_001_Login_ValidCredentials(String uname, String pwd) throws IOException, InterruptedException {
		extentTestLogger = extentReports.createTest(
				"TC_001_Login_ValidCredentials " + driver.getClass().getSimpleName(),
				"Testing Login with Valid Usernmae and Valid Password");
		homePageEvents.selectLoginOption();
		loginPageEvents.enterUsername(uname);
		loginPageEvents.enterPassword(pwd);
		loginPageEvents.clickLoginButton();
	}
}
