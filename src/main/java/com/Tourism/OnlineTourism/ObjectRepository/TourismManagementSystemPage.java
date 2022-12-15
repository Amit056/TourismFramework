package com.Tourism.OnlineTourism.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TourismManagementSystemPage {
	WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Enter your Email']")
private	WebElement userNameTextBox;
	@FindBy(xpath="//input[@name='password' and @id='password']")
	private	WebElement pwdTextBox;
@FindBy(name="signin")
private WebElement signInButton;
	@FindBy(partialLinkText = "My Profile")
	private	WebElement myProfile;
	@FindBy(xpath="//b[.='Name']/following-sibling::*")
		private	WebElement changePwdTextBox;
	@FindBy(xpath="//b[.='Mobile Number']/following-sibling::*")
	private	WebElement changePhoneNumTextBox;
	@FindBy(xpath="//button[.='Updtae']")
	private	WebElement updateButton;
	@FindBy(partialLinkText ="/ Logout")
	private WebElement logoutButton;
	@FindBy(xpath="//a[.='My Tour History']")
	private	WebElement clickOnMyTourHistoryTestModule;
	@FindBy(xpath="//h3[.='My Tour History']/../form/table/tbody/tr[22]/td[2]")
	private	WebElement myTourHistoryTable;

	public TourismManagementSystemPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	/**
	 * this method is used to login as user
	 * @param unName
	 * @param pwd
	 */
	public void loginUnPwd(String unName,String pwd)
	{
		userNameTextBox.sendKeys(unName);
		pwdTextBox.sendKeys(pwd);
		signInButton.click();
		}
	/**
	 * this method is used to click myProfile
	 */
	public void myProfile()
	{
		myProfile.click();
	}
/**
 *  this method is used to change username
 * 
 * @param changeUn
 */
	public void changeUn(String changeUn)
	{
		changePwdTextBox.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		changePwdTextBox.sendKeys(changeUn);
		}
	/**
	 * this method is used to changePhoneNumTextBox
	 * @param changePhNum
	 */
	public void changePhoneNumTextBox(String changePhNum)
	{
		changePhoneNumTextBox.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		changePhoneNumTextBox.sendKeys(changePhNum);
		}
	/**
	 * this method is used to click on updateButton
	 */
	public void updateButton()
	{
		updateButton.click();
	}
	/**
	 * this method is used to click on logout button
	 */
	public void logoutButton()
	{
		logoutButton.click();
		}
	/**
	 * this method is used to click on MyTourHistoryTestModule
	 */
	public void clickOnMyTourHistoryTestModule()
	{
		clickOnMyTourHistoryTestModule.click();
	}
	/**
	 *  this method is used to click myTourHistoryTable
	 * @return
	 */
	public String myTourHistoryTable()
	{
		String data = myTourHistoryTable.getText();
		return data;
	}

}
