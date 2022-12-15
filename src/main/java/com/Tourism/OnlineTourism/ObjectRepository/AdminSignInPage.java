package com.Tourism.OnlineTourism.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSignInPage {

	@FindBy(xpath="//input[@name='username']")
private WebElement usernameTextBox;
	@FindBy(xpath="//input[@name='password']")
	private WebElement pwdTextBox;
	@FindBy(xpath="//input[@name='login']")
	private WebElement signInButton;
public AdminSignInPage(WebDriver driver) {
	PageFactory.initElements(driver,this );
}

	
/**
 * this method is used to signIn as Admin
 * @param username
 * @param password
 */
public void adminLogin(String username,String password)
{
	usernameTextBox.sendKeys(username);
	pwdTextBox.sendKeys(password);
	signInButton.click();
	
	}

}
