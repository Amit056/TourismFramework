package com.Tourism.OnlineTourism.GenericUtility;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.Tourism.OnlineTourism.ObjectRepository.CommonPage;
/**
 * this class is used to login and logout the application
 * @author Abhinav
 *
 */


public class BaseClass {
	 protected static    WebDriver driver;
	
 protected static  	WebDriverUtility  webDriverUtility;
protected static  CommonPage cp;
protected static FileLib f;
	@BeforeClass()
	public void openBrowser()
	{
		 f=new FileLib();
		 webDriverUtility=new WebDriverUtility();
		String url = f.readDetaFromPropertyFile(IConstantPath.propertyFilePath,PropertyFileKeys.URL.convertToString());
		driver=  webDriverUtility.lauchApplication("chrome", 10,url);
		ThreadSafe.setWebDriverUtility(webDriverUtility);
		
		cp=new CommonPage(driver);

		}
@BeforeMethod()
public void login()
{
	Reporter.log("login",true);	
	}
@AfterMethod()
public void logout()
{
	Reporter.log("logout",true);
	
	}

@AfterClass()
public void closeBrowser()
{
	Reporter.log(" closeBrowser",true);	
	 webDriverUtility.closeBrowser(driver);
	
	}


}
