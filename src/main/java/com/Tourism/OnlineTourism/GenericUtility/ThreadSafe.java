package com.Tourism.OnlineTourism.GenericUtility;

public class ThreadSafe {
private static ThreadLocal<WebDriverUtility> webDriverUtility=new ThreadLocal<>();

public static WebDriverUtility getWebDriverUtility() {
	return webDriverUtility.get();
}

public static void setWebDriverUtility(WebDriverUtility swebDriverUtility) {
	webDriverUtility.set(swebDriverUtility);
}

}
