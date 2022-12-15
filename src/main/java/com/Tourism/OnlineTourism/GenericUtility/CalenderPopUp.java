package com.Tourism.OnlineTourism.GenericUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderPopUp {
	 static WebDriver driver;
	public static void main(String[] args) {
		String requiredMonth="August";
		String requiredYear="2023";
		String requiredDate="15";
		String patternOfMonth="MMMM";
		String patternOfYear="yyy";
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		driver=webDriverUtility.lauchApplication("chrome", 10, "http://rmgtestingserver:8888/index.php?module=Calendar&action=index");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
	driver.findElement(By.xpath("//a[.='All Events & Todos']/preceding::img[@src='themes/softed/images/btnL3Calendar.gif' and @alt='Open Calendar...']")).click();
	//String currentMonthYear = driver.findElement(By.xpath("//td[@class='calHdr' and @align='center']/a/b")).getText();
	int[] requiredMonthYear = webDriverUtility.GetMonthAndYearIntegerFormat(requiredMonth, requiredYear, patternOfMonth, patternOfYear);
	int rMonth=requiredMonthYear[0];
	System.out.println(rMonth);
	int rYear=requiredMonthYear[1];
	System.out.println(rYear);
	String currentMonthYear = driver.findElement(By.xpath("//td[@class='calHdr' and @align='center']/a/b")).getText();
String actualMonth = currentMonthYear.split(" ")[0];

String actualYear = currentMonthYear.split(" ")[1];

int[] CurrentmonthYear = webDriverUtility.GetMonthAndYearIntegerFormat(actualMonth, actualYear, patternOfMonth, patternOfYear);
int cMonth=CurrentmonthYear[0];
int cYear=CurrentmonthYear[1];
//while(!(requiredMonth.equals(actualMonth) && requiredYear.equals(actualYear)))
while(cMonth>rMonth || cYear>rYear)
{
	driver.findElement(By.xpath("//img[@src='themes/images/small_right.gif']")).click();
	WebDriverWait wait =new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//td[@class='calHdr' and @align='center']/a/b"), currentMonthYear));
	currentMonthYear = driver.findElement(By.xpath("//td[@class='calHdr' and @align='center']/a/b")).getText();
	System.out.println(currentMonthYear);
	 actualMonth= currentMonthYear.split(" ")[0];

	 actualYear = currentMonthYear.split(" ")[1];
	}
driver.findElement(By.xpath("//a[.='"+requiredDate+"']")).click();
	}

}
