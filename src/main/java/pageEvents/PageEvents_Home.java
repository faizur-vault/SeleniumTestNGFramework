package pageEvents;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageObjects_Home;

public class PageEvents_Home {

	WebDriver driver;
	WebDriverWait wait;

	public PageEvents_Home(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void selectLoginOption() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(PageObjects_Home.Login_MenuOption));
		PageObjects_Home.Login_MenuOption.click();
	}
}
