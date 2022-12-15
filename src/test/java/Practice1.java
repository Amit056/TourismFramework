import org.testng.annotations.Test;

import com.Tourism.OnlineTourism.GenericUtility.FileLib;
import com.Tourism.OnlineTourism.GenericUtility.IConstantPath;

public class Practice1 {
	@Test
	public void prin() throws Throwable
	{
		FileLib f=new FileLib();
		f.openExcel(IConstantPath.ExcelPath);
		String[][] data = f.readDetaFromExcel("Sheet1");
		System.out.println(data[1][0]);
		
	}

}
