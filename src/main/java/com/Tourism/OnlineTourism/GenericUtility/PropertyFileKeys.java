package com.Tourism.OnlineTourism.GenericUtility;

public enum PropertyFileKeys {
	BROWSER(""),URL("url"),PASSWORD("password"),TIMEOUT("timeDuration")	,USERNAME("userName"),CHANGEUN("changeUn"),
	changePassword("changePassword"),MySqlUrl("mySqlUrl"),MySqlUn("mySqlUn"),SQLPWD("sqlpwd"), PHONENUMBER("phoneNumber");
	private String keys;
	 private PropertyFileKeys(String keys)
	 {
this.keys=keys;
	 }
	 public String convertToString()
	 {
		 return keys.toString();
	 }
}
