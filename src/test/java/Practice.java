import com.Tourism.OnlineTourism.GenericUtility.FileLib;
import com.Tourism.OnlineTourism.GenericUtility.IConstantPath;
import com.Tourism.OnlineTourism.GenericUtility.PropertyFileKeys;
import com.Tourism.OnlineTourism.GenericUtility.SheetName;

public class Practice {

public static void  main(String [] z)
{
	String k = PropertyFileKeys.PASSWORD.convertToString();
	String k1 = PropertyFileKeys.URL.convertToString();
	System.out.println(k);
	System.out.println(k1);
	FileLib f=new FileLib();
	String data = f.readDetaFromPropertyFile(IConstantPath.propertyFilePath, PropertyFileKeys.URL.convertToString());
String data1 = f.readDetaFromPropertyFile(IConstantPath.propertyFilePath, PropertyFileKeys.PASSWORD.convertToString());
System.out.println(data1);
String sh = SheetName.SHEETNAME.convertToString();
System.out.println(sh);
String fromDate = f.readDetaFromExcel(IConstantPath.ExcelPath,"userLogin",10,4);
System.out.println(fromDate);
String toDate = f.readDetaFromExcel(IConstantPath.ExcelPath,SheetName.SHEETNAME.convertToString(),10,5);	
	System.out.println(data1);
	System.out.println(fromDate);
	System.out.println(toDate);
	
	
	}
}