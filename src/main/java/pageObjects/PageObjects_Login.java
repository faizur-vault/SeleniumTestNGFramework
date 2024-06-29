package pageObjects;

import base.BaseTest;

public class PageObjects_Login extends BaseTest {
	public static String Login_UserName_TextBox = "loginusername";
	public static String login_Password_TextBox = "loginpassword";
	public static String login_Button = "//button[@onclick='logIn()']";
	public static String Close_Button_1 = "//*[@id='logInModal']//button[text()='Close']";
	public static String Close_Button_2 = "//*[@id='logInModal']//button[@class='close']";
	public static String login_Modal_Page = "//*[@class='modal fade' and @id='logInModal']";
}
