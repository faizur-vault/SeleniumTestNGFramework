package pageEvents;

import java.io.IOException;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pageObjects.PageObjects_Home;
import utilities.ElementFetch;
import utilities.WaitForElement;

public class PageEvents_Home extends BaseTest {

	ElementFetch eleFet = new ElementFetch();

	public void selectLoginOption() throws IOException, InterruptedException {
		WaitForElement.inTime(eleFet.getWebElement("ID", PageObjects_Home.Login_MenuOption_ID).isEnabled(), 5);
		eleFet.getWebElement("ID", PageObjects_Home.Login_MenuOption_ID).click();
		extentTestLogger.log(Status.PASS, "Clicked on Login Option");
	}

}
