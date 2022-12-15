package com.Tourism.Admin.Module;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Tourism.OnlineTourism.GenericUtility.FileLib;
import com.Tourism.OnlineTourism.GenericUtility.IConstantPath;
import com.Tourism.OnlineTourism.GenericUtility.PropertyFileKeys;
import com.Tourism.OnlineTourism.GenericUtility.WebDriverUtility;
import com.Tourism.OnlineTourism.ObjectRepository.AdminDashboardPage;
import com.Tourism.OnlineTourism.ObjectRepository.AdminPackageCreationPage;
import com.Tourism.OnlineTourism.ObjectRepository.AdminSignInPage;
import com.Tourism.OnlineTourism.ObjectRepository.CommonPage;

public class CreateAdminLOginTest {
static WebDriver driver=null;
	public static void main(String[] z) 
	{
		FileLib f=new FileLib();
		String url=f.readDetaFromPropertyFile(IConstantPath.propertyFilePath,PropertyFileKeys.URL.convertToString());
		System.out.println(url);
		String pwd = f.readDetaFromPropertyFile(IConstantPath.propertyFilePath,PropertyFileKeys.PASSWORD.convertToString());
	System.out.println(pwd);
	int t = Integer.parseInt(f.readDetaFromPropertyFile(IConstantPath.propertyFilePath, PropertyFileKeys.TIMEOUT.convertToString()));
	System.out.println(t);
	WebDriver driver=null;
	WebDriverUtility webDriver=new WebDriverUtility();
	driver=webDriver.lauchApplication("chrome", t, url);
		WebDriverWait wait=new WebDriverWait(driver, t);
        CommonPage cp=new CommonPage(driver);
        cp.clickOnAdminLogin();
        AdminSignInPage aa=new AdminSignInPage(driver);
        aa.adminLogin("admin", "Test@123");
        AdminDashboardPage adp=new AdminDashboardPage(driver);
        WebElement element = adp.mousrOverTourPackages();
        webDriver.mouseOverOnElemnet(driver, element);
         adp.clickOnCreate();
        AdminPackageCreationPage apc=new AdminPackageCreationPage(driver);
        apc.createTourPackage("a", "b", "c", "d", "e", "f");
        File f1=new File("./data/Screenshot (3).png");
		String absolutpath = f1.getAbsolutePath();
		System.out.println(absolutpath);
		driver.findElement(By.xpath("//div[@class='form-group' ]//input[@id='packageimage']")).sendKeys(absolutpath);
		WebElement element1 = driver.findElement(By.xpath("//button[.='Create']"));
		webDriver.executeJavaScript(driver, "window.scrollTo(0,1000)" );
		
	driver.findElement(By.xpath("//button[.='Create']")).click();
	
        
	}
}
