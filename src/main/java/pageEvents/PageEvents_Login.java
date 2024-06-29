package pageEvents;

import java.io.IOException;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pageObjects.PageObjects_Login;
import utilities.ElementFetch;
import utilities.WaitForElement;

public class PageEvents_Login extends BaseTest {

	ElementFetch elefet = new ElementFetch();

	public void enterUsername(String uname) throws IOException, InterruptedException {
		WaitForElement.inTime(elefet.getWebElement("ID", PageObjects_Login.Login_UserName_TextBox).isEnabled(), 5);
		elefet.getWebElement("ID", PageObjects_Login.Login_UserName_TextBox).sendKeys(uname);
		extentTestLogger.log(Status.PASS, "Entered Username");
	}

	public void enterPassword(String pass) throws IOException {
		elefet.getWebElement("ID", PageObjects_Login.login_Password_TextBox).sendKeys(pass);
		extentTestLogger.log(Status.PASS, "Entered Password");
	}

	public void clickLoginButton() throws IOException {
		elefet.getWebElement("XPATH", PageObjects_Login.login_Button).click();
		extentTestLogger.log(Status.PASS, "Clicked on Login button");
	}

}
