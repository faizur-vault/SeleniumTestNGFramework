package pageObjects;

import base.BaseTest;

public class PageObjects_Login extends BaseTest {
	public static String Login_UserName_TextBox = "loginusername";
	public static String login_Password_TextBox = "loginpassword";
	public static String login_Button = "//button[@class='btn btn-primary' and text()='Log in']";
	public static String Close_Button_1_XPATH = "//*[@id='logInModal']//button[text()='Close']";
	public static String Close_Button_2_XPATH = "//*[@id='logInModal']//button[@class='close']";
	public static String login_Modal_Page_CSS = "#logInModal";
}
