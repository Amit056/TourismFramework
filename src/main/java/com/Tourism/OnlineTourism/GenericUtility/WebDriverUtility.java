package com.Tourism.OnlineTourism.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	WebDriver driver=null;
	/**
	 * this method is used to launch the browser
	 * @param browser
	 * @param timeout
	 * @param url
	 * @return
	 */
	public WebDriver lauchApplication(String browser,long timeout,String url)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else
			System.out.println("please enter valid browser");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	/**
	 * this method is used to handle alert popup
	 * @param driver
	 */

	public void swithToAlertWindowAndCancel(WebDriver driver)
	{ 
		driver.switchTo().alert().dismiss();
		}
	/**
	 * this method is used to close the browser
	 * @param driver
	 */
public void closeBrowser(WebDriver driver)
{
	driver.close();
	}
/**
 * this method is used to waitForElemnetTillVisible
 * @param driver
 * @param element
 * @param t
 */
public void waitForElemnetTillVisible(WebDriver driver,WebElement element, int t)
{
	WebDriverWait wait=new WebDriverWait(driver, t);
	wait.until(ExpectedConditions.visibilityOf(element));
	}
/**
 * this method is used to waitForElemnetToBeClickAble
 * @param driver
 * @param element
 * @param t
 */
public void waitForElemnetToBeClickAble(WebDriver driver, WebElement element,int t)
{
	WebDriverWait wait=new WebDriverWait(driver, t);
	wait.until(ExpectedConditions.visibilityOf(element));
	}
/**
 * this method is used to scroll down the webpages
 * @param driver
 * @param javaSc
 */
public void executeJavaScript(WebDriver driver,String javaSc ) {
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript(javaSc );
}
/**
* used to place mouse cursor on specified element
* @param driver
* @param elemnet
*/
public void mouseOverOnElemnet(WebDriver driver , WebElement elemnet)
{
Actions act = new Actions(driver);
act.moveToElement(elemnet).perform();
}
public  int[] GetMonthAndYearIntegerFormat(String month,String year,String patternOfMonth,String patternOfyear) {
	int mm=DateTimeFormatter.ofPattern(patternOfMonth).withLocale(Locale.ENGLISH).parse(month).get(ChronoField.MONTH_OF_YEAR);
	int yy=DateTimeFormatter.ofPattern(patternOfyear).withLocale(Locale.ENGLISH).parse(year).get(ChronoField.YEAR);
int deta[]= {mm,yy};
return deta;

}
/**
 * this method is used for HardAsssert
 */
@Test
public void hardAssert(String actual,String expected)
{
	Assert.assertEquals(actual, expected);
	}
/**
 * this method is used for softAsssert
 */
@Test
public void softAssert(String actual,String expected)
{
	SoftAssert s=new SoftAssert();
	s.assertEquals(actual, expected, "Test CASE pass");
	s.assertAll();
	
	}
/**
 * 
 * this method is used to take screeshot and  to return the path
 */
public void takeScreenShort(String testCaseName)
{	
	Object fileName = testCaseName+"_" + new JavaUtility().getdateTimeInDesiredFormat();
	TakesScreenshot ts=(TakesScreenshot)driver;
File src = ts.getScreenshotAs(OutputType.FILE);
File dest = new File("./screenshot/"+fileName+".png");
try {
	FileUtils.copyFile(src, dest);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
}