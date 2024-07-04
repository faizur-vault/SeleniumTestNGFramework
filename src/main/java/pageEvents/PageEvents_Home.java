package pageEvents;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import com.aventstack.extentreports.Status;
import base.BaseTest;
import pageObjects.PageObjects_Home;
import pageObjects.PageObjects_Login;
import utilities.ElementFetch;

public class PageEvents_Home extends BaseTest {

	ElementFetch eleFet = new ElementFetch();

	public void selectLoginOption() throws IOException, InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(eleFet.getWebElement("ID", PageObjects_Home.Login_MenuOption_ID)));
		eleFet.getWebElement("ID", PageObjects_Home.Login_MenuOption_ID).click();
		wait.until(ExpectedConditions.visibilityOf(eleFet.getWebElement("CSS", PageObjects_Login.login_Modal_Page_CSS)));
		log.info("Clicked on Login Option and Login modal is displayed");
		extentTestLogger.log(Status.PASS, "Clicked on Login Option and Login modal is displayed");
	}
	
	public void verifyUserName() throws IOException, InterruptedException {
		Thread.sleep(Duration.ofSeconds(5)); //to handle the stale element issue
		wait.until(ExpectedConditions.visibilityOf(eleFet.getWebElement("CSS", PageObjects_Home.Name_Of_User_XPATH)));
		assertTrue(eleFet.getWebElement("CSS", PageObjects_Home.Name_Of_User_XPATH).isDisplayed());
		extentTestLogger.log(Status.PASS, "Username is present on homepage");
		log.info("Verified the username on Homepage");
	}

}
