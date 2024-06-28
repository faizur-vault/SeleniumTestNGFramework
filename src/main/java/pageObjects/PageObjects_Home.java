package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseTest;

public class PageObjects_Home extends BaseTest {
	public static WebElement Home_MenuOption = driver
			.findElement(By.xpath("//a[@class='nav-link' and text()='Home ']"));

	@FindBy(xpath = "//a[@class='nav-link' and text()='Contact']")
	public static WebElement Contact_MenuOption;

	@FindBy(xpath = "//a[@class='nav-link' and text()='About us']")
	public static WebElement AboutUs_MenuOption;

	@FindBy(id = "cartur")
	public static WebElement Cart_MenuOption;

	public static WebElement Login_MenuOption = driver.findElement(By.id("login2"));

	@FindBy(id = "signin2")
	public static WebElement SignIn_MenuOption;
}
