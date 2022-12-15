package com.Tourism.Package;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Tourism.OnlineTourism.GenericUtility.BaseClass;
import com.Tourism.OnlineTourism.GenericUtility.FileLib;
import com.Tourism.OnlineTourism.GenericUtility.IConstantPath;
import com.Tourism.OnlineTourism.GenericUtility.PropertyFileKeys;
import com.Tourism.OnlineTourism.GenericUtility.SheetName;
import com.Tourism.OnlineTourism.GenericUtility.WebDriverUtility;
import com.Tourism.OnlineTourism.ObjectRepository.CommonPage;
import com.Tourism.OnlineTourism.ObjectRepository.PackageListPage;
import com.Tourism.OnlineTourism.ObjectRepository.TourismManagementSystemPage;
//@Listeners(com.Tourism.OnlineTourism.GenericUtility.ListenerImplementation.class)
public class CreateTourPackageTest extends BaseClass{
	
	@Test
	public  void createTourPackageTest()
	{
		System.out.println(Thread.currentThread().getId());
        String un = f.readDetaFromPropertyFile(IConstantPath.propertyFilePath,PropertyFileKeys.USERNAME.convertToString() );
		System.out.println(un);
		String phoneNumb=f.readDetaFromPropertyFile(IConstantPath.propertyFilePath, PropertyFileKeys.PHONENUMBER.convertToString());
		System.out.println(phoneNumb);
		String url=f.readDetaFromPropertyFile(IConstantPath.propertyFilePath,PropertyFileKeys.URL.convertToString());
		System.out.println(url);
		String pwd = f.readDetaFromPropertyFile(IConstantPath.propertyFilePath,PropertyFileKeys.PASSWORD.convertToString());
	System.out.println(pwd);
	int t = Integer.parseInt(f.readDetaFromPropertyFile(IConstantPath.propertyFilePath, PropertyFileKeys.TIMEOUT.convertToString()));
	System.out.println(t);
	String changePassword = f.readDetaFromPropertyFile(IConstantPath.propertyFilePath, PropertyFileKeys.PASSWORD.convertToString());
	System.out.println(changePassword);
	String changeUn=f.readDetaFromPropertyFile(IConstantPath.propertyFilePath, PropertyFileKeys.CHANGEUN.convertToString());
	System.out.println(changeUn);
	String fromDate = f.readDetaFromExcel(IConstantPath.ExcelPath,SheetName.SHEETNAME.convertToString(),10,4);
	System.out.println(fromDate);
	String toDate = f.readDetaFromExcel(IConstantPath.ExcelPath,SheetName.SHEETNAME.convertToString(),10,5);	
	String comments = f.readDetaFromExcel(IConstantPath.ExcelPath, SheetName.SHEETNAME.convertToString(), 2, 7);
	System.out.println(comments);
/*	WebDriver driver=null;
	WebDriverUtility webDriver=new WebDriverUtility();
	driver=webDriver.lauchApplication("chrome", t, url);
	 CommonPage cp=new CommonPage(driver);*/
		cp.ClickOnSignInButton();
	TourismManagementSystemPage tmsp=new TourismManagementSystemPage(driver);
	tmsp.loginUnPwd(un, pwd);
	PackageListPage  pp=new PackageListPage(driver);
	pp.PackageListPageModule();

	pp.getDetails();
		WebElement element = pp.getPackageDetails();
		webDriverUtility.waitForElemnetToBeClickAble(driver, element,1);
		pp.tourStartDate();
		pp.StringToWebElement(fromDate).click();
		
		pp.tourEndDate();
		pp.StringToWebElement(toDate).click();
		webDriverUtility.executeJavaScript(driver," window.scrollTo(0,1000)");
			pp.writeOnComments(comments);
		   pp.clickOnBook();
		
	}

}
