package com.Tourism.OnlineTourism.GenericUtility;

public enum SheetName {
	SHEETNAME("userLogin");
 private  String keys;
	
		 private SheetName(String keys)
		 {
	this.keys=keys;
		 }
		 /**
		  * this method is used to get sheetname
		  * @return
		  */
		 public String convertToString()
		 {
			 return keys.toString();
		 }
	}


