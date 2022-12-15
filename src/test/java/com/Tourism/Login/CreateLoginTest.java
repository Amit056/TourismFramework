package com.Tourism.Login;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Tourism.OnlineTourism.GenericUtility.BaseClass;
import com.Tourism.OnlineTourism.GenericUtility.IConstantPath;
import com.Tourism.OnlineTourism.GenericUtility.PropertyFileKeys;
import com.Tourism.OnlineTourism.ObjectRepository.TourismManagementSystemPage;


//@Listeners(com.Tourism.OnlineTourism.GenericUtility.ListenerImplementation.class)
public class CreateLoginTest extends BaseClass{
	@Test
	public  void createLoginTest()
	{
		System.out.println(Thread.currentThread().getId());
		
        String un = f.readDetaFromPropertyFile(IConstantPath.propertyFilePath,PropertyFileKeys.USERNAME.convertToString());
		System.out.println(un);
		String phoneNumb=f.readDetaFromPropertyFile(IConstantPath.propertyFilePath, PropertyFileKeys.PHONENUMBER.convertToString());
		System.out.println(phoneNumb);
		//String url=f.readDetaFromPropertyFile(IConstantPath.propertyFilePath,PropertyFileKeys.URL.convertToString());
		//System.out.println(url);
		String pwd = f.readDetaFromPropertyFile(IConstantPath.propertyFilePath,PropertyFileKeys.PASSWORD.convertToString());
	System.out.println(pwd);
	int t = Integer.parseInt(f.readDetaFromPropertyFile(IConstantPath.propertyFilePath, PropertyFileKeys.TIMEOUT.convertToString()));
	System.out.println(t);
	String changePassword = f.readDetaFromPropertyFile(IConstantPath.propertyFilePath, PropertyFileKeys.PASSWORD.convertToString());
	System.out.println(changePassword);
	String changeUn=f.readDetaFromPropertyFile(IConstantPath.propertyFilePath, PropertyFileKeys.CHANGEUN.convertToString());
	System.out.println(changeUn);
	
/*	WebDriver driver=null;
	WebDriverUtility webDriver=new WebDriverUtility();
	driver=webDriver.lauchApplication("chrome", t, url);*/
		
       // CommonPage cp=new CommonPage(driver);
		cp.ClickOnSignInButton();
		
		TourismManagementSystemPage tmsp=new TourismManagementSystemPage(driver);
		tmsp.loginUnPwd(un, pwd);

		tmsp.myProfile();
		tmsp.changeUn(changeUn);
		tmsp.changePhoneNumTextBox(phoneNumb);
		tmsp.updateButton();
		tmsp.logoutButton();

	
		
	}

}
