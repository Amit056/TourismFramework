package com.Tourism.History;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Tourism.OnlineTourism.GenericUtility.BaseClass;
import com.Tourism.OnlineTourism.GenericUtility.IConstantPath;
import com.Tourism.OnlineTourism.GenericUtility.PropertyFileKeys;
import com.Tourism.OnlineTourism.GenericUtility.SheetName;
import com.Tourism.OnlineTourism.ObjectRepository.PackageListPage;
import com.Tourism.OnlineTourism.ObjectRepository.TourismManagementSystemPage;


public class CreateTourHistoryTest extends BaseClass {
	
	//@Test(retryAnalyzer = com.Tourism.OnlineTourism.GenericUtility.RetryImplementationClass.class)
	public static void createTourHistoryTest()
	{
		
        String un = f.readDetaFromPropertyFile(IConstantPath.propertyFilePath,PropertyFileKeys.USERNAME.convertToString());
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
	String expectedDeta = f.readDetaFromExcel(IConstantPath.ExcelPath,SheetName.SHEETNAME.convertToString(),6,3);
		System.out.println(expectedDeta);
	/*WebDriver driver=null;
	GenericUtility.WebDriverUtility webDriver=new GenericUtility.WebDriverUtility();
	driver=webDriver.lauchApplication("chrome", t, url);
	
	CommonPage cp=new CommonPage(driver);*/
	cp.ClickOnSignInButton();

	

	PackageListPage pp=new PackageListPage(driver);
	WebElement element = pp.visibilityOfManagementSystem();
	webDriverUtility.waitForElemnetTillVisible(driver, element, 1);
	
		TourismManagementSystemPage tmsp=new TourismManagementSystemPage(driver);
		tmsp.loginUnPwd(un, pwd);
		tmsp.clickOnMyTourHistoryTestModule();
		
		String actualDeta=tmsp.myTourHistoryTable();
		
		webDriverUtility.hardAssert(actualDeta, expectedDeta);
	}
	

}
