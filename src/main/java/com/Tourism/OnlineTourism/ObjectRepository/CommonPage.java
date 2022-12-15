package com.Tourism.OnlineTourism.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
@FindBy(partialLinkText = "Sign In")
 private WebElement signInButton;
@FindBy(partialLinkText="My Profile")
private WebElement myProfileModule;
@FindBy(xpath="//a[.='Admin Login']")
private WebElement adminLogin;

public CommonPage(WebDriver driver)
{
	PageFactory.initElements(driver,this );
	}
/**
 * this method is used to clic on signIn button
 */
public void ClickOnSignInButton()
{
	signInButton.click();
	}
/**
 * this method is used to click on myProfileModule
 */
public void myProfileModule()
{
	myProfileModule.click();
	}
/**
 * this method is used to clickOnAdminLogin
 */
public void clickOnAdminLogin()
{
	adminLogin.click();
}


}
