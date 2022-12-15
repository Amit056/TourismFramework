package com.Tourism.OnlineTourism.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PackageListPage {
	WebDriver driver;
	String partialXpath="//div[@id='ui-datepicker-div']/table/child::tbody//a[.='%s']";
	@FindBy(xpath="//li/a[.='Tour Packages']")
	private WebElement tourPackage;
	@FindBy(xpath="//h3[.='Package List']/../child::*/div[3]/a")
	private List<WebElement> details;
	@FindBy(xpath="//h1[.=' TMS -Package Details']")
	private WebElement packageDetails;
	@FindBy(xpath="//input[@name='comment']")
	private WebElement writeOnComments;
@FindBy(xpath="//button[@type='submit' and  @name='submit2']")
private WebElement clickOnBook;
@FindBy(xpath="//input[@placeholder='dd-mm-yyyy' and @name='fromdate']")
private WebElement tourStartDate;
@FindBy(xpath="//input[@placeholder='dd-mm-yyyy' and @name='todate']")
private WebElement tourEndDate;
@FindBy(xpath="//span[.='Management System']")
private WebElement visibilityOfManagementSystem;
	
	public PackageListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this );
		}
	/**
	 *  this method is used to click on PackageListPageModule
	 */
	public void PackageListPageModule()
	{
		tourPackage.click();
	}
	/**
	 * this method is used to click on getDetails
	 */
	public void getDetails()
	{
		List<WebElement> packages = details;
		
		int count = packages.size();
			System.out.println(count);
			for(int i=0;i<count;i++)
			{
			 packages.get(0).click();
				break;
				
			}
		
	}
	/**
	 * this method is used to getPackageDetails
	 * @return
	 */
	public WebElement getPackageDetails()
	{
		return packageDetails;
	}
	/**
	 * this method is used to writeOnComments
	 */
	public void writeOnComments(String comments)
	{
		writeOnComments.sendKeys(comments);
	}
	/**
	 * this method is used to clickOnBook
	 */
	public void clickOnBook() {
		clickOnBook.click();
	}
	/**
	 * this method is used to click tourStartDate
	 */
	public void tourStartDate()
	{tourStartDate.click();}
	/**
	 * this method is used to click tourEndDate
	 */
	public void tourEndDate()
	{
		tourEndDate.click();
		}
	/**
	 * this method is used to convert StringToWebElement
	 * @param replaceDeta
	 * @return
	 */
	public WebElement StringToWebElement(String replaceDeta)
	{
		String xpath = String.format(partialXpath,replaceDeta );
		return driver.findElement(By.xpath(xpath));
	}
	/**
	 * this method is used to wait till visibilityOfManagementSystem
	 * @return
	 */
	public WebElement visibilityOfManagementSystem()
	{
		return visibilityOfManagementSystem;
	}
}
