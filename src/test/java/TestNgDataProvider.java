



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Tourism.OnlineTourism.GenericUtility.FileLib;
import com.Tourism.OnlineTourism.GenericUtility.IConstantPath;

public class TestNgDataProvider {
	@Test(dataProvider = "getObject")
	public void test(String userName,String password)//parameters should be equal to number of columns
	{
		System.out.println("username=======>"+userName+"------"+"password======>"+password);
		
	}
	@DataProvider()
	public String[][] getObject() throws Throwable 
	{
		FileLib f=new FileLib();
		f.openExcel(IConstantPath.ExcelPath);
		
		String[][] arr=f.readDetaFromExcel("Sheet1");
		
		
		return arr;
	
	}
	

}
