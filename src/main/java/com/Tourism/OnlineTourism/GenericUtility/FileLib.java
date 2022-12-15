package com.Tourism.OnlineTourism.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class FileLib {
	String data = null;
	FileInputStream fis=null;
	Workbook wb=null;
	/**
	 * this method is used to open the excel
	 * @param propertyFilePath
	 * @param key
	 * @return
	 */
	@Test
	public void openExcel(String ExcelPath)
	{
		FileInputStream fis=null;
		
		try {
			 fis=new FileInputStream(ExcelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
	
	wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	/**
	 * this method is used to read deta from property file;
	 * @param propertyFilePath
	 * @param key
	 * @return
	 */
	
	
 
	public String readDetaFromPropertyFile(String propertyFilePath,String key) 
	{
		
	
		try {
			fis = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		Properties p=new Properties();
		try {
			p.load(fis);
			
	 //data = p.getProperty(key).trim();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		data = p.getProperty(key).trim();
	return data;

}
 /**
  * this method is used to read deta from excel file file;
  * @param ExcelPath
  * @param sheetname
  * @param row
  * @param cell
  * @return
  */
 
	public String readDetaFromExcel(String ExcelPath,String sheetName,int row,int cell) 
	{
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(ExcelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		Workbook wb=null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*To read String and Numerical Deta from excel
		 * we create Object of Dataformatter class
		*/
		DataFormatter df=new DataFormatter();
	 data = df.formatCellValue(wb.getSheet(sheetName).getRow(row).getCell(cell));
	
		return data;
	}
	public String[][]  readDetaFromExcel(String sheetName) throws Throwable
	{
		
		DataFormatter df=new DataFormatter();
		int  rownum=wb.getSheet(sheetName).getLastRowNum();
		int cellnum=wb.getSheet(sheetName).getRow(0).getLastCellNum();
		String[][] arr=new String[rownum][cellnum];
		for(int i=0;i<rownum;i++)
		{
			for(int j=0;j<cellnum;j++)
			{
				arr[i][j]=df.formatCellValue(wb.getSheet(sheetName).getRow(i+1).getCell(j));
			}
	
		
		}
		return arr;
}}
