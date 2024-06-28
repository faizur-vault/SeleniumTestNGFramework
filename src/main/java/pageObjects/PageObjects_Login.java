package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseTest;

public class PageObjects_Login extends BaseTest {
	public static WebElement Login_UserName_TextBox = driver.findElement(By.id("loginusername"));
	public static WebElement login_Password_TextBox = driver.findElement(By.id("loginpassword"));
	public static WebElement login_Button = driver.findElement(By.xpath("//button[@onclick='logIn()']"));

	@FindBy(id = "nameofuser")
	public static WebElement loggedin_Username;

	@FindBy(xpath = "//*[@id='logInModal']//button[text()='Close']")
	public static WebElement Close_Button_1;

	@FindBy(xpath = "//*[@id='logInModal']//button[@class='close']")
	public static WebElement Close_Button_2;

	@FindBy(xpath = "//*[@class='modal fade' and @id='logInModal']")
	public static WebElement login_Modal_Page;
}
