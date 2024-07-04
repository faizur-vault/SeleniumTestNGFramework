package pageEvents;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import com.aventstack.extentreports.Status;
import base.BaseTest;
import pageObjects.PageObjects_Login;
import utilities.Constants;
import utilities.ElementFetch;

public class PageEvents_Login extends BaseTest {

	ElementFetch elefet = new ElementFetch();

	public void enterUsername(String uname) throws IOException, InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(elefet.getWebElement("ID", PageObjects_Login.Login_UserName_TextBox)));
		elefet.getWebElement("ID", PageObjects_Login.Login_UserName_TextBox).sendKeys(uname);
		extentTestLogger.log(Status.PASS, "Entered Username");
		log.info("Entered Username");
	}

	public void enterPassword(String pass) throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(elefet.getWebElement("ID", PageObjects_Login.login_Password_TextBox)));
		elefet.getWebElement("ID", PageObjects_Login.login_Password_TextBox).sendKeys(pass);
		extentTestLogger.log(Status.PASS, "Entered Password");
		log.info("Entered Password");
	}

	public void clickLoginButton() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(elefet.getWebElement("XPATH", PageObjects_Login.login_Button)));
		elefet.getWebElement("XPATH", PageObjects_Login.login_Button).click();
		if(elefet.getWebElement("XPATH", PageObjects_Login.login_Button).isDisplayed())
		{
			elefet.getWebElement("XPATH", PageObjects_Login.login_Button).click();
		}
		extentTestLogger.log(Status.PASS, "Clicked on Login button");
		log.info("Clicked on Login Button");
	}
	
	public void verifyWrongPasswordAlert()
	{
		wait.until(ExpectedConditions.alertIsPresent());
		assertTrue(Constants.wrongPassword_AlertText.equalsIgnoreCase(driver.switchTo().alert().getText()));
		extentTestLogger.log(Status.PASS, "Verified Wrong password alert text");
		log.info("Verified Wrong password alert text");
	}
	
	public void verifyUserNotExistAlert()
	{
		wait.until(ExpectedConditions.alertIsPresent());
		assertTrue(Constants.userNotExist_AlertText.equalsIgnoreCase(driver.switchTo().alert().getText()));
		extentTestLogger.log(Status.PASS, "Verified User Not Exist alert text");
		log.info("Verified User Not Exist alert text");
	}
	
	public void clickCloseButton() throws IOException, InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(elefet.getWebElement("XPATH", PageObjects_Login.Close_Button_1_XPATH)));
		Thread.sleep(Duration.ofSeconds(2));
		elefet.getWebElement("XPATH", PageObjects_Login.Close_Button_1_XPATH).click();
		extentTestLogger.log(Status.PASS, "Clicked on \"Close\" button");
		log.info("Clicked on \"Close\" button");
	}
	
	public void clickXButton() throws IOException, InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(elefet.getWebElement("XPATH", PageObjects_Login.Close_Button_2_XPATH)));
		Thread.sleep(Duration.ofSeconds(2));
		elefet.getWebElement("XPATH", PageObjects_Login.Close_Button_2_XPATH).click();
		extentTestLogger.log(Status.PASS, "Clicked on \"X\" button");
		log.info("Clicked on \"X\" button");
	}
	
	public void verifyLoginModelClosed()
	{
		wait.until(ExpectedConditions.invisibilityOf(elefet.getWebElement("CSS", PageObjects_Login.login_Modal_Page_CSS)));
		assertFalse(elefet.getWebElement("CSS", PageObjects_Login.login_Modal_Page_CSS).isDisplayed());
		extentTestLogger.log(Status.PASS, "Verified Login modal is closed");
		log.info("Verified Login modal is closed");
	}

}
