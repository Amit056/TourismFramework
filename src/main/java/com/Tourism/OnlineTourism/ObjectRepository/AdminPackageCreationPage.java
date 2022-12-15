package com.Tourism.OnlineTourism.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPackageCreationPage {
@FindBy(xpath="//input[@id='packagename']")
private WebElement createPackageTextBox;
@FindBy(xpath="//input[@id='packagetype']")
private WebElement createPackageType;

@FindBy(xpath="//input[@id='packagelocation']")
private WebElement createPackageLocation;
@FindBy(xpath="//input[@id='packageprice']")
private WebElement createPackagePrice;
@FindBy(xpath="//input[@id='packagefeatures']")
private WebElement createPackagefeatures;
@FindBy(xpath="//textarea[@id='packagedetails']")
private WebElement createPackageDetails;
@FindBy(xpath="//div[@class='form-group' ]//input[@id='packageimage']")
private WebElement uploadPackageImage;
public AdminPackageCreationPage(WebDriver driver) {
	PageFactory.initElements(driver,this );
}
/**
 * this method is used to generate a new tour
 * @param packageName
 * @param packageType
 * @param packageLocation
 * @param packagePrice
 * @param packageFeature
 * @param packageDeatail
 */
public void createTourPackage(String packageName,String packageType,String packageLocation,String packagePrice,String packageFeature,String packageDeatail)
{
	createPackageTextBox.sendKeys(packageName);
	createPackageType.sendKeys(packageType);
	createPackageLocation.sendKeys(packageLocation);
	createPackagePrice.sendKeys(packagePrice);
	createPackagefeatures.sendKeys(packageFeature);
	createPackageDetails.sendKeys(packageDeatail);
	
	
	}
}