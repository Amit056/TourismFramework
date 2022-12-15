package com.Tourism.Package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DataFromExcel {
	@Test
	public void dataFromExcel() throws Throwable, IOException {
	FileInputStream fis=new FileInputStream("D:\\Users\\Abhinav\\eclipse-workspace\\amitRay\\com.Tourism.OnlineTourism.Framework\\src\\test\\resources\\Book2.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	DataFormatter df=new DataFormatter();
	
	double data = wb.getSheet("UserLogin").getRow(10).getCell(4).getNumericCellValue();
	int toData=(int) data;
	System.out.println(toData);

	

}
}