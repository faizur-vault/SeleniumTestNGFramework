package pageEvents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageObjects_Login;

public class PageEvents_Login {
	
	WebDriver driver;
	WebDriverWait wait;
	public PageEvents_Login(WebDriver driver, WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
	}
	
	public void enterUsername(String uname) throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(PageObjects_Login.Login_UserName_TextBox));
		PageObjects_Login.Login_UserName_TextBox.sendKeys(uname);
	}

	public void enterPassword(String pass) throws IOException {
		PageObjects_Login.login_Password_TextBox.sendKeys(pass);
	}

	public void clickLoginButton() throws IOException {
		PageObjects_Login.login_Button.click();
	}

}