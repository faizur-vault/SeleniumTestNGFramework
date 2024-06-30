package pageEvents;

import java.io.IOException;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pageObjects.PageObjects_Login;
import utilities.ElementFetch;
import utilities.WaitForElement;

public class PageEvents_Login extends BaseTest {

	ElementFetch elefet = new ElementFetch();

	public void enterUsername(String uname) throws IOException, InterruptedException {
		waitFor(elefet.getWebElement("ID", PageObjects_Login.Login_UserName_TextBox));
		elefet.getWebElement("ID", PageObjects_Login.Login_UserName_TextBox).sendKeys(uname);
		extentTestLogger.log(Status.PASS, "Entered Username");
		log.info("Entered Username");
	}

	public void enterPassword(String pass) throws IOException {
		elefet.getWebElement("ID", PageObjects_Login.login_Password_TextBox).sendKeys(pass);
		extentTestLogger.log(Status.PASS, "Entered Password");
		log.info("Entered Password");
	}

	public void clickLoginButton() throws IOException {
		elefet.getWebElement("XPATH", PageObjects_Login.login_Button).click();
		extentTestLogger.log(Status.PASS, "Clicked on Login button");
		log.info("Clicked on Login Button");
	}

	public void waitFor(WebElement element) throws InterruptedException {
		WaitForElement.inTime(element.isDisplayed(), 5);
		WaitForElement.inTime(element.isEnabled(), 5);
		log.info("Waiting for the element");
	}

}
