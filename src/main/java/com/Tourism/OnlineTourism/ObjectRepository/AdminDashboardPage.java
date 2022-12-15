package com.Tourism.OnlineTourism.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
	@FindBy(xpath="//span[.=' Tour Packages']")
	private WebElement tourPackages;
	@FindBy(xpath="//a[.='Create']")
	private WebElement createTour;
	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}
	/**
	 * this method is used to mouse over tourPackages
	 * @return
	 */
	
	public WebElement mousrOverTourPackages()
	{
		return tourPackages;
	}
	/**
	 * this method is used to click on Create
	 */
	public void clickOnCreate()
	{
		createTour.click();
		
	}

}
