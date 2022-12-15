package com.Tourism.OnlineTourism.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtility {
	@Test
	public void getdateTime()
	{
		Date date=new Date();
		String dateAndTime = date.toString();
		System.out.println(dateAndTime);
		
	}
	@Test
	public void generateRandomNum()
	{
		Random ran=new Random();
		int a = ran.nextInt(1000);
		System.out.println(a);
		}
	@Test
	public String getdateTimeInDesiredFormat()
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YYYYY_HH_mm_sss");
		String d = sdf.format(date);
		return d;
	}

}
