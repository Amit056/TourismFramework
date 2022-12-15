package com.Tourism.OnlineTourism.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	String testCaseName = result.getName();
	ThreadSafe.getWebDriverUtility().takeScreenShort(testCaseName);
		
		
				
	}


}
